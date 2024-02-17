package edu.ucsd.xmlqueryprocessor.engine;

import edu.ucsd.xmlqueryprocessor.antlr4.xquery.XQueryGrammarBaseVisitor;
import edu.ucsd.xmlqueryprocessor.parser.XQueryParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Node;

import java.util.*;
import java.util.function.Function;

public class XQueryEngine extends XQueryGrammarBaseVisitor<Set<Node>> {
    XQueryParser parser;


    public XQueryEngine() {

    }

    public static void main(String[] args) {
        final String SAMPLE_QUERY_1 = "<result>\n" + "  {\n" + "    for $a in doc(\"j_caesar.xml\")//ACT, $sc in $a//SCENE, $sp in $sc/SPEECH\n" + "    where $sp/LINE/text() = \"Et tu, Brute! Then fall, Caesar.\"\n" + "    return \n" + "    <who>{$sp/SPEAKER/text()}</who>,\n" + "    <when>{\n" + "      <act>{$a/TITLE/text()}</act>,\n" + "      <scene>{$sc/TITLE/text()}</scene>}\n" + "    </when>\n" + "  }\n" + "</result> " ;
        System.out.println("SAMPLE_QUERY: " + SAMPLE_QUERY_1);
        XQueryEngine engine = new XQueryEngine();
        engine.process(SAMPLE_QUERY_1);

    }

    private int getDepth(ParseTree node) {
        int depth = 0;
        ParseTree current = node;
        while (current.getParent() != null) {
            depth++;
            current = current.getParent();
        }
        return depth;
    }

    public Set<Node> processByKey(String key, Function<ParseTree, Set<Node>> processor, Map<String, List<Object>> children) {
        List<Object> items = children.getOrDefault(key, Collections.emptyList());
        Set<Node> result = new LinkedHashSet<>();
        for (Object item : items) {
            Set<Node> nodes = processor.apply((ParseTree) item);
            result.addAll(nodes);
        }
        return result;
    }

    public void process(String query) {
        System.out.println("Start processing");
        parser = new XQueryParser(query);
        ParseTree root = parser.getTree();
        Map<String, List<Object>> children = parser.getChildren(root);
        System.out.println(children.keySet());
        Set<Node> result = processByKey("xquery", this::processXQuery, children);
    }

    private Map<String, List<Object>> getChildrenWithLogging(ParseTree tree, String name) {
        System.out.println("Processing " + name + ": " + tree.getText());
        Map<String, List<Object>> children = parser.getChildren(tree);
        System.out.println(children.keySet());
        return children;
    }

    public Set<Node> processXQuery(ParseTree root) {
        Map<String, List<Object>> children = getChildrenWithLogging(root, "xquery");
        Set<Node> result = new LinkedHashSet<>();
        processByKey("xquery", this::processXQuery, children);
        processByKey("forClause", this::processForClause, children);
        processByKey("whereClause", this::processWhereClause, children);
        processByKey("returnClause", this::processReturnClause, children);
        processByKey("letClause", this::processLetClause, children);
        processByKey("relativePath", this::processRelativePath, children);
        processByKey("var", this::processVar, children);
        return result;
    }

    public Set<Node> processWhereClause(ParseTree root) {
        Map<String, List<Object>> children = getChildrenWithLogging(root, "whereClause");
        Set<Node> result = new LinkedHashSet<>();
        processByKey("cond", this::processCond, children);
        return result;
    }

    public Set<Node> processForClause(ParseTree root) {
        Map<String, List<Object>> children = getChildrenWithLogging(root, "forClause");
        Set<Node> result = new LinkedHashSet<>();
        processByKey("forClause", this::processForClause, children);
        processByKey("xquery", this::processXQuery, children);
        processByKey("var", this::processVar, children);
        return result;
    }

    public Set<Node> processReturnClause(ParseTree root) {
        Map<String, List<Object>> children = getChildrenWithLogging(root, "returnClause");
        Set<Node> result = new LinkedHashSet<>();
        processByKey("xquery", this::processXQuery, children);
        return result;
    }

    public Set<Node> processLetClause(ParseTree root) {
        Map<String, List<Object>> children = getChildrenWithLogging(root, "letClause");
        Set<Node> result = new LinkedHashSet<>();
        return result;
    }

    public Set<Node> processCond(ParseTree root) {
        Map<String, List<Object>> children = getChildrenWithLogging(root, "cond");
        Set<Node> result = new LinkedHashSet<>();
        return result;
    }

    public Set<Node> processRelativePath(ParseTree root) {
        Map<String, List<Object>> children = getChildrenWithLogging(root, "relativePath");
        Set<Node> result = new LinkedHashSet<>();
        processByKey("tagName", this::processTagName, children);
        processByKey("rpLeaf", this::processRpLeaf, children);
        return result;
    }

    public Set<Node> processVar(ParseTree root) {
        Map<String, List<Object>> children = getChildrenWithLogging(root, "var");
        Set<Node> result = new LinkedHashSet<>();
        return result;
    }

    public Set<Node> processTagName(ParseTree root) {
        Map<String, List<Object>> children = getChildrenWithLogging(root, "tagName");
        Set<Node> result = new LinkedHashSet<>();
        return result;
    }

    public Set<Node> processRpLeaf(ParseTree root) {
        Map<String, List<Object>> children = getChildrenWithLogging(root, "rpLeaf");
        Set<Node> result = new LinkedHashSet<>();
        return result;
    }

}
