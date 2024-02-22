// Generated from D:/Java-code/CSE232b_git/xquery-processor/src/main/java/edu/ucsd/xmlqueryprocessor/antlr4/xquery/XQueryGrammar.g4 by ANTLR 4.13.1
package edu.ucsd.xmlqueryprocessor.antlr4.xquery;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryGrammarParser}.
 */
public interface XQueryGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterXquery(XQueryGrammarParser.XqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitXquery(XQueryGrammarParser.XqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(XQueryGrammarParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(XQueryGrammarParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(XQueryGrammarParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(XQueryGrammarParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(XQueryGrammarParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(XQueryGrammarParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(XQueryGrammarParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(XQueryGrammarParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void enterAbsolutePath(XQueryGrammarParser.AbsolutePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void exitAbsolutePath(XQueryGrammarParser.AbsolutePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterRelativePath(XQueryGrammarParser.RelativePathContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitRelativePath(XQueryGrammarParser.RelativePathContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void enterPathFilter(XQueryGrammarParser.PathFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#pathFilter}.
	 * @param ctx the parse tree
	 */
	void exitPathFilter(XQueryGrammarParser.PathFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(XQueryGrammarParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(XQueryGrammarParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#fileName}.
	 * @param ctx the parse tree
	 */
	void enterFileName(XQueryGrammarParser.FileNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#fileName}.
	 * @param ctx the parse tree
	 */
	void exitFileName(XQueryGrammarParser.FileNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XQueryGrammarParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XQueryGrammarParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#attName}.
	 * @param ctx the parse tree
	 */
	void enterAttName(XQueryGrammarParser.AttNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#attName}.
	 * @param ctx the parse tree
	 */
	void exitAttName(XQueryGrammarParser.AttNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryGrammarParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(XQueryGrammarParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryGrammarParser#stringConstant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(XQueryGrammarParser.StringConstantContext ctx);
}