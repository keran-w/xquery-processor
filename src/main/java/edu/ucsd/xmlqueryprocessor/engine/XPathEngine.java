package edu.ucsd.xmlqueryprocessor.engine;

import edu.ucsd.xmlqueryprocessor.parser.XMLParser;
import edu.ucsd.xmlqueryprocessor.parser.XPathParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.NotImplementedException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static edu.ucsd.xmlqueryprocessor.parser.XMLParser.dumpDocument;

public class XPathEngine {

    private final String fileDirectory;
    private final String outputDirectory;

    public XPathEngine(String fileDirectory) {
        this.fileDirectory = fileDirectory;
        this.outputDirectory = null;
    }

    public XPathEngine(String fileDirectory, String outputDirectory) {
        this.fileDirectory = fileDirectory;
        this.outputDirectory = outputDirectory;
    }

    static Set<Node> createSet(Node... nodes) {
        return new LinkedHashSet<>(Set.of(nodes));
    }

    public void evaluate(String query, String outputFileName) {
        Set<Node> results = process(query);
        try {
            Document document = XMLParser.convertResultsToDOM(results);
            String outputFilePath = outputDirectory + outputFileName;
            dumpDocument(document, outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<Node> process(String query) {
        System.out.println("Processing query: " + query);
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
        //        System.out.println("Processing relative path: " + relativePath.getText());
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
                    // TODO: Implement ',' operator
                    assert "/".equals(op) || "//".equals(op);
                    String nxtOp = relativePath.getChild(1).getText();
                    ParseTree left = relativePath.getChild(0);
                    ParseTree right = relativePath.getChild(2);
                    return processRelativePath(processRelativePath(nodes, left, op), right, nxtOp);
                }

            case 4:
                // relativePath '[' pathFilter ']'
                ParseTree subRelativePath = relativePath.getChild(0);
                ParseTree pathFilter = relativePath.getChild(2);
                return processPathFilter(processRelativePath(nodes, subRelativePath, op), pathFilter);

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
                    results.add(node.getFirstChild());
                }
                return results;
            default:
                if (leafSymbol.startsWith("@")) {
                    // attName
                    // TODO: Implement attribute name, @attrName == /attrValue/text()
                    throw new NotImplementedException("processRPLeaf: attribute not implemented");
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

    public boolean processPathFilter(Node node, ParseTree pathFilter) {
        int childCount = pathFilter.getChildCount();
        switch (childCount) {
            case 1:
                // relativePath
                return !processRelativePath(Set.of(node), pathFilter.getChild(0), "/").isEmpty();

            case 2:
                // 'not' pathFilter
                return !processPathFilter(node, pathFilter.getChild(1));

            case 3:
                if ("(".equals(pathFilter.getChild(0).getText())) {
                    // '(' pathFilter ')'
                    return processPathFilter(node, pathFilter.getChild(1));
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
                    return processPathFilter(node, left, right, op);
                }

            default:
                throw new IllegalArgumentException("Invalid path filter: " + pathFilter.getText());
        }
    }

    public Set<Node> processPathFilter(Set<Node> nodes, ParseTree pathFilter) {
        Set<Node> results = new LinkedHashSet<>();
        for (Node node : nodes) {
            if (processPathFilter(node, pathFilter)) {
                results.add(node);
            }
        }
        return results;
    }

    public boolean processPathFilter(Node node, ParseTree left, ParseTree right, String op) {
        op = op.trim();
        String rightText = right.getText();
        if (Objects.equals(op, "=") && "\"".equals(rightText.substring(0, 1))) {
            // relativePath '=' stringConstant
            String target = rightText.substring(1, rightText.length() - 1);
            return processPathFilterEquality(node, left, target);
        }

        switch (op) {
            case "=":
            case "eq":
                // relativePath '=' relativePath
                // relativePath 'eq' relativePath
                // Length of the left and right sets should be equal
                // After sorting the sets, the elements should be equal
                // Check node.isEqualNode() / node.isEqualNode() methods
                // TODO: Implement equality for checking if the content of the nodes are equal
                throw new NotImplementedException("processPathFilter: 'eq' not implemented");
            case "==":
            case "is":
                // relativePath '==' relativePath
                // relativePath 'is' relativePath
                Set<Node> leftIsResults = processRelativePath(Set.of(node), left, "/");
                Set<Node> rightIsResults = processRelativePath(Set.of(node), right, "/");
                return leftIsResults.equals(rightIsResults);
            case "and":
                // pathFilter 'and' pathFilter
                boolean andLeft = processPathFilter(node, left);
                boolean andRight = processPathFilter(node, right);
                return andLeft && andRight;
            case "or":
                // pathFilter 'or' pathFilter
                boolean orLeft = processPathFilter(node, left);
                boolean orRight = processPathFilter(node, right);
                return orLeft || orRight;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    public boolean processPathFilterEquality(Node node, ParseTree left, String target) {
        Set<Node> leftResults = processRelativePath(Set.of(node), left, "/");
        boolean foundFlag = false;

        for (Node leftNode : leftResults) {
            if (target.equals(leftNode.getTextContent())) {
                foundFlag = true;
                break;
            }
        }
        return foundFlag;
    }
}