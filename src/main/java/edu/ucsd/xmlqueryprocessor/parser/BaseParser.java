package edu.ucsd.xmlqueryprocessor.parser;

import edu.ucsd.xmlqueryprocessor.util.TreeUtil;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Arrays;

public abstract class BaseParser<T extends Parser> {

    private T parser;

    public BaseParser(String input) {
        parse(input);
    }

    protected abstract Lexer createLexer(CharStream charStream);

    protected abstract T createParser(CommonTokenStream tokens);

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

    public void printParseTree() {
        String[] ruleNames = getRuleNames();
        System.out.println(TreeUtil.toPrettyTree(getTree(), Arrays.asList(ruleNames)));
    }
}
