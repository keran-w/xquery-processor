package edu.ucsd.xmlqueryprocessor.engine;

import edu.ucsd.xmlqueryprocessor.antlr4.xquery.XQueryGrammarBaseVisitor;
import edu.ucsd.xmlqueryprocessor.parser.XQueryParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.lang3.NotImplementedException;
import org.w3c.dom.Node;

import java.util.*;

public class XQueryEngine extends XQueryGrammarBaseVisitor<Set<Node>> {
    XQueryParser parser;

    String FILE_DIRECTORY = "data/";

    XPathEngine xpathEngine = new XPathEngine(FILE_DIRECTORY);

    private HashMap<String, Set<Node>> varHashMap = new HashMap<>();

    public XQueryEngine() {

    }

    public static void main(String[] args) {
        final String SAMPLE_QUERY_1 = "<result>\n" + "  {\n" + "    for $a in doc(\"j_caesar.xml\")//ACT, $sc in $a//SCENE, $sp in $sc/SPEECH\n" + "    where $sp/LINE/text() = \"Et tu, Brute! Then fall, Caesar.\"\n" + "    return \n" + "    <who>{$sp/SPEAKER/text()}</who>,\n" + "    <when>{\n" + "      <act>{$a/TITLE/text()}</act>,\n" + "      <scene>{$sc/TITLE/text()}</scene>}\n" + "    </when>\n" + "  }\n" + "</result> ";
        System.out.println("SAMPLE_QUERY: " + SAMPLE_QUERY_1);
        XQueryEngine engine = new XQueryEngine();
        engine.process(SAMPLE_QUERY_1);
    }

    /*
     * Decorator function to print out the name of the node being processed
     */
    private Map<String, List<Object>> getChildren(ParseTree tree, String name) {
        System.out.println("Processing " + name + ": " + tree.getText());
        Map<String, List<Object>> children = parser.getChildren(tree);
        System.out.println("\tChildren key set" + children.keySet());
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
        ParseTree root = parser.getTree();
        // Map<String, List<Object>> children = getChildren(root, "root");
        Set<Node> result = processXQuery(root);
    }

    public Set<Node> processXQuery(ParseTree root) {
        Map<String, List<Object>> children = getChildren(root, "xquery");
        int childCount = root.getChildCount();
        if (childCount == 1) {
            // var
            // stringConstant
            // absolutePath
            throw new NotImplementedException("processXQuery: var, stringConstant, absolutePath not implemented");
        } else if (children.containsKey("forClause")) {
            // forClause letClause? whereClause? returnClause
            throw new NotImplementedException("processXQuery: forClause not implemented");
        } else if (children.containsKey("letClause")) {
            // letClause xquery
            throw new NotImplementedException("processXQuery: letClause not implemented");
        } else if (children.containsKey("tagName")) {
            // '<' tagName '>' '{' xquery '}' '</' tagName '>'
            throw new NotImplementedException("processXQuery: tagName not implemented");
        } else {
            assert childCount == 3;
            if ("(".equals(root.getChild(0).getText())) {
                // '(' xquery ')'
                throw new NotImplementedException("processXQuery: '(' xquery ')' not implemented");
            } else {
                if (children.containsKey("relativePath")) {
                    // xquery '/' relativePath
                    // xquery '//' relativePath
                    throw new NotImplementedException("processXQuery: xquery '/' relativePath, xquery '//' relativePath not implemented");
                } else {
                    // xquery ',' xquery
                    throw new NotImplementedException("processXQuery: xquery ',' xquery not implemented");
                }
            }
        }
    }

    public Set<Node> processForClause(ParseTree root) {
        Map<String, List<Object>> children = getChildren(root, "forClause");
        int childCount = root.getChildCount();
        switch (childCount) {
            case 4:
                // 'for' var 'in' xquery
                throw new NotImplementedException("processForClause: 'for' var 'in' xquery not implemented");
            case 5:
                // forClause ',' var 'in' xquery
                throw new NotImplementedException("processForClause: forClause ',' var 'in' xquery not implemented");
            default:
                throw new NotImplementedException("processForClause: invalid child count");
        }
    }

    public Set<Node> processLetClause(ParseTree root) {
        Map<String, List<Object>> children = getChildren(root, "letClause");
        int childCount = root.getChildCount();
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

    public Set<Node> processWhereClause(ParseTree root) {
        // 'where' cond
        Map<String, List<Object>> children = getChildren(root, "whereClause");
        ParseTree cond = (ParseTree) children.get("cond").get(1);
        throw new NotImplementedException("processWhereClause: cond not implemented");
    }

    public Set<Node> processReturnClause(ParseTree root) {
        // 'return' xquery
        Map<String, List<Object>> children = getChildren(root, "returnClause");
        ParseTree xquery = (ParseTree) children.get("xquery").get(1);
        throw new NotImplementedException("processReturnClause: xquery not implemented");
    }

    public Set<Node> processCond(ParseTree root) {
        Map<String, List<Object>> children = getChildren(root, "cond");
        int childCount = root.getChildCount();
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
                ParseTree var = root.getChild(1);
                ParseTree xquery = root.getChild(3);
                ParseTree subCond = root.getChild(5);
                throw new NotImplementedException("processCond: 'some' var 'in' xquery 'satisfies' cond not implemented");
            default:
                throw new NotImplementedException("processCond: invalid child count");
        }
    }


}
