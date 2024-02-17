package edu.ucsd.xmlqueryprocessor.parser;

import edu.ucsd.xmlqueryprocessor.antlr4.xpath.XPathGrammarLexer;
import edu.ucsd.xmlqueryprocessor.antlr4.xpath.XPathGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;

public class XPathParser extends BaseParser<XPathGrammarParser> {

    public XPathParser(String input) {
        super(input);
    }

    @Override
    protected Lexer createLexer(CharStream charStream) {
        return new XPathGrammarLexer(charStream);
    }

    @Override
    protected XPathGrammarParser createParser(CommonTokenStream tokens) {
        return new XPathGrammarParser(tokens);
    }

    @Override
    protected ParseTree getParseTree(XPathGrammarParser parser) {
        return parser.absolutePath();
    }
}