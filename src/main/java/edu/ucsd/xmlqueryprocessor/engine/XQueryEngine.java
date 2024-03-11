package edu.ucsd.xmlqueryprocessor.engine;

import edu.ucsd.xmlqueryprocessor.parser.XQueryParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;

import static edu.ucsd.xmlqueryprocessor.engine.XPathEngine.createSet;
import static edu.ucsd.xmlqueryprocessor.parser.XMLParser.dumpDocument;
import static edu.ucsd.xmlqueryprocessor.util.Constants.*;

public class XQueryEngine {

    private final String outputDirectory;
    private final XPathEngine xpathEngine;
    XQueryParser parser;
    private Document document;

    public XQueryEngine(String fileDirectory, String outputDirectory) {
        this.outputDirectory = outputDirectory;
        xpathEngine = new XPathEngine(fileDirectory);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (Exception ignored) {
        }
    }

    private static void printNodeAttributes(Node tuple) {
        for (int i = 0; i < tuple.getChildNodes().getLength(); i++) {
            Node child = tuple.getChildNodes().item(i);
            System.out.print(child.getNodeName() + " ");
        }
        System.out.println();
    }

    private HashMap<String, Node> createHashMap() {
        return new HashMap<>(10);
    }

    public void evaluate(String query, String outputFileName) {
        Set<Node> result = process(query);
        if (result.size() != 1) {
            Element root = document.createElement("RESULT");
            for (Node node : result) {
                root.appendChild(document.importNode(node, true));
            }
            document.appendChild(root);
        } else {
            document.appendChild(document.importNode(result.iterator().next(), true));
        }
        String outputFilePath = outputDirectory + outputFileName;
        dumpDocument(document, outputFilePath);
    }

    public Set<Node> process(String query) {
        parser = new XQueryParser(query);
        ParseTree tree = parser.getTree();
        return processXQuery(tree, createHashMap());
    }

    public void processInStatement(String varName, ParseTree xquery, List<HashMap<String, Node>> varHashMapList) {
        if (varHashMapList.isEmpty()) {
            for (Node node : processXQuery(xquery, null)) {
                HashMap<String, Node> varHashMap = createHashMap();
                varHashMap.put(varName, node);
                varHashMapList.add(varHashMap);
            }
        } else {
            List<HashMap<String, Node>> newVarHashMapList = new ArrayList<>();
            for (HashMap<String, Node> varHashMap : varHashMapList) {
                Set<Node> xqueryResult = processXQuery(xquery, varHashMap);
                for (Node node : xqueryResult) {
                    newVarHashMapList.add(new HashMap<>(varHashMap) {
                        {
                            put(varName, node);
                        }
                    });
                }
            }
            varHashMapList.clear();
            varHashMapList.addAll(newVarHashMapList);
        }
    }

    public void processForClause(ParseTree tree, List<HashMap<String, Node>> varHashMapList) {
        int childCount = tree.getChildCount();
        String varName;
        ParseTree xquery;
        ParseTree forClause;
        switch (childCount) {
            case 4:
                // 'for' var 'in' xquery
                varName = tree.getChild(1).getText();
                xquery = tree.getChild(3);
                processInStatement(varName, xquery, varHashMapList);
                return;
            case 5:
                // forClause ',' var 'in' xquery
                forClause = tree.getChild(0);
                processForClause(forClause, varHashMapList);
                varName = tree.getChild(2).getText();
                xquery = tree.getChild(4);
                processInStatement(varName, xquery, varHashMapList);
                return;
            default:
                throw new IllegalArgumentException("processForClause: invalid child count");
        }
    }

    public Set<Node> processXQuery(ParseTree tree, HashMap<String, Node> varHashMap) {
        Map<String, List<Object>> children = parser.getChildren(tree);
        int childCount = tree.getChildCount();
        if (childCount == 1) {
            if (children.containsKey(KEY_VAR)) {
                // var
                assert varHashMap.containsKey(tree.getText());
                return createSet(varHashMap.get(tree.getText()));
            } else if (children.containsKey(KEY_STRING_CONSTANT)) {
                // stringConstant
                return createSet(document.createTextNode(tree.getText()));
            } else if (children.containsKey(KEY_ABSOLUTE_PATH)) {
                // absolutePath
                return xpathEngine.processAbsolutePath(tree.getChild(0));
            } else if (children.containsKey(KEY_JOIN)) {
                // joinClause
                return processJoin(tree.getChild(0), varHashMap);
            } else if (children.containsKey(KEY_TUPLE)) {
                // tuple
                return processTuple(tree.getChild(0), varHashMap);
            } else {
                throw new IllegalArgumentException("processXQuery: invalid key: " + children.keySet());
            }
        } else if (children.containsKey(KEY_FOR_CLAUSE)) {
            // forClause letClause? whereClause? returnClause
            List<HashMap<String, Node>> varHashMapList = new ArrayList<>();
            varHashMapList.add(varHashMap);
            processForClause((ParseTree) children.get(KEY_FOR_CLAUSE).get(0), varHashMapList);

            if (children.containsKey(KEY_LET_CLAUSE)) {
                processLetClause((ParseTree) children.get(KEY_LET_CLAUSE).get(0), varHashMapList);
            }
            if (children.containsKey(KEY_WHERE_CLAUSE)) {
                processWhereClause((ParseTree) children.get(KEY_WHERE_CLAUSE).get(0), varHashMapList);
            }

            ParseTree returnClause = (ParseTree) children.get(KEY_RETURN_CLAUSE).get(0);
            Set<Node> res = createSet();
            for (HashMap<String, Node> varHashMapItem : varHashMapList) {
                res.addAll(processReturnClause(returnClause, varHashMapItem));
            }
            return res;
        } else if (children.containsKey(KEY_LET_CLAUSE)) {
            // letClause xquery
            ParseTree letClause = tree.getChild(0);
            ParseTree xquery = tree.getChild(1);
            List<HashMap<String, Node>> varHashMapList = new ArrayList<>();
            if (!varHashMap.isEmpty()) {
                varHashMapList.add(varHashMap);
            }
            processLetClause(letClause, varHashMapList);

            Set<Node> res = createSet();
            for (HashMap<String, Node> varHashMapItem : varHashMapList) {
                res.addAll(processXQuery(xquery, varHashMapItem));
            }
            return res;
            // throw new NotImplementedException("processXQuery: letClause xquery not implemented");
        } else if (children.containsKey(KEY_TAG_NAME)) {
            // '<' tagName '>' '{' xquery '}' '</' tagName '>'
            String tagName = tree.getChild(1).getText();
            ParseTree xquery = tree.getChild(4);
            Set<Node> xqueryResult = processXQuery(xquery, varHashMap);

            Node newNode = document.createElement(tagName);
            for (Node node : xqueryResult) {
                newNode.appendChild(document.importNode(node, true));
            }
            return createSet(newNode);
        } else {
            assert childCount == 3;
            if (tree.getChildCount() > 0 && LEFT_PARENTHESIS.equals(tree.getChild(0).getText())) {
                // '(' xquery ')'
                return processXQuery(tree.getChild(1), varHashMap);
            } else {
                if (children.containsKey(KEY_RELATIVE_PATH)) {
                    // xquery '/' relativePath
                    // xquery '//' relativePath
                    String xqueryOp = tree.getChild(1).getText();
                    ParseTree xquery = tree.getChild(0);
                    ParseTree relativePath = tree.getChild(2);
                    return xpathEngine.processRelativePath(processXQuery(xquery, varHashMap), relativePath, xqueryOp);

                } else {
                    // xquery ',' xquery
                    assert ",".equals(tree.getChild(1).getText());
                    Set<Node> left = processXQuery(tree.getChild(0), varHashMap);
                    Set<Node> right = processXQuery(tree.getChild(2), varHashMap);
                    left.addAll(right);
                    return left;
                }
            }
        }
    }

    private Set<Node> processTuple(ParseTree tree, HashMap<String, Node> varHashMap) {
        // '<tuple>' xquery (',' xquery)+ '</tuple>';
        Node tuple = document.createElement("tuple");
        for (int i = 1; i < tree.getChildCount() - 1; i += 2) {
            Set<Node> xqueryResult = processXQuery(tree.getChild(i), varHashMap);
            for (Node node : xqueryResult) {
                tuple.appendChild(document.importNode(node, true));
            }
        }
        return createSet(tuple);
    }

    private HashMap<String, Set<Node>> getKeyValueHashMap(String key, Set<Node> nodes) {
        HashMap<String, Set<Node>> keyValueHashMap = new LinkedHashMap<>();
        for (Node node : nodes) {
            NodeList childNodes = node.getChildNodes();
            String keyValue = getKeyValueFromNodeList(key, childNodes);
            if (keyValue != null) {
                if (keyValueHashMap.containsKey(keyValue)) {
                    keyValueHashMap.get(keyValue).add(node);
                } else {
                    Set<Node> set = createSet();
                    set.add(node);
                    keyValueHashMap.put(keyValue, set);
                }
            }
        }
        return keyValueHashMap;
    }

    public Set<Node> processJoin(ParseTree tree, HashMap<String, Node> varHashMap) {
        // 'join' '(' xquery ',' xquery ',' '[' key ']' ',' '[' key ']' ')';
        Set<Node> leftXqueryResults = processXQuery(tree.getChild(2), varHashMap);
        Set<Node> rightXqueryResults = processXQuery(tree.getChild(4), varHashMap);
        String leftKey = tree.getChild(7).getText();
        String rightKey = tree.getChild(11).getText();
        HashMap<String, Set<Node>> leftKeyValueHashMap = getKeyValueHashMap(leftKey, leftXqueryResults);
        HashMap<String, Set<Node>> rightKeyValueHashMap = getKeyValueHashMap(rightKey, rightXqueryResults);

        List<String> commonKeys = new ArrayList<>(leftKeyValueHashMap.keySet());
        commonKeys.retainAll(rightKeyValueHashMap.keySet());

        Set<Node> res = createSet();
        for (String commonKey : commonKeys) {
            Set<Node> leftNodes = leftKeyValueHashMap.get(commonKey);
            Set<Node> rightNodes = rightKeyValueHashMap.get(commonKey);
            for (Node leftNode : leftNodes) {
                for (Node rightNode : rightNodes) {
                    Element tuple = document.createElement("tuple");
                    for (int i = 0; i < leftNode.getChildNodes().getLength(); i++) {
                        Node leftChildNode = leftNode.getChildNodes().item(i);
                        if (leftChildNode.getNodeType() == Node.ELEMENT_NODE) {
                            tuple.appendChild(document.importNode(leftChildNode, true));
                        }
                    }
                    for (int i = 0; i < rightNode.getChildNodes().getLength(); i++) {
                        Node rightChildNode = rightNode.getChildNodes().item(i);
                        if (rightChildNode.getNodeType() == Node.ELEMENT_NODE) {
                            tuple.appendChild(document.importNode(rightChildNode, true));
                        }
                    }
                    res.add(tuple);
                }
            }
        }


//        for (Node leftNode : leftXqueryResults) {
//            for (Node rightNode : rightXqueryResults) {
//                NodeList leftChildNodes = leftNode.getChildNodes();
//                NodeList rightChildNodes = rightNode.getChildNodes();
//                String leftKeyValue = getKeyValueFromNodeList(leftKey, leftChildNodes);
//                String rightKeyValue = getKeyValueFromNodeList(rightKey, rightChildNodes);
//
//                if (leftKeyValue != null && leftKeyValue.equals(rightKeyValue)) {
//                    Element tuple = document.createElement("tuple");
//                    for (int i = 0; i < leftChildNodes.getLength(); i++) {
//                        Node leftChildNode = leftChildNodes.item(i);
//                        if (leftChildNode.getNodeType() == Node.ELEMENT_NODE) {
//                            tuple.appendChild(document.importNode(leftChildNode, true));
//                        }
//                    }
//                    for (int i = 0; i < rightChildNodes.getLength(); i++) {
//                        Node rightChildNode = rightChildNodes.item(i);
//                        if (rightChildNode.getNodeType() == Node.ELEMENT_NODE) {
//                            tuple.appendChild(document.importNode(rightChildNode, true));
//                        }
//                    }
//                    res.add(tuple);
//                }
//            }
//        }
        return res;
    }

    private String getKeyValueFromNodeList(String key, NodeList rightChildNodes) {
        String keyValue = null;
        for (int i = 0; i < rightChildNodes.getLength(); i++) {
            Node rightChildNode = rightChildNodes.item(i);
            if (rightChildNode.getNodeType() == Node.ELEMENT_NODE && rightChildNode.getNodeName().equals(key)) {
                keyValue = rightChildNode.getTextContent();
                break;
            }
        }
        return keyValue;
    }

    public void processLetClause(ParseTree tree, List<HashMap<String, Node>> varHashMapList) {
        int childCount = tree.getChildCount();
        String varName;
        ParseTree xquery;
        ParseTree letClause;
        switch (childCount) {
            case 4:
                // 'let' var ':=' xquery
                varName = tree.getChild(1).getText();
                xquery = tree.getChild(3);
                processInStatement(varName, xquery, varHashMapList);
                return;
            case 5:
                // letClause ',' var ':=' xquery
                letClause = tree.getChild(0);
                processLetClause(letClause, varHashMapList);
                varName = tree.getChild(2).getText();
                xquery = tree.getChild(4);
                processInStatement(varName, xquery, varHashMapList);
                return;
            default:
                throw new IllegalArgumentException("processLetClause: invalid child count");
        }
    }

    public void processWhereClause(ParseTree tree, List<HashMap<String, Node>> varHashMapList) {
        // 'where' cond
        ParseTree cond = tree.getChild(1);
        List<HashMap<String, Node>> newVarHashMapList = new ArrayList<>();
        for (HashMap<String, Node> varHashMap : varHashMapList) {
            if (processCond(cond, varHashMap)) {
                newVarHashMapList.add(varHashMap);
            }
        }

        varHashMapList.clear();
        varHashMapList.addAll(newVarHashMapList);
    }

    public Set<Node> processReturnClause(ParseTree tree, HashMap<String, Node> varHashMap) {
        // 'return' xquery
        ParseTree xquery = tree.getChild(1);
        return processXQuery(xquery, varHashMap);
    }

    public boolean processCond(ParseTree tree, HashMap<String, Node> varHashMap) {
        int childCount = tree.getChildCount();
        switch (childCount) {
            case 2:
                // 'not' cond
                return !processCond(tree.getChild(1), varHashMap);
            case 3:
                if (LEFT_PARENTHESIS.equals(tree.getChild(0).getText())) {
                    // '(' cond ')'
                    return processCond(tree.getChild(1), varHashMap);
                } else {
                    // xquery '=' xquery
                    // xquery 'eq' xquery
                    // xquery '==' xquery
                    // xquery 'is' xquery
                    // cond 'and' cond
                    // cond 'or' cond
                    String op = tree.getChild(1).getText();
                    return processCond(tree.getChild(0), tree.getChild(2), op, varHashMap);
                }
            case 4:
                // 'empty' '(' xquery ')'
                return processXQuery(tree.getChild(2), varHashMap).isEmpty();
            case 6:
                // 'some' var 'in' xquery 'satisfies' cond
                String varName = tree.getChild(1).getText();
                ParseTree xquery = tree.getChild(3);
                ParseTree subCond = tree.getChild(5);
                List<HashMap<String, Node>> varHashMapList = new ArrayList<>();
                varHashMapList.add(varHashMap);
                processInStatement(varName, xquery, varHashMapList);
                for (HashMap<String, Node> newVarHashMap : varHashMapList) {
                    if (processCond(subCond, newVarHashMap)) {
                        return true;
                    }
                }
                return false;
            default:
                throw new IllegalArgumentException("processCond: invalid child count");
        }
    }

    public boolean processCond(ParseTree left, ParseTree right, String op, HashMap<String, Node> varHashMap) {
        switch (op) {
            case "=":
            case "eq":
                Set<Node> leftSet = processXQuery(left, varHashMap);
                Set<Node> rightSet = processXQuery(right, varHashMap);
                if (rightSet.size() == 1) {
                    String rightNodeStr = rightSet.iterator().next().getTextContent();
                    if (QUOTE.equals(rightNodeStr.substring(0, 1))) {
                        // xquery '=' stringConstant
                        rightNodeStr = rightNodeStr.substring(1, rightNodeStr.length() - 1);
                        for (Node leftNode : leftSet) {
                            String leftNodeStr = leftNode.getTextContent();
                            if (leftNodeStr.equals(rightNodeStr)) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
                // xquery '=' xquery
                // xquery 'eq' xquery
                if (leftSet.size() != rightSet.size()) {
                    return false;
                } else {
                    Iterator<Node> leftItr = leftSet.iterator();
                    Iterator<Node> rightItr = rightSet.iterator();
                    while (leftItr.hasNext()) {
                        Node leftNode = leftItr.next();
                        Node rightNode = rightItr.next();
                        if (!leftNode.getTextContent().equals(rightNode.getTextContent())) {
                            return false;
                        }
                    }
                    return true;
                }
            case "==":
            case "is":
                // xquery '==' xquery
                // xquery 'is' xquery
                Set<Node> isLeftSet = processXQuery(left, varHashMap);
                Set<Node> isRightSet = processXQuery(right, varHashMap);
                Iterator<Node> leftItr = isLeftSet.iterator();
                Iterator<Node> rightItr = isRightSet.iterator();
                while (leftItr.hasNext()) {
                    Node leftNode = leftItr.next();
                    Node rightNode = rightItr.next();
                    if (!leftNode.isSameNode(rightNode)) {
                        return false;
                    }
                }
                return true;
            case "and":
                // cond 'and' cond
                return processCond(left, varHashMap) && processCond(right, varHashMap);
            case "or":
                // cond 'or' cond
                return processCond(left, varHashMap) || processCond(right, varHashMap);
            default:
                throw new IllegalArgumentException("processCond: invalid op: " + op);
        }
    }
}