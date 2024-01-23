// Generated from /Users/keranwang/Desktop/Winter 24/CSE 232B/project/xquery-processor/src/main/java/edu/ucsd/xmlqueryprocessor/antlr4/XPathGrammar.g4 by ANTLR 4.13.1
package edu.ucsd.xmlqueryprocessor.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathGrammarParser}.
 */
public interface XPathGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutePath(XPathGrammarParser.AbsolutePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutePath(XPathGrammarParser.AbsolutePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterRelativePath(XPathGrammarParser.RelativePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitRelativePath(XPathGrammarParser.RelativePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#rpLeaf}.
	 * @param ctx the parse tree
	 */
	void enterRpLeaf(XPathGrammarParser.RpLeafContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#rpLeaf}.
	 * @param ctx the parse tree
	 */
	void exitRpLeaf(XPathGrammarParser.RpLeafContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPathFilter(XPathGrammarParser.PathFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPathFilter(XPathGrammarParser.PathFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(XPathGrammarParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(XPathGrammarParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XPathGrammarParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XPathGrammarParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XPathGrammarParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XPathGrammarParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(XPathGrammarParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(XPathGrammarParser.StringConstantContext ctx);
}