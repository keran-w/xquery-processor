package edu.ucsd.xmlqueryprocessor.engine;

import edu.ucsd.xmlqueryprocessor.antlr4.xquery.XQueryGrammarBaseVisitor;
import edu.ucsd.xmlqueryprocessor.parser.XQueryParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.NotImplementedException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;

import static edu.ucsd.xmlqueryprocessor.engine.XPathEngine.createSet;
import static edu.ucsd.xmlqueryprocessor.parser.XMLParser.dumpDocument;

public class XQueryEngine extends XQueryGrammarBaseVisitor<Set<Node>> {
    XQueryParser parser;

    String FILE_DIRECTORY = "data/";

    XPathEngine xpathEngine = new XPathEngine(FILE_DIRECTORY);

    private Document document;

    public XQueryEngine() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        final String SAMPLE_QUERY_1 = "<result>\n" + "  {\n" + "    for $a in doc(\"j_caesar.xml\")//ACT, $sc in $a//SCENE, $sp in $sc/SPEECH\n" + "    where $sp/LINE/text() = \"Et tu, Brute! Then fall, Caesar.\"\n" + "    return \n" + "    <who>{$sp/SPEAKER/text()}</who>,\n" + "    <when>{\n" + "      <act>{$a/TITLE/text()}</act>,\n" + "      <scene>{$sc/TITLE/text()}</scene>}\n" + "    </when>\n" + "  }\n" + "</result> ";
        final String SAMPLE_QUERY_2 = "<result>{ \n" + "for $s in doc(\"j_caesar.xml\")//SPEAKER\n" + "return <speaks>{<who>{$s/text()}</who>,\n" + " for $a in doc(\"j_caesar.xml\")//ACT\n" + " where some $s1 in $a//SPEAKER satisfies $s1 eq $s\n" + " return <when>{$a/TITLE/text()}</when>}\n" + " </speaks>\n" + "}</result> ";
        String sample = SAMPLE_QUERY_2;
        System.out.println("SAMPLE_QUERY: " + sample);
        XQueryEngine engine = new XQueryEngine();
        engine.process(sample);
    }

    /* Decorator function to print out the name of the node being processed */
    private Map<String, List<Object>> getChildren(ParseTree tree, String name) {
        System.out.println("Processing " + name + ": " + tree.getText());
        Map<String, List<Object>> children = parser.getChildren(tree);
        System.out.println("\tChildren key set: " + children.keySet());
        for (String key : children.keySet()) {
            if (Objects.equals(key, "otherChildren")) {
                System.out.println("\t\t" + key + ": " + children.get(key));
            } else {
                for (Object child : children.get(key)) {
                    System.out.println("\t\t" + key + ": " + ((ParseTree) child).getText());
                }
            }
        }

        return children;
    }

    public void process(String query) {
        parser = new XQueryParser(query);
        ParseTree tree = parser.getTree();
        Set<Node> result = processXQuery(tree, new HashMap<>());
        if (result.size() != 1) {
            Element root = document.createElement("result");
            for (Node node : result) {
                root.appendChild(document.importNode(node, true));
            }
            document.appendChild(root);
        } else {
            document.appendChild(document.importNode(result.iterator().next(), true));
        }

        dumpDocument(document, "m2-output.xml");
    }


    public void processForClause(ParseTree tree, List<HashMap<String, Node>> varHashMapList) {
        Map<String, List<Object>> children = getChildren(tree, "forClause");
        int childCount = tree.getChildCount();
        String varName;
        ParseTree xquery;
        ParseTree forClause;
        switch (childCount) {
            case 4:
                // 'for' var 'in' xquery
                varName = tree.getChild(1).getText();
                xquery = tree.getChild(3);
                assert varHashMapList.isEmpty();
                for (Node node : processXQuery(xquery, null)) {
                    HashMap<String, Node> varHashMap = new HashMap<>();
                    varHashMap.put(varName, node);
                    varHashMapList.add(varHashMap);
                }
                return;
            case 5:
                // forClause ',' var 'in' xquery
                forClause = tree.getChild(0);
                processForClause(forClause, varHashMapList);
                varName = tree.getChild(2).getText();
                xquery = tree.getChild(4);
                List<HashMap<String, Node>> newVarHashMapList = new ArrayList<>();
                for (HashMap<String, Node> varHashMap : varHashMapList) {
                    for (Node node : processXQuery(xquery, varHashMap)) {
                        newVarHashMapList.add(new HashMap<String, Node>(varHashMap) {{
                            put(varName, node);
                        }});
                    }

                }
                varHashMapList.clear();
                varHashMapList.addAll(newVarHashMapList);
                return;
            default:
                throw new NotImplementedException("processForClause: invalid child count");
        }
    }

//    List<HashMap<String, Node>> varHashMapList

    public Set<Node> processXQuery(ParseTree tree, HashMap<String, Node> varHashMap) {
        Map<String, List<Object>> children = getChildren(tree, "xquery");
        int childCount = tree.getChildCount();
        if (childCount == 1) {
            if (children.containsKey("var")) {
                // var
                assert varHashMap.containsKey(tree.getText());
                return createSet(varHashMap.get(tree.getText()));
            } else if (children.containsKey("stringConstant")) {
                // stringConstant
                throw new NotImplementedException("processXQuery: stringConstant not implemented");
            } else if (children.containsKey("absolutePath")) {
                // absolutePath
                return xpathEngine.processAbsolutePath(tree.getChild(0));
            } else {
                throw new NotImplementedException("processXQuery: invalid key: " + children.keySet());
            }

        } else if (children.containsKey("forClause")) {
            // forClause letClause? whereClause? returnClause
            List<HashMap<String, Node>> varHashMapList = new ArrayList<>();
            processForClause((ParseTree) children.get("forClause").get(0), varHashMapList);
            System.out.println("varHashMapList: " + varHashMapList);

            if (children.containsKey("letClause")) {
                processLetClause((ParseTree) children.get("letClause").get(0));
            }
            if (children.containsKey("whereClause")) {
                // TODO: process whereClause with equality
                // processWhereClause((ParseTree) children.get("whereClause").get(0));
            }

            ParseTree returnClause = (ParseTree) children.get("returnClause").get(0);
            Set<Node> res = createSet();
            for (HashMap<String, Node> varHashMapItem : varHashMapList) {
                res.addAll(processReturnClause(returnClause, varHashMapItem));
            }
            return res;
        } else if (children.containsKey("letClause")) {
            // letClause xquery
            throw new NotImplementedException("processXQuery: letClause not implemented");
        } else if (children.containsKey("tagName")) {
            // '<' tagName '>' '{' xquery '}' '</' tagName '>'
            String tagName = tree.getChild(1).getText();
            ParseTree xquery = tree.getChild(4);
            Set<Node> xqueryResult = processXQuery(xquery, varHashMap);
            System.out.println("tagName: " + tagName);

            Node newNode = document.createElement(tagName);
            for (Node node : xqueryResult) {
                newNode.appendChild(document.importNode(node, true));
            }
            return createSet(newNode);
        } else {
            assert childCount == 3;
            if ("(".equals(tree.getChild(0).getText())) {
                // '(' xquery ')'
                throw new NotImplementedException("processXQuery: '(' xquery ')' not implemented");
            } else {
                if (children.containsKey("relativePath")) {
                    // xquery '/' relativePath
                    // xquery '//' relativePath
                    String xqueryOp = tree.getChild(0).getText();
                    String relativePath = tree.getChild(2).getText();
                    System.out.println("processXQuery: " + xqueryOp + " / " + relativePath);
                    return xpathEngine.processRelativePath(processXQuery(tree.getChild(0), varHashMap), tree.getChild(2), xqueryOp);

                } else {
                    // xquery ',' xquery
                    Set<Node> left = processXQuery(tree.getChild(0), varHashMap);
                    Set<Node> right = processXQuery(tree.getChild(2), varHashMap);
                    left.addAll(right);
                    return left;
                }
            }
        }
    }

    public Set<Node> processLetClause(ParseTree tree) {
        Map<String, List<Object>> children = getChildren(tree, "letClause");
        int childCount = tree.getChildCount();
        switch (childCount) {
            case 4:
                // 'let' var ':=' xquery
                throw new NotImplementedException("processLetClause: 'let' var ':=' xquery not implemented");
            case 5:
                // letClause ',' var ':=' xquery
                throw new NotImplementedException("processLetClause: letClause ',' var ':=' xquery not implemented");
            default:
                throw new NotImplementedException("processLetClause: invalid child count");
        }
    }

    public Set<Node> processWhereClause(ParseTree tree) {
        // 'where' cond
        Map<String, List<Object>> children = getChildren(tree, "whereClause");
        ParseTree cond = (ParseTree) children.get("cond").get(1);
        throw new NotImplementedException("processWhereClause: cond not implemented");
    }

    public Set<Node> processReturnClause(ParseTree tree, HashMap<String, Node> varHashMap) {
        // 'return' xquery
        Map<String, List<Object>> children = getChildren(tree, "returnClause");
        ParseTree xquery = tree.getChild(1);
        return processXQuery(xquery, varHashMap);
    }

    public Set<Node> processCond(ParseTree tree) {
        Map<String, List<Object>> children = getChildren(tree, "cond");
        int childCount = tree.getChildCount();
        switch (childCount) {
            case 2:
                // 'not' cond
                throw new NotImplementedException("processCond: 'not' cond not implemented");
            case 3:
                // xquery '=' xquery
                // xquery 'eq' xquery
                // xquery '==' xquery
                // xquery 'is' xquery
                // '(' cond ')'
                // cond 'and' cond
                // cond 'or' cond
                throw new NotImplementedException("processCond: cond 'and' cond, cond 'or' cond not implemented");
            case 4:
                // 'empty' '(' xquery ')'
                throw new NotImplementedException("processCond: 'empty' '(' xquery ')' not implemented");
            case 6:
                // 'some' var 'in' xquery 'satisfies' cond
                ParseTree var = tree.getChild(1);
                ParseTree xquery = tree.getChild(3);
                ParseTree subCond = tree.getChild(5);
                throw new NotImplementedException("processCond: 'some' var 'in' xquery 'satisfies' cond not implemented");
            default:
                throw new NotImplementedException("processCond: invalid child count");
        }
    }


}
