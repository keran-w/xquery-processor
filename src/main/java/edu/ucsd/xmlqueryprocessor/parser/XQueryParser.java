package edu.ucsd.xmlqueryprocessor.parser;

import edu.ucsd.xmlqueryprocessor.antlr4.xquery.XQueryGrammarLexer;
import edu.ucsd.xmlqueryprocessor.antlr4.xquery.XQueryGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

public class XQueryParser extends BaseParser<XQueryGrammarParser> {

    public XQueryParser(String input) {
        super(input);
    }

    @Override
    protected Lexer createLexer(CharStream charStream) {
        return new XQueryGrammarLexer(charStream);
    }

    @Override
    protected XQueryGrammarParser createParser(CommonTokenStream tokens) {
        return new XQueryGrammarParser(tokens);
    }

    @Override
    protected ParseTree getParseTree(XQueryGrammarParser parser) {
        return parser.xquery();
    }
}