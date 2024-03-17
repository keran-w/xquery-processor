// Generated from D:/Java-code/CSE232b_git/xquery-processor/src/main/java/edu/ucsd/xmlqueryprocessor/antlr4/xqueryRewrite/XQueryRewriteGrammar.g4 by ANTLR 4.13.1
package edu.ucsd.xmlqueryprocessor.antlr4.xqueryRewrite;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryRewriteGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryRewriteGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXquery(XQueryRewriteGrammarParser.XqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XQueryRewriteGrammarParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryRewriteGrammarParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryRewriteGrammarParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(XQueryRewriteGrammarParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#absolutePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolutePath(XQueryRewriteGrammarParser.AbsolutePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativePath(XQueryRewriteGrammarParser.RelativePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathFilter(XQueryRewriteGrammarParser.PathFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(XQueryRewriteGrammarParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XQueryRewriteGrammarParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryRewriteGrammarParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XQueryRewriteGrammarParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryRewriteGrammarParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(XQueryRewriteGrammarParser.StringConstantContext ctx);
}