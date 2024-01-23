package edu.ucsd.xmlqueryprocessor.engine;

import edu.ucsd.xmlqueryprocessor.parser.XMLParser;
import edu.ucsd.xmlqueryprocessor.parser.XPathParser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.NotImplementedException;
import org.w3c.dom.Document;

import java.util.*;


public class Engine {

    private final String fileDirectory;
    private final String outputFileDirectory;
    private Document document;
    private String[] ruleNames;
    private boolean processTagName = false;
    private String pathFilterPrefix = null;

    public Engine(String fileDirectory, String outputFileDirectory) {
        reset();
        this.fileDirectory = fileDirectory;
        this.outputFileDirectory = outputFileDirectory;
    }


    public void reset() {
        document = null;
        ruleNames = null;
        processTagName = false;
        pathFilterPrefix = null;
    }

    public void process(String query, String fileName) {
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

    /*public TreeMap<String, Object> createSortedMap(String[] order) {
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            indexMap.put(order[i], i);
        }
        Comparator<String> customComparator = (key1, key2) -> {
            int index1 = indexMap.getOrDefault(key1, -1);
            int index2 = indexMap.getOrDefault(key2, -1);
            if (index1 == -1 && index2 == -1) {
                return key1.compareTo(key2);
            } else if (index1 == -1) {
                return 1;
            } else if (index2 == -1) {
                return -1;
            } else {
                return index1 - index2;
            }
        };
        return new TreeMap<>(customComparator);
    }*/

    public Map<String, Object> getChildren(ParseTree tree) {
//        String[] order = {"fileName", "relativePath", "rpLeaf", "tagName", "pathFilter", "stringConstant"};
//        Map<String, Object> childrenKeyMap = createSortedMap(order);
        Map<String, Object> childrenKeyMap = new HashMap<>();
        List<String> otherChildren = new ArrayList<>();

        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree child = tree.getChild(i);
            String ruleName = getRuleName(child);
            if (ruleName == null) {
                otherChildren.add(child.getText().trim());
                continue;
            }
//            System.out.println("\t" + ruleName + ": " + child.getText());
            childrenKeyMap.put(ruleName, child);
        }
        if (!otherChildren.isEmpty()) {
//            System.out.println("\totherChildren: " + String.join("", otherChildren));
            childrenKeyMap.put("otherChildren", String.join("", otherChildren));
        }
        return childrenKeyMap;
    }


    /**
     * Function [[ap]]A: process the root node of the tree
     *
     * @param tree, the root node of the tree
     */

    public void processRoot(ParseTree tree) {

        System.out.println("processRoot: " + tree.getText());

        Map<String, Object> children = getChildren(tree);
        ParseTree fileName = (ParseTree) children.get("fileName");
        ParseTree relativePath = (ParseTree) children.get("relativePath");
        document = processFileName(fileName);
        assert Objects.equals(children.get("otherChildren"), "doc()//");
        processRelativePath(relativePath);

//        Map<String, Object> rpChildren = getChildren(relativePath);
//        if (rpChildren.containsKey("rpLeaf")) {
//            processRpLeaf((ParseTree) rpChildren.get("rpLeaf"));
//        } else if (rpChildren.containsKey("otherChildren")) {
//            if ("[]".equals(rpChildren.get("otherChildren"))) {
//                ParseTree subRelativePath = (ParseTree) rpChildren.get("relativePath");
//                ParseTree pathFilter = (ParseTree) rpChildren.get("pathFilter");
//                processRpLeaf(subRelativePath);
//            } else {
//                throw new NotImplementedException("processRoot has not implemented " + rpChildren.get("otherChildren"));
//            }
//        } else {
//            throw new NotImplementedException("processRoot has not implemented " + relativePath.getText());
//        }
    }

    public Document processFileName(ParseTree tree) {
        System.out.println("processFileName: " + tree.getText());
        String fileName = tree.getText();
        String filePath = fileDirectory + fileName.substring(1, fileName.length() - 1);
        return XMLParser.parseXML(filePath);
    }


    public void processRelativePath(ParseTree tree) {
        System.out.println("processRelativePath: " + tree.getText());
        Map<String, Object> children = getChildren(tree);
        if (children.containsKey("rpLeaf")) {
            processRpLeaf((ParseTree) children.get("rpLeaf"));
        } else if (children.containsKey("relativePath")) {
            ParseTree relativePath = (ParseTree) children.get("relativePath");
            ParseTree pathFilter = (ParseTree) children.get("pathFilter");
            processRelativePath(relativePath);
            processPathFilter(pathFilter);
        } else {
            throw new NotImplementedException("processRelativePath has not implemented " + tree.getText());
        }
//        getChildren(tree).forEach((ruleName, child) -> {
//            if ("relativePath".equals(ruleName)) {
//                processRelativePath((ParseTree) child);
//            } else if ("rpLeaf".equals(ruleName)) {
//                processRpLeaf((ParseTree) child);
//            } else if ("pathFilter".equals(ruleName)) {
//                processPathFilter((ParseTree) child);
//            }
//        });
    }

    public void processRpLeaf(ParseTree tree) {
        System.out.println("processRpLeaf: " + tree.getText());
        Map<String, Object> children = getChildren(tree);
//        if (children.containsKey("rpLeaf")) {
//            processRpLeaf((ParseTree) children.get("rpLeaf"));
//        } else {
        children.forEach((ruleName, child) -> {
            if ("tagName".equals(ruleName)) {
                processTagName((ParseTree) child);
            } else {
                throw new NotImplementedException("This method has not been implemented yet.");
            }
        });
//        }
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

    public void processPathFilter(ParseTree tree) {
        System.out.println("processPathFilter: " + tree.getText());
        Map<String, Object> children = getChildren(tree);
        if (children.containsKey("otherChildren")) {
            String other = (String) children.get("otherChildren");
            if (Objects.equals(other, "=")) {
                processEquality(tree);
            } else if (Objects.equals(other, "not")) {
                if (pathFilterPrefix == null) {
                    pathFilterPrefix = "not";
                } else {
                    pathFilterPrefix = "not/" + pathFilterPrefix;
                }
                processPathFilter((ParseTree) children.get("pathFilter"));
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

    public void processEquality(ParseTree tree) {
        System.out.println("processEquality: " + tree.getText() + " with prefix " + pathFilterPrefix);
        Map<String, Object> children = getChildren(tree);
        System.out.println("\tChildren: " + children.keySet());
        ParseTree relativePath = (ParseTree) children.get("relativePath");
        List<String> left = processRelativePathForEquality(relativePath);
        System.out.println("\tLeft: " + left);
        String target = ((ParseTree) children.get("stringConstant")).getText();
        target = target.substring(1, target.length() - 1);
        System.out.println("\tTarget: " + target);
        boolean inequalityFlag = pathFilterPrefix != null && pathFilterPrefix.startsWith("not");
        System.out.println("\tInequalityFlag: " + inequalityFlag);
        document = XMLParser.processEquality(document, left.get(left.size() - 2), target, inequalityFlag);
    }

    public void processStringConstant(ParseTree tree) {
        System.out.println("processStringConstant: " + tree.getText());
        String stringConstant = tree.getText();
        document = XMLParser.getByNodeName(document, stringConstant);
    }
}
