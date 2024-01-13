package edu.ucsd.xmlqueryprocessor.parser;

import edu.ucsd.xmlqueryprocessor.antlr4.XPathGrammarLexer;
import edu.ucsd.xmlqueryprocessor.antlr4.XPathGrammarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class XPathParser {

//    public static void main(String[] args) {
//        XPathParser parser = new XPathParser();
//        parser.parse("doc(\"j_caesar.xml\")//ACT[not .//SPEAKER/text() = \"CAESAR\"]");
//    }

    public ParseTree parse(String query) {
        CharStream charStream = CharStreams.fromString(query);
        XPathGrammarLexer lexer = new XPathGrammarLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathGrammarParser parser = new XPathGrammarParser(tokens);

        return parser.absolutePath();
    }
}
