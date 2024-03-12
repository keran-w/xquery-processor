package edu.ucsd.xmlqueryprocessor.parser;

import edu.ucsd.xmlqueryprocessor.util.TreeUtil;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public abstract class BaseParser<T extends Parser> {

    private T parser;

    public BaseParser(String input) {
        parse(input);
    }

    /**
     * Create a lexer for the given charStream
     *
     * @param charStream
     * @return
     */
    protected abstract Lexer createLexer(CharStream charStream);

    /**
     * Create a parser for the given tokens
     *
     * @param tokens
     * @return
     */
    protected abstract T createParser(CommonTokenStream tokens);

    /**
     * Get the parse tree from the parser
     *
     * @param parser
     * @return
     */
    protected abstract ParseTree getParseTree(T parser);

    private void parse(String input) {
        CharStream charStream = CharStreams.fromString(input);
        Lexer lexer = createLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = createParser(tokens);
    }

    public ParseTree getTree() {
        return getParseTree(parser);
    }

    public String[] getRuleNames() {
        return parser.getRuleNames();
    }

    public String getRuleName(ParseTree tree) {
        if (tree instanceof RuleContext) {
            return getRuleNames()[((RuleContext) tree).getRuleContext().getRuleIndex()];
        } else {
            return null;
        }
    }

    /**
     * Decorator function to print out the name of the node being processed
     */
    public Map<String, List<Object>> getAndPrintChildren(ParseTree tree) {
        System.out.println("Processing " + tree.getText());
        Map<String, List<Object>> children = getChildren(tree);
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

    public Map<String, List<Object>> getChildren(ParseTree tree) {
        Map<String, List<Object>> childrenKeyMap = new HashMap<>(5);
        List<Object> otherChildren = new ArrayList<>();

        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree child = tree.getChild(i);
            String ruleName = getRuleName(child);

            if (ruleName == null) {
                otherChildren.add(child.getText().trim());
            } else {
                childrenKeyMap.computeIfAbsent(ruleName, k -> new ArrayList<>()).add(child);
            }
        }
        if (!otherChildren.isEmpty()) {
            childrenKeyMap.put("otherChildren", otherChildren);
        }
        return childrenKeyMap;
    }

    public void printParseTree() {
        String[] ruleNames = getRuleNames();
        System.out.println(TreeUtil.toPrettyTree(getTree(), Arrays.asList(ruleNames)));
    }
}