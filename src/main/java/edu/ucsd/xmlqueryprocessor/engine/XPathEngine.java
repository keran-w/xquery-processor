package edu.ucsd.xmlqueryprocessor.engine;

import edu.ucsd.xmlqueryprocessor.parser.XMLParser;
import edu.ucsd.xmlqueryprocessor.parser.XPathParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static edu.ucsd.xmlqueryprocessor.parser.XMLParser.dumpDocument;

public class XPathEngine {

    private final String fileDirectory;

    public XPathEngine(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public static void main(String[] args) {
        final String SAMPLE_QUERY_1 = "doc(\"j_caesar.xml\")//ACT/TITLE/text()";
        final String SAMPLE_QUERY_2 = "doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text() = \"CAESAR\"]";
        String sample = SAMPLE_QUERY_2;
        System.out.println("SAMPLE_QUERY: " + sample);
        XPathEngine engine = new XPathEngine("data/");
        Set<Node> results = engine.process(sample);
        try {
            Document document = XMLParser.convertResultsToDOM(results);
            dumpDocument(document, "m1-output.xml");
        } catch (Exception ignored) {
        }
    }

    static Set<Node> createSet(Node... nodes) {
        return new LinkedHashSet<>(Set.of(nodes));
    }

    public Set<Node> process(String query) {
        XPathParser parser = new XPathParser(query);
        ParseTree parseTree = parser.getTree();
        return processAbsolutePath(parseTree);
    }

    private void printChildren(ParseTree tree) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree child = tree.getChild(i);
            System.out.println("\tChild: " + child.getText());
        }
    }

    public Set<Node> processAbsolutePath(ParseTree tree) {
        String filename = tree.getChild(2).getText();
        String op = tree.getChild(4).getText();
        ParseTree relativePath = tree.getChild(5);
        switch (op) {
            case "/":
                // 'doc' '(' fileName ')' '/' relativePath
                return processAbsolutePath(filename, relativePath, "/");
            case "//":
                // 'doc' '(' fileName ')' '//' relativePath
                return processAbsolutePath(filename, relativePath, "//");
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    private Node processFileName(String fileName) {
        String filePath = fileDirectory + fileName.substring(1, fileName.length() - 1);
        Document document = XMLParser.parseXML(filePath);
        assert document != null;
        return document.getDocumentElement();
    }

    public Set<Node> processAbsolutePath(String filename, ParseTree relativePath, String op) {
        Node root = processFileName(filename);
        return processRelativePath(Set.of(root), relativePath, op);
    }

    public Set<Node> processRelativePath(Set<Node> nodes, ParseTree relativePath, String op) {
        int childCount = relativePath.getChildCount();
        switch (childCount) {
            case 1:
                // tagName | '*' | '.' | '..' | 'text()' | attName
                String leafSymbol = relativePath.getChild(0).getText();
                return processRPLeaf(nodes, leafSymbol, op);

            case 3:
                if ("(".equals(relativePath.getChild(0).getText())) {
                    // '(' relativePath ')'
                    return processRelativePath(nodes, relativePath.getChild(1), op);
                } else {
                    // relativePath ',' relativePath
                    // relativePath '/' relativePath
                    // relativePath '//' relativePath
                    String nxtOp = relativePath.getChild(1).getText();
                    ParseTree left = relativePath.getChild(0);
                    ParseTree right = relativePath.getChild(2);
                    return processRelativePath(processRelativePath(nodes, left, op), right, nxtOp);
                }

            case 4:
                // relativePath '[' pathFilter ']'
                ParseTree subRelativePath = relativePath.getChild(0);
                ParseTree pathFilter = relativePath.getChild(2);
                return processPathFilter(processRelativePath(nodes, subRelativePath, op), pathFilter, false);
            default:
                throw new IllegalArgumentException("Invalid relative path: " + relativePath.getText());
        }
    }

    public Set<Node> processRPLeaf(Set<Node> nodes, String leafSymbol, String op) {
        Set<Node> results = createSet();
        switch (leafSymbol) {
            case "*":
                // get all children for each node
                for (Node node : nodes) {
                    for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                        results.add(node.getChildNodes().item(i));
                    }
                }
                return results;
            case ".":
                // get self node for each node
                return nodes;
            case "..":
                // get parent node for each node
                for (Node node : nodes) {
                    results.add(node.getParentNode());
                }
                return results;
            case "text()":
                // get text node for each node
                for (Node node : nodes) {
                    System.out.println("Node: " + node.getNodeName() + ", " + node.getTextContent());
                    results.add(node.getFirstChild());
                }
                return results;
            default:
                if (leafSymbol.startsWith("@")) {
                    // attName
                    throw new UnsupportedOperationException("Attribute name not supported yet");
                } else {
                    // tagName
                    for (Node node : nodes) {
                        if ("/".equals(op)) {
                            results.addAll(XMLParser.getNodeByNameNextLevel(node, leafSymbol));
                        } else if ("//".equals(op)) {
                            results.addAll(XMLParser.getNodeByNameAllLevels(node, leafSymbol));
                        }

                    }
                    return results;
                }
        }
    }

    public Set<Node> processPathFilter(Set<Node> nodes, ParseTree pathFilter, boolean isNot) {
        int childCount = pathFilter.getChildCount();
        switch (childCount) {
            case 1:
                // relativePath
                return processRelativePath(nodes, pathFilter.getChild(0), null);

            case 2:
                // 'not' pathFilter
                return processPathFilter(nodes, pathFilter.getChild(1), !isNot);

            case 3:
                if ("(".equals(pathFilter.getChild(0).getText())) {
                    // '(' pathFilter ')'
                    return processPathFilter(nodes, pathFilter.getChild(1), isNot);
                } else {
                    // relativePath '=' relativePath
                    // relativePath 'eq' relativePath
                    // relativePath '==' relativePath
                    // relativePath 'is' relativePath
                    // relativePath '=' stringConstant
                    // pathFilter 'and' pathFilter
                    // pathFilter 'or' pathFilter
                    String op = pathFilter.getChild(1).getText();
                    ParseTree left = pathFilter.getChild(0);
                    ParseTree right = pathFilter.getChild(2);
                    return processPathFilter(nodes, left, right, op, isNot);
                }

            default:
                throw new IllegalArgumentException("Invalid path filter: " + pathFilter.getText());
        }
    }

    public Set<Node> processPathFilter(Set<Node> nodes, ParseTree left, ParseTree right, String op, boolean isNot) {
        String rightText = right.getText();
        if (Objects.equals(op, "=") && "\"".equals(rightText.substring(0, 1))) {
            // relativePath '=' stringConstant
            String target = right.getChild(1).getText().substring(1, rightText.length() - 1);
            return processPathFilterEquality(nodes, left.getText(), target, false);
        }

        Set<Node> leftResults = processRelativePath(nodes, left, null);
        Set<Node> rightResults = processRelativePath(nodes, right, null);
        switch (op) {
            case "=":
            case "eq":
                // relativePath '=' relativePath
                // relativePath 'eq' relativePath
                throw new UnsupportedOperationException("Equality =/eq comparison not supported yet");
            case "==":
            case "is":
                // relativePath '==' relativePath
                // relativePath 'is' relativePath
                throw new UnsupportedOperationException("Equality ==/is comparison not supported yet");
            case "and":
                // pathFilter 'and' pathFilter
                leftResults.retainAll(rightResults);
                return leftResults;
            case "or":
                // pathFilter 'or' pathFilter
                leftResults.addAll(rightResults);
                return leftResults;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    public Set<Node> processPathFilterEquality(Set<Node> nodes, String left, String target, boolean isNot) {
        throw new UnsupportedOperationException("Equality = comparison not supported yet");
    }
}
