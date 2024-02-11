package edu.ucsd.xmlqueryprocessor.engine;

import edu.ucsd.xmlqueryprocessor.parser.XMLParser;
import edu.ucsd.xmlqueryprocessor.parser.XPathParser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.NotImplementedException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.ParserConfigurationException;
import java.util.*;

public class Engine {

    private final String fileDirectory;
    private final String outputFileDirectory;
    private Document document;
    private String[] ruleNames;
    private boolean processTagName = false;
    private String pathFilterPrefix = null;

    private boolean inequalityFlag = false;

    public Engine(String fileDirectory, String outputFileDirectory) {
        reset();
        this.fileDirectory = fileDirectory;
        this.outputFileDirectory = outputFileDirectory;
    }

    public void reset() {
        inequalityFlag = false;
        document = null;
        ruleNames = null;
        processTagName = false;
        pathFilterPrefix = null;
    }

    public void process(String query, String fileName) throws ParserConfigurationException {
        reset();
        XPathParser parser = new XPathParser(query);
        ParseTree parseTree = parser.getParseTree();
        ruleNames = parser.getRuleNames();
        processRoot(parseTree);
        System.out.println("dumpDocument EOF");
        String filePath = outputFileDirectory + fileName + ".xml";
        XMLParser.dumpDocument(document, filePath);
    }

    public String getRuleName(ParseTree tree) {
        if (tree instanceof RuleContext) {
            return ruleNames[((RuleContext) tree).getRuleContext().getRuleIndex()];
        } else {
            return null;
        }
    }

    public Map<String, Object> getChildren(ParseTree tree) {
        Map<String, Object> childrenKeyMap = new HashMap<>();
        List<String> otherChildren = new ArrayList<>();
        List<ParseTree> pathFilters = new ArrayList<>();

        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree child = tree.getChild(i);
            String ruleName = getRuleName(child);

            System.out.println("\tChild: " + child.getText() + ", " + ruleName);
            if (ruleName == null) {
                otherChildren.add(child.getText().trim());
                continue;
            }
            if ("pathFilter".equals(ruleName)) {
                pathFilters.add(child);
            } else {
                childrenKeyMap.put(ruleName, child);
            }
        }
        if (!otherChildren.isEmpty()) {
            childrenKeyMap.put("otherChildren", String.join("", otherChildren));
        }
        if (!pathFilters.isEmpty()) {
            childrenKeyMap.put("pathFilter", pathFilters);
        }
        return childrenKeyMap;
    }

    /**
     * Function [[ap]]A: process the root node of the tree
     *
     * @param tree, the root node of the tree
     */

    public void processRoot(ParseTree tree) throws ParserConfigurationException {

        System.out.println("processRoot: " + tree.getText());

        Map<String, Object> children = getChildren(tree);
        ParseTree fileName = (ParseTree) children.get("fileName");
        ParseTree relativePath = (ParseTree) children.get("relativePath");
        document = processFileName(fileName);
        assert Objects.equals(children.get("otherChildren"), "doc()//");
        processRelativePath(relativePath);

    }

    public Document processFileName(ParseTree tree) {
        System.out.println("processFileName: " + tree.getText());
        String fileName = tree.getText();
        String filePath = fileDirectory + fileName.substring(1, fileName.length() - 1);
        return XMLParser.parseXML(filePath);
    }

    public void processRelativePath(ParseTree tree) throws ParserConfigurationException {
        System.out.println("processRelativePath: " + tree.getText());
        Map<String, Object> children = getChildren(tree);
        Set<Node> results = new LinkedHashSet<>();
        // System.out.println("\tChildren: " + children.keySet());
        if (children.containsKey("relativePath") && children.containsKey("pathFilter")) {
            ParseTree relativePath = (ParseTree) children.get("relativePath");
            List<ParseTree> pathFilters = (List<ParseTree>) children.get("pathFilter");
            processRelativePath(relativePath);
            for (ParseTree pathFilter : pathFilters) {
                results = processPathFilter(pathFilter);
                if (results == null) {
                    // do nothing
                    continue;
                }
                if (!results.isEmpty()) {
                    document = XMLParser.convertResultsToDOM(results);
                }
//                else {
//                    throw new NotImplementedException("There are no results in processRelativePath!");
//                }
            }
        } else if (children.containsKey("relativePath") && children.containsKey("rpLeaf")) {
            ParseTree relativePath = (ParseTree) children.get("relativePath");
            ParseTree rpLeaf = (ParseTree) children.get("rpLeaf");
            if ("text()".equals(relativePath.getText())) {
                processRpLeaf(rpLeaf);
            } else {
                processRelativePath(relativePath);
            }
        } else if (children.containsKey("relativePath")) {
            ParseTree relativePath = (ParseTree) children.get("relativePath");
            // processSingleRelativePath(relativePath);
        } else if (children.containsKey("rpLeaf")) {
            processRpLeaf((ParseTree) children.get("rpLeaf"));
        } else {
            throw new NotImplementedException("processRelativePath has not implemented " + tree.getText());
        }
    }

    public void processSingleRelativePath(ParseTree tree) {
        System.out.println("processSingleRelativePath: " + tree.getText());
        document = XMLParser.checkIfChildNodeExists(document, tree.getText());
    }

    public void processRpLeaf(ParseTree tree) {
        System.out.println("processRpLeaf: " + tree.getText());
        Map<String, Object> children = getChildren(tree);
        children.forEach((ruleName, child) -> {
            if ("tagName".equals(ruleName)) {
                processTagName((ParseTree) child);
            } else if (".".equals(ruleName) || "otherChildren".equals(ruleName)) {
                // do nothing
            } else {
                throw new NotImplementedException("processRpLeaf has not implemented " + ruleName);
            }
        });
    }

    public void processTagName(ParseTree tree) {
        System.out.println("processTagName: " + tree.getText());
        if (processTagName) {
            if (pathFilterPrefix == null) {
                pathFilterPrefix = tree.getText();
            } else {
                pathFilterPrefix += "/" + tree.getText();
            }
        } else {
            processTagName = true;
            String tagName = tree.getText();
            document = XMLParser.getByNodeName(document, tagName);
        }
    }

    public Set<Node> processPathFilter(ParseTree tree) throws ParserConfigurationException {
        System.out.println("processPathFilter: " + tree.getText());
        Set<Node> results = new LinkedHashSet<>();
        if ("*".equals(tree.getText())) {
            return null;
        }
        Map<String, Object> children = getChildren(tree);
        if (children.containsKey("otherChildren")) {
            String other = (String) children.get("otherChildren");
            // priority: or > and > not
            if (Objects.equals(other, "=")) {
                results = processEquality(tree);
                System.out.println("Equaltiy results: -----");
                System.out.println(results);
            } else if (Objects.equals(other, "or")) {
                List<ParseTree> pathFilters = (List<ParseTree>) children.get("pathFilter");
                for (ParseTree pathFilter : pathFilters) {
                    // add to the results
                    results.addAll(processPathFilter(pathFilter));
                }
                System.out.println("Or results: -----");
                System.out.println(results);
            } else if (Objects.equals(other, "and")) {
                List<ParseTree> pathFilters = (List<ParseTree>) children.get("pathFilter");
                for (ParseTree pathFilter : pathFilters) {
                    if (results.isEmpty()) {
                        // results empty, just add into the results
                        results.addAll(processPathFilter(pathFilter));
                    } else {
                        // find the intersection part
                        results.retainAll(processPathFilter(pathFilter));
                    }
                }
                System.out.println("And results: -----");
                System.out.println(results);
            } else if (Objects.equals(other, "not")) {
                if (pathFilterPrefix == null) {
                    pathFilterPrefix = "not";
                } else {
                    pathFilterPrefix = "not/" + pathFilterPrefix;
                }
                List<ParseTree> pathFilters = (List<ParseTree>) children.get("pathFilter");
                for (ParseTree pathFilter : pathFilters) {
                    // add to the results
                    results.addAll(processPathFilter(pathFilter));
                }
                System.out.println("Not results: -----");
                System.out.println(results);
            } else {
                throw new NotImplementedException("processPathFilter has not implemented " + other);
            }

        } else if (children.containsKey("relativePath")) {
            processRelativePath((ParseTree) children.get("relativePath"));
        } else if (children.containsKey("stringConstant")) {
            processStringConstant((ParseTree) children.get("stringConstant"));
        } else {
            throw new NotImplementedException("processPathFilter has not implemented " + tree.getText());
        }

        return results;
    }

    public List<String> processRelativePathForEquality(ParseTree tree) {
        System.out.println("processRelativePathForEquality: " + tree.getText());

        ParseTree curr = tree;
        List<String> results = new ArrayList<>();
        Map<String, Object> children = getChildren(curr);
        while (children.containsKey("relativePath")) {
            ParseTree relativePath = (ParseTree) children.get("relativePath");
            results.add(((ParseTree) children.get("rpLeaf")).getText());
            curr = relativePath;
            children = getChildren(curr);
        }
        results.add(((ParseTree) children.get("rpLeaf")).getText());
        return results;
    }


    public Set<Node> processEquality(ParseTree tree) {
        System.out.println("processEquality: " + tree.getText() + " with prefix " + pathFilterPrefix);
        Map<String, Object> children = getChildren(tree);
        System.out.println("\tChildren: " + children.keySet());
        ParseTree relativePath = (ParseTree) children.get("relativePath");
        List<String> left = processRelativePathForEquality(relativePath);
        System.out.println("\tLeft: " + left);
        String target = ((ParseTree) children.get("stringConstant")).getText();
        target = target.substring(1, target.length() - 1);
        System.out.println("\tTarget: " + target);
        inequalityFlag = pathFilterPrefix != null && pathFilterPrefix.startsWith("not");
        System.out.println("\tInequalityFlag: " + inequalityFlag);
        // document = XMLParser.processEquality(document, left.get(left.size() - 2), target, inequalityFlag);
        if ("text()".equals(left.get(left.size() - 1))) {
            return XMLParser.processEquality(document, left.get(left.size() - 2), target, inequalityFlag);
        } else {
            assert left.get(left.size() - 1).startsWith("@");
            return XMLParser.processEquality(document, left.get(left.size() - 1).substring(1), target, inequalityFlag);
        }
    }

    public void processStringConstant(ParseTree tree) {
        System.out.println("processStringConstant: " + tree.getText());
        String stringConstant = tree.getText();
        document = XMLParser.getByNodeName(document, stringConstant);
    }
}