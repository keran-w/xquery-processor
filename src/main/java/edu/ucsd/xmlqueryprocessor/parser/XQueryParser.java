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


//import edu.ucsd.xmlqueryprocessor.antlr4.xquery.XQueryGrammarLexer;
//import edu.ucsd.xmlqueryprocessor.antlr4.xquery.XQueryGrammarParser;
//import org.antlr.v4.runtime.CharStream;
//import org.antlr.v4.runtime.CharStreams;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.RuleContext;
//import org.antlr.v4.runtime.tree.ParseTree;
//
//import java.util.HashMap;
//import java.util.HashSet;
//
//public class XQueryParser {
//
//    public XQueryGrammarParser parser;
//    public String[] ruleNames;
//
//    public XQueryParser(String query) {
//        parse(query);
//        ruleNames = parser.getRuleNames();
//    }
//
//    public static void main(String[] args) {
//
//
//        String query = SAMPLE_QUERY_1;
//        XQueryParser parser = new XQueryParser(query);
//        String[] ruleNames = parser.getRuleNames();
//        ParseTree root = parser.parser.xquery();
//        // xquery
//        root = root.getChild(4);
////        for (int i = 0; i < root.getChildCount(); i++) {
////            ParseTree child = root.getChild(i);
////            System.out.println(i + " " +parser.getRuleName(child) + "\t" + child.getText());
////        }
//        // forClause
//        ParseTree forClause = root.getChild(0);
//        parser.processForClause(forClause);
////        for (int i = 0; i < forClause.getChildCount(); i++) {
////            ParseTree child = forClause.getChild(i);
////            System.out.println(i + " " + parser.getRuleName(child) + "\t" + child.getText());
////        }
//
////        System.out.println(TreeUtil.toPrettyTree(parser.parser.xquery(), Arrays.asList(ruleNames)));
//
////        String filePath = "/Users/keranwang/Desktop/Winter 24/CSE 232B/project/xquery-processor/j_caesar.xml";
////        Node root = Objects.requireNonNull(XMLParser.parseXML(filePath)).getDocumentElement();
////        System.out.println(root.getNodeName());
//
//    }
//
//
//    public void processForClause(ParseTree root) {
//        HashMap<String, ParseTree> children = new HashMap<>();
//        for (int i = 0; i < root.getChildCount(); i++) {
//            ParseTree child = root.getChild(i);
//            String ruleName = getRuleName(child);
//            if (ruleName != null) {
//                children.put(ruleName, child);
//            }
//        }
//
//
//    }
//
//    public String getRuleName(ParseTree tree) {
//        if (tree instanceof RuleContext) {
//            return ruleNames[((RuleContext) tree).getRuleContext().getRuleIndex()];
//        } else {
//            return null;
//        }
//    }
//
//    public String[] getRuleNames() {
//        return parser.getRuleNames();
//    }
//
//    public void parse(String query) {
//        CharStream charStream = CharStreams.fromString(query);
//        XQueryGrammarLexer lexer = new XQueryGrammarLexer(charStream);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        parser = new XQueryGrammarParser(tokens);
//    }
//}
