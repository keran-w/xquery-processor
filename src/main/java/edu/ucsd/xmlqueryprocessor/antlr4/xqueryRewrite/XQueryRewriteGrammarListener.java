// Generated from D:/Java-code/CSE232b_git/xquery-processor/src/main/java/edu/ucsd/xmlqueryprocessor/antlr4/xqueryRewrite/XQueryRewriteGrammar.g4 by ANTLR 4.13.1
package edu.ucsd.xmlqueryprocessor.antlr4.xqueryRewrite;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryRewriteGrammarParser}.
 */
public interface XQueryRewriteGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXquery(XQueryRewriteGrammarParser.XqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXquery(XQueryRewriteGrammarParser.XqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(XQueryRewriteGrammarParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(XQueryRewriteGrammarParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(XQueryRewriteGrammarParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(XQueryRewriteGrammarParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(XQueryRewriteGrammarParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(XQueryRewriteGrammarParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(XQueryRewriteGrammarParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(XQueryRewriteGrammarParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutePath(XQueryRewriteGrammarParser.AbsolutePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutePath(XQueryRewriteGrammarParser.AbsolutePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterRelativePath(XQueryRewriteGrammarParser.RelativePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitRelativePath(XQueryRewriteGrammarParser.RelativePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPathFilter(XQueryRewriteGrammarParser.PathFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPathFilter(XQueryRewriteGrammarParser.PathFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(XQueryRewriteGrammarParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(XQueryRewriteGrammarParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(XQueryRewriteGrammarParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(XQueryRewriteGrammarParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XQueryRewriteGrammarParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XQueryRewriteGrammarParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XQueryRewriteGrammarParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XQueryRewriteGrammarParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryRewriteGrammarParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(XQueryRewriteGrammarParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryRewriteGrammarParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(XQueryRewriteGrammarParser.StringConstantContext ctx);
}