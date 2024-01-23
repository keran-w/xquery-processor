package edu.ucsd.xmlqueryprocessor.parser;

import edu.ucsd.xmlqueryprocessor.antlr4.XPathGrammarLexer;
import edu.ucsd.xmlqueryprocessor.antlr4.XPathGrammarParser;
import edu.ucsd.xmlqueryprocessor.util.TreeUtil;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Arrays;

public class XPathParser {

    private XPathGrammarParser parser;

    public XPathParser() {

    }

    public XPathParser(String query) {
        parse(query);
    }

    public void parse(String query) {
        CharStream charStream = CharStreams.fromString(query);
        XPathGrammarLexer lexer = new XPathGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new XPathGrammarParser(tokens);
    }

    public ParseTree getParseTree() {
        return parser.absolutePath();
    }

    public String[] getRuleNames() {
        return parser.getRuleNames();
    }

    public void printParseTree() {
        String[] ruleNames = parser.getRuleNames();
        System.out.println(TreeUtil.toPrettyTree(parser.absolutePath(), Arrays.asList(ruleNames)));
    }
}
