// Generated from /Users/keranwang/Desktop/Winter 24/CSE 232B/project/xquery-processor/src/main/java/edu/ucsd/xmlqueryprocessor/antlr4/xquery/XQueryGrammar.g4 by ANTLR 4.13.1
package edu.ucsd.xmlqueryprocessor.antlr4.xquery;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXquery(XQueryGrammarParser.XqueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(XQueryGrammarParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XQueryGrammarParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XQueryGrammarParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryGrammarParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryGrammarParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(XQueryGrammarParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#absolutePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolutePath(XQueryGrammarParser.AbsolutePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativePath(XQueryGrammarParser.RelativePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathFilter(XQueryGrammarParser.PathFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(XQueryGrammarParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(XQueryGrammarParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XQueryGrammarParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryGrammarParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XQueryGrammarParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryGrammarParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(XQueryGrammarParser.StringConstantContext ctx);
}