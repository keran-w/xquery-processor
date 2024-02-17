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
        ParseTree parseTree = parser.getTree();
        ruleNames = parser.getRuleNames();
        processRoot(parseTree);
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


    public void processRoot(ParseTree tree) throws ParserConfigurationException {


        Map<String, Object> children = getChildren(tree);
        ParseTree fileName = (ParseTree) children.get("fileName");
        ParseTree relativePath = (ParseTree) children.get("relativePath");
        document = processFileName(fileName);
        assert Objects.equals(children.get("otherChildren"), "doc()//");
        Set<Node> results = processRelativePath(relativePath);
        if (results != null) {
            document = XMLParser.convertResultsToDOM(results);
        }
    }

    public Document processFileName(ParseTree tree) {
        String fileName = tree.getText();
        String filePath = fileDirectory + fileName.substring(1, fileName.length() - 1);
        return XMLParser.parseXML(filePath);
    }

    public Set<Node> processRelativePath(ParseTree tree) throws ParserConfigurationException {
        Map<String, Object> children = getChildren(tree);
        Set<Node> results = new LinkedHashSet<>();
        if (children.containsKey("relativePath") && children.containsKey("pathFilter")) {
            ParseTree relativePath = (ParseTree) children.get("relativePath");

            List<ParseTree> pathFilters = (List<ParseTree>) children.get("pathFilter");
            Set<Node> results_1 = processRelativePath(relativePath);
            Set<Node> results_2 = new LinkedHashSet<>();
            for (ParseTree pathFilter : pathFilters) {
                Set<Node> results_ = processPathFilter(pathFilter);
                if (results_ == null) {
                    return null;
                }
                results_2.addAll(results_);
            }
            if (results_1 != null) {
                results_1.retainAll(results_2);
                results.addAll(results_1);
            } else {
                results.addAll(results_2);
            }
        } else if (children.containsKey("relativePath") && children.containsKey("rpLeaf")) {
            ParseTree relativePath = (ParseTree) children.get("relativePath");
            ParseTree rpLeaf = (ParseTree) children.get("rpLeaf");
            if ("text()".equals(relativePath.getText())) {
                processRpLeaf(rpLeaf);
                return null;
            } else {
                Set<Node> results_ = processRelativePath(relativePath);
                if (results_ != null) {
                    results.addAll(results_);
                }
            }
        } else if (children.containsKey("relativePath")) {

        } else if (children.containsKey("rpLeaf")) {
            boolean tmp = processTagName;
            processRpLeaf((ParseTree) children.get("rpLeaf"));
            if (tmp != processTagName) {
                return null;
            }
            return null;
        } else {
            throw new NotImplementedException("processRelativePath has not implemented " + tree.getText());
        }
        return results;
    }


    public void processRpLeaf(ParseTree tree) {
        Map<String, Object> children = getChildren(tree);
        children.forEach((ruleName, child) -> {
            if ("tagName".equals(ruleName)) {
                processTagName((ParseTree) child);
            } else if (".".equals(ruleName) || "otherChildren".equals(ruleName)) {

            } else {
                throw new NotImplementedException("processRpLeaf has not implemented " + ruleName);
            }
        });
    }

    public void processTagName(ParseTree tree) {
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
        Set<Node> results = new LinkedHashSet<>();
        if ("*".equals(tree.getText())) {
            return null;
        }
        Map<String, Object> children = getChildren(tree);
        if (children.containsKey("otherChildren")) {
            String other = (String) children.get("otherChildren");
            if (Objects.equals(other, "=")) {
                results = processEquality(tree);
            } else if (Objects.equals(other, "or")) {
                List<ParseTree> pathFilters = (List<ParseTree>) children.get("pathFilter");
                for (ParseTree pathFilter : pathFilters) {
                    results.addAll(processPathFilter(pathFilter));
                }
            } else if (Objects.equals(other, "and")) {
                List<ParseTree> pathFilters = (List<ParseTree>) children.get("pathFilter");
                for (ParseTree pathFilter : pathFilters) {
                    if (results.isEmpty()) {
                        results.addAll(processPathFilter(pathFilter));
                    } else {
                        results.retainAll(processPathFilter(pathFilter));
                    }
                }
            } else if (Objects.equals(other, "not")) {
                if (pathFilterPrefix == null) {
                    pathFilterPrefix = "not";
                } else {
                    pathFilterPrefix = "not/" + pathFilterPrefix;
                }
                List<ParseTree> pathFilters = (List<ParseTree>) children.get("pathFilter");
                for (ParseTree pathFilter : pathFilters) {
                    results.addAll(processPathFilter(pathFilter));
                }
            } else {
                throw new NotImplementedException("processPathFilter has not implemented " + other);
            }

        } else if (children.containsKey("relativePath")) {
            results.addAll(processRelativePath((ParseTree) children.get("relativePath")));
        } else if (children.containsKey("stringConstant")) {
            processStringConstant((ParseTree) children.get("stringConstant"));
        } else {
            throw new NotImplementedException("processPathFilter has not implemented " + tree.getText());
        }

        return results;
    }

    public List<String> processRelativePathForEquality(ParseTree tree) {

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
        Map<String, Object> children = getChildren(tree);
        ParseTree relativePath = (ParseTree) children.get("relativePath");
        List<String> left = processRelativePathForEquality(relativePath);
        String target = ((ParseTree) children.get("stringConstant")).getText();
        target = target.substring(1, target.length() - 1);
        inequalityFlag = pathFilterPrefix != null && pathFilterPrefix.startsWith("not");
        if ("text()".equals(left.get(left.size() - 1))) {
            return XMLParser.processEquality(document, left.get(left.size() - 2), target, inequalityFlag);
        } else {
            assert left.get(left.size() - 1).startsWith("@");
            return XMLParser.processEquality(document, left.get(left.size() - 1).substring(1), target, inequalityFlag);
        }
    }

    public void processStringConstant(ParseTree tree) {
        String stringConstant = tree.getText();
        document = XMLParser.getByNodeName(document, stringConstant);
    }
}