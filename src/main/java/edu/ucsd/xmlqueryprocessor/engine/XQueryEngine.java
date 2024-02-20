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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static edu.ucsd.xmlqueryprocessor.engine.XPathEngine.createSet;
import static edu.ucsd.xmlqueryprocessor.parser.XMLParser.dumpDocument;

public class XQueryEngine extends XQueryGrammarBaseVisitor<Set<Node>> {
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

    public static void main(String[] args) {
        final String SAMPLE_QUERY_1 = "<result>{\n" + "    for\n" + "        $a in doc(\"j_caesar.xml\")//ACT, \n" + "        $sc in $a//SCENE, \n" + "        $sp in $sc/SPEECH\n" + "\n" + "    where \n" + "        $sp/LINE/text() = \"Et tu, Brute! Then fall, Caesar.\"\n" + "\n" + "    return \n" + "        <who>{\n" + "            $sp/SPEAKER/text()\n" + "        }</who>,\n" + "\n" + "        <when>{\n" + "            <act>{$a/TITLE/text()}</act>,\n" + "            <scene>{$sc/TITLE/text()}</scene>\n" + "        }</when>\n" + "}</result> ";
        final String SAMPLE_QUERY_2 = "<result>{\n" + "    for\n" + "        $s in doc(\"j_caesar.xml\")//SPEAKER\n" + "    return \n" + "        <speaks>{\n" + "            <who>{\n" + "                $s/text()\n" + "            }</who>,\n" + "\n" + "            for \n" + "                $a in doc(\"j_caesar.xml\")//ACT\n" + "            where \n" + "                some $s1 in $a//SPEAKER satisfies $s1 eq $s\n" + "            return <when>{\n" + "                $a/TITLE/text()\n" + "            }</when>\n" + "        }</speaks>\n" + "}</result> ";
        final String SAMPLE_QUERY_3 = "<result>{\n" + "  for\n" + "    $a in doc(\"j_caesar.xml\")//PERSONAE, \n" + "    $b in $a/PERSONA \n" + "  where not (($b/text() = \"JULIUS CAESAR\") or ($b/text() = \"Another Poet\") )\n" + "  return $b\n" + "}</result>";
        final String SAMPLE_QUERY_4 = "<acts>{\n" + "  for $a in doc(\"j_caesar.xml\")//ACT\n" + "  where not (\n" + "    for $sp in $a/SCENE/SPEECH  \n" + "    where ($sp/SPEAKER/text() = \"FLAVIUS\" and $sp/../TITLE/text()=\"SCENE I.  Rome. A street.\")\n" + "    return <speaker>{ $sp/text() }</speaker> \n" + "  )\n" + "  return <act>{$a/TITLE/text()}</act> \n" + "}</acts>";
        final String SAMPLE_QUERY_5 = "<result>{\n" + "  for $s in doc(\"j_caesar.xml\")//SCENE\n" + "  where $s//SPEAKER/text()=\"CAESAR\"  \n" + "  return <scenes>{ \n" + "    <scene> {\n" + "      $s/TITLE/text()\n" + "    }</scene>, \n" + "    for $a in doc(\"j_caesar.xml\")//ACT\n" + "    where some $s1 in (\n" + "      for $x in $a//SCENE \n" + "      where $x/TITLE/text()=\"SCENE II.  A public place.\"  \n" + "      return $x\n" + "    )\n" + "    satisfies $s1 eq $s and $a/TITLE/text() = \"ACT I\"\n" + "    return <act>{\n" + "      $a/TITLE/text()\n" + "    }</act>\n" + "  }</scenes>\n" + "}</result>";
        String[] sampleQueries = {SAMPLE_QUERY_1, SAMPLE_QUERY_2, SAMPLE_QUERY_3, SAMPLE_QUERY_4, SAMPLE_QUERY_5};

        String queryFilePath = "input/m2-test.txt";
        ArrayList<String> queries = new ArrayList<>();
        try {
            queries = new ArrayList<>(Files.readAllLines(Paths.get(queryFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        XQueryEngine engine = new XQueryEngine("data/", "m2-output/");
        for (int i = 0; i < queries.size(); i++) {
            System.out.println("Testing query " + (i + 1));
            System.out.println("Processing query: \n" + sampleQueries[i]);
            try {
                engine.evaluate(queries.get(i), "result" + (i + 1) + ".xml");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------");
        }
    }

    /* Decorator function to print out the name of the node being processed */
    private Map<String, List<Object>> getChildren(ParseTree tree, String name) {
        // System.out.println("Processing " + name + ": " + tree.getText());
        Map<String, List<Object>> children = parser.getChildren(tree);
        // System.out.println("\tChildren key set: " + children.keySet());
        for (String key : children.keySet()) {
            if (Objects.equals(key, "otherChildren")) {
                // System.out.println("\t\t" + key + ": " + children.get(key));
            } else {
                for (Object child : children.get(key)) {
                    // System.out.println("\t\t" + key + ": " + ((ParseTree) child).getText());
                }
            }
        }

        return children;
    }

    public void evaluate(String query, String outputFileName) {
        Set<Node> result = process(query);
        if (result.size() != 1) {
            Element root = document.createElement("result");
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
        // System.out.println("Processing query: \n" + query);
        parser = new XQueryParser(query);
        ParseTree tree = parser.getTree();
        return processXQuery(tree, new HashMap<>());
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
                return;
            default:
                throw new IllegalArgumentException("processForClause: invalid child count");
        }
    }

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
                return createSet(document.createTextNode(tree.getText()));
            } else if (children.containsKey("absolutePath")) {
                // absolutePath
                return xpathEngine.processAbsolutePath(tree.getChild(0));
            } else {
                throw new IllegalArgumentException("processXQuery: invalid key: " + children.keySet());
            }

        } else if (children.containsKey("forClause")) {
            // forClause letClause? whereClause? returnClause
            List<HashMap<String, Node>> varHashMapList = new ArrayList<>();
            processForClause((ParseTree) children.get("forClause").get(0), varHashMapList);

            if (children.containsKey("letClause")) {
                processLetClause((ParseTree) children.get("letClause").get(0));
            }
            if (children.containsKey("whereClause")) {
                processWhereClause((ParseTree) children.get("whereClause").get(0), varHashMapList);
            }

            ParseTree returnClause = (ParseTree) children.get("returnClause").get(0);
            Set<Node> res = createSet();
            for (HashMap<String, Node> varHashMapItem : varHashMapList) {
                res.addAll(processReturnClause(returnClause, varHashMapItem));
            }
            return res;
        } else if (children.containsKey("letClause")) {
            // letClause xquery
            // TODO: call processLetClause and processXQuery
            throw new NotImplementedException("processXQuery: letClause xquery not implemented");
        } else if (children.containsKey("tagName")) {
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
            if ("(".equals(tree.getChild(0).getText())) {
                // '(' xquery ')'
                return processXQuery(tree.getChild(1), varHashMap);
            } else {
                if (children.containsKey("relativePath")) {
                    // xquery '/' relativePath
                    // xquery '//' relativePath
                    String xqueryOp = tree.getChild(1).getText();
                    ParseTree xquery = tree.getChild(0);
                    ParseTree relativePath = tree.getChild(2);
                    return xpathEngine.processRelativePath(processXQuery(xquery, varHashMap), relativePath, xqueryOp);

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
        // TODO: modify the return type and params of processLetClause
        Map<String, List<Object>> children = getChildren(tree, "letClause");
        int childCount = tree.getChildCount();
        switch (childCount) {
            case 4:
                // 'let' var ':=' xquery
                // TODO: implement 'let' var ':=' xquery, which assigns the result of xquery to var
                throw new NotImplementedException("processLetClause: 'let' var ':=' xquery not implemented");
            case 5:
                // letClause ',' var ':=' xquery
                // TODO: implement letClause ',' var ':=' xquery, similar to 'let' var ':=' xquery, but with multiple assignments
                throw new NotImplementedException("processLetClause: letClause ',' var ':=' xquery not implemented");
            default:
                throw new IllegalArgumentException("processLetClause: invalid child count");
        }
    }

    public void processWhereClause(ParseTree tree, List<HashMap<String, Node>> varHashMapList) {
        // 'where' cond
        Map<String, List<Object>> children = getChildren(tree, "whereClause");
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
        Map<String, List<Object>> children = getChildren(tree, "returnClause");
        ParseTree xquery = tree.getChild(1);
        return processXQuery(xquery, varHashMap);
    }

    public boolean processCond(ParseTree tree, HashMap<String, Node> varHashMap) {
        Map<String, List<Object>> children = getChildren(tree, "cond");
        int childCount = tree.getChildCount();
        switch (childCount) {
            case 1:
                // xquery
                return !processXQuery(tree.getChild(0), varHashMap).isEmpty();
            case 2:
                // 'not' cond
                return !processCond(tree.getChild(1), varHashMap);
            case 3:
                if ("(".equals(tree.getChild(0).getText())) {
                    // '(' cond ')'
                    processCond(tree.getChild(1), varHashMap);
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
                ParseTree var = tree.getChild(1);
                ParseTree xquery = tree.getChild(3);
                ParseTree subCond = tree.getChild(5);
                Set<Node> xqueryResult = processXQuery(xquery, varHashMap);
                // TODO: implement 'some' var 'in' xquery 'satisfies' cond, which checks if there exists a var in xquery such that cond is true
                throw new NotImplementedException("processCond: 'some' var 'in' xquery 'satisfies' cond not implemented");
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
                    if ("\"".equals(rightNodeStr.substring(0, 1))) {
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
                // TODO: implement comparison content of nodes, similar to XPathEngine
                throw new NotImplementedException("processCond: " + op + " not implemented");
            case "==":
            case "is":
                // xquery '==' xquery
                // xquery 'is' xquery
                // TODO: implement comparison reference of nodes, similar to XPathEngine
                throw new NotImplementedException("processCond: " + op + " not implemented");
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