// Generated from /Users/keranwang/Desktop/Winter 24/CSE 232B/project/xquery-processor/src/main/java/edu/ucsd/xmlqueryprocessor/antlr4/xpath/XPathGrammar.g4 by ANTLR 4.13.1
package edu.ucsd.xmlqueryprocessor.antlr4.xpath;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPathGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPathGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#absolutePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsolutePath(XPathGrammarParser.AbsolutePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativePath(XPathGrammarParser.RelativePathContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#rpLeaf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpLeaf(XPathGrammarParser.RpLeafContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#pathFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathFilter(XPathGrammarParser.PathFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#fileName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileName(XPathGrammarParser.FileNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XPathGrammarParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#attName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttName(XPathGrammarParser.AttNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#stringConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(XPathGrammarParser.StringConstantContext ctx);
}