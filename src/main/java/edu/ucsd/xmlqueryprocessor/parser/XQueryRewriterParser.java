package edu.ucsd.xmlqueryprocessor.parser;

import edu.ucsd.xmlqueryprocessor.antlr4.xqueryRewrite.XQueryRewriteGrammarLexer;
import edu.ucsd.xmlqueryprocessor.antlr4.xqueryRewrite.XQueryRewriteGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

public class XQueryRewriterParser extends BaseParser<XQueryRewriteGrammarParser> {

    public XQueryRewriterParser(String input) {
        super(input);
    }

    @Override
    protected Lexer createLexer(CharStream charStream) {
        return new XQueryRewriteGrammarLexer(charStream);
    }

    @Override
    protected XQueryRewriteGrammarParser createParser(CommonTokenStream tokens) {
        return new XQueryRewriteGrammarParser(tokens);
    }

    @Override
    protected ParseTree getParseTree(XQueryRewriteGrammarParser parser) {
        return parser.xquery();
    }

}
