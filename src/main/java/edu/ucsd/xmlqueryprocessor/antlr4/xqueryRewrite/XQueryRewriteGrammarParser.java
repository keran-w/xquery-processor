// Generated from D:/Java-code/CSE232b_git/xquery-processor/src/main/java/edu/ucsd/xmlqueryprocessor/antlr4/xqueryRewrite/XQueryRewriteGrammar.g4 by ANTLR 4.13.1
package edu.ucsd.xmlqueryprocessor.antlr4.xqueryRewrite;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class XQueryRewriteGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, Sep=34, NAME=35, STRING=36, WS=37;
	public static final int
		RULE_xquery = 0, RULE_forClause = 1, RULE_whereClause = 2, RULE_returnClause = 3, 
		RULE_cond = 4, RULE_absolutePath = 5, RULE_relativePath = 6, RULE_pathFilter = 7, 
		RULE_var = 8, RULE_fileName = 9, RULE_tagName = 10, RULE_attName = 11, 
		RULE_stringConstant = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"xquery", "forClause", "whereClause", "returnClause", "cond", "absolutePath", 
			"relativePath", "pathFilter", "var", "fileName", "tagName", "attName", 
			"stringConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'/'", "'//'", "'<'", "'>'", "'{'", "'}'", 
			"'</'", "'for'", "'in'", "'where'", "'return'", "'='", "'eq'", "'=='", 
			"'is'", "'empty'", "'some'", "'satisfies'", "'and'", "'or'", "'not'", 
			"'doc'", "'*'", "'.'", "'..'", "'text()'", "'['", "']'", "'$'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "Sep", "NAME", 
			"STRING", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XQueryRewriteGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryRewriteGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XqueryContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public AbsolutePathContext absolutePath() {
			return getRuleContext(AbsolutePathContext.class,0);
		}
		public List<XqueryContext> xquery() {
			return getRuleContexts(XqueryContext.class);
		}
		public XqueryContext xquery(int i) {
			return getRuleContext(XqueryContext.class,i);
		}
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public XqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterXquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitXquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitXquery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqueryContext xquery() throws RecognitionException {
		return xquery(0);
	}

	private XqueryContext xquery(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqueryContext _localctx = new XqueryContext(_ctx, _parentState);
		XqueryContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_xquery, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				{
				setState(27);
				var();
				}
				break;
			case STRING:
				{
				setState(28);
				stringConstant();
				}
				break;
			case T__24:
				{
				setState(29);
				absolutePath();
				}
				break;
			case T__0:
				{
				setState(30);
				match(T__0);
				setState(31);
				xquery(0);
				setState(32);
				match(T__1);
				}
				break;
			case T__5:
				{
				setState(34);
				match(T__5);
				setState(35);
				tagName();
				setState(36);
				match(T__6);
				setState(37);
				match(T__7);
				setState(38);
				xquery(0);
				setState(39);
				match(T__8);
				setState(40);
				match(T__9);
				setState(41);
				tagName();
				setState(42);
				match(T__6);
				}
				break;
			case T__10:
				{
				setState(44);
				forClause(0);
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(45);
					whereClause();
					}
				}

				setState(48);
				returnClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(61);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new XqueryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xquery);
						setState(52);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(53);
						match(T__2);
						setState(54);
						xquery(6);
						}
						break;
					case 2:
						{
						_localctx = new XqueryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xquery);
						setState(55);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(56);
						match(T__3);
						setState(57);
						relativePath(0);
						}
						break;
					case 3:
						{
						_localctx = new XqueryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xquery);
						setState(58);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(59);
						match(T__4);
						setState(60);
						relativePath(0);
						}
						break;
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForClauseContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public XqueryContext xquery() {
			return getRuleContext(XqueryContext.class,0);
		}
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitForClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		return forClause(0);
	}

	private ForClauseContext forClause(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ForClauseContext _localctx = new ForClauseContext(_ctx, _parentState);
		ForClauseContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_forClause, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(67);
			match(T__10);
			setState(68);
			var();
			setState(69);
			match(T__11);
			setState(70);
			xquery(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ForClauseContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_forClause);
					setState(72);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(73);
					match(T__2);
					setState(74);
					var();
					setState(75);
					match(T__11);
					setState(76);
					xquery(0);
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhereClauseContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__12);
			setState(84);
			cond(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnClauseContext extends ParserRuleContext {
		public XqueryContext xquery() {
			return getRuleContext(XqueryContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__13);
			setState(87);
			xquery(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondContext extends ParserRuleContext {
		public List<XqueryContext> xquery() {
			return getRuleContexts(XqueryContext.class);
		}
		public XqueryContext xquery(int i) {
			return getRuleContext(XqueryContext.class,i);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(90);
				xquery(0);
				}
				break;
			case 2:
				{
				setState(91);
				xquery(0);
				setState(92);
				match(T__14);
				setState(93);
				xquery(0);
				}
				break;
			case 3:
				{
				setState(95);
				xquery(0);
				setState(96);
				match(T__15);
				setState(97);
				xquery(0);
				}
				break;
			case 4:
				{
				setState(99);
				xquery(0);
				setState(100);
				match(T__16);
				setState(101);
				xquery(0);
				}
				break;
			case 5:
				{
				setState(103);
				xquery(0);
				setState(104);
				match(T__17);
				setState(105);
				xquery(0);
				}
				break;
			case 6:
				{
				setState(107);
				match(T__18);
				setState(108);
				match(T__0);
				setState(109);
				xquery(0);
				setState(110);
				match(T__1);
				}
				break;
			case 7:
				{
				setState(112);
				match(T__19);
				setState(113);
				var();
				setState(114);
				match(T__11);
				setState(115);
				xquery(0);
				setState(116);
				match(T__20);
				setState(117);
				cond(5);
				}
				break;
			case 8:
				{
				setState(119);
				match(T__0);
				setState(120);
				cond(0);
				setState(121);
				match(T__1);
				}
				break;
			case 9:
				{
				setState(123);
				match(T__23);
				setState(124);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(133);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(127);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(128);
						match(T__21);
						setState(129);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(130);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(131);
						match(T__22);
						setState(132);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbsolutePathContext extends ParserRuleContext {
		public FileNameContext fileName() {
			return getRuleContext(FileNameContext.class,0);
		}
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public AbsolutePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absolutePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterAbsolutePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitAbsolutePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitAbsolutePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsolutePathContext absolutePath() throws RecognitionException {
		AbsolutePathContext _localctx = new AbsolutePathContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_absolutePath);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(T__24);
				setState(139);
				match(T__0);
				setState(140);
				fileName();
				setState(141);
				match(T__1);
				setState(142);
				match(T__3);
				setState(143);
				relativePath(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(T__24);
				setState(146);
				match(T__0);
				setState(147);
				fileName();
				setState(148);
				match(T__1);
				setState(149);
				match(T__4);
				setState(150);
				relativePath(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelativePathContext extends ParserRuleContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public AttNameContext attName() {
			return getRuleContext(AttNameContext.class,0);
		}
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public PathFilterContext pathFilter() {
			return getRuleContext(PathFilterContext.class,0);
		}
		public RelativePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relativePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterRelativePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitRelativePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitRelativePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelativePathContext relativePath() throws RecognitionException {
		return relativePath(0);
	}

	private RelativePathContext relativePath(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelativePathContext _localctx = new RelativePathContext(_ctx, _parentState);
		RelativePathContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_relativePath, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(155);
				tagName();
				}
				break;
			case T__25:
				{
				setState(156);
				match(T__25);
				}
				break;
			case T__26:
				{
				setState(157);
				match(T__26);
				}
				break;
			case T__27:
				{
				setState(158);
				match(T__27);
				}
				break;
			case T__28:
				{
				setState(159);
				match(T__28);
				}
				break;
			case T__32:
				{
				setState(160);
				attName();
				}
				break;
			case T__0:
				{
				setState(161);
				match(T__0);
				setState(162);
				relativePath(0);
				setState(163);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(181);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(167);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(168);
						match(T__2);
						setState(169);
						relativePath(4);
						}
						break;
					case 2:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(170);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(171);
						match(T__3);
						setState(172);
						relativePath(3);
						}
						break;
					case 3:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(173);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(174);
						match(T__4);
						setState(175);
						relativePath(2);
						}
						break;
					case 4:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(176);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(177);
						match(T__29);
						setState(178);
						pathFilter(0);
						setState(179);
						match(T__30);
						}
						break;
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PathFilterContext extends ParserRuleContext {
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public List<PathFilterContext> pathFilter() {
			return getRuleContexts(PathFilterContext.class);
		}
		public PathFilterContext pathFilter(int i) {
			return getRuleContext(PathFilterContext.class,i);
		}
		public PathFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterPathFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitPathFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitPathFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathFilterContext pathFilter() throws RecognitionException {
		return pathFilter(0);
	}

	private PathFilterContext pathFilter(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PathFilterContext _localctx = new PathFilterContext(_ctx, _parentState);
		PathFilterContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_pathFilter, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(187);
				relativePath(0);
				}
				break;
			case 2:
				{
				setState(188);
				relativePath(0);
				setState(189);
				match(T__14);
				setState(190);
				relativePath(0);
				}
				break;
			case 3:
				{
				setState(192);
				relativePath(0);
				setState(193);
				match(T__15);
				setState(194);
				relativePath(0);
				}
				break;
			case 4:
				{
				setState(196);
				relativePath(0);
				setState(197);
				match(T__16);
				setState(198);
				relativePath(0);
				}
				break;
			case 5:
				{
				setState(200);
				relativePath(0);
				setState(201);
				match(T__17);
				setState(202);
				relativePath(0);
				}
				break;
			case 6:
				{
				setState(204);
				relativePath(0);
				setState(205);
				match(T__14);
				setState(206);
				stringConstant();
				}
				break;
			case 7:
				{
				setState(208);
				match(T__0);
				setState(209);
				pathFilter(0);
				setState(210);
				match(T__1);
				}
				break;
			case 8:
				{
				setState(212);
				match(T__23);
				setState(213);
				pathFilter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(222);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new PathFilterContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(216);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(217);
						match(T__21);
						setState(218);
						pathFilter(4);
						}
						break;
					case 2:
						{
						_localctx = new PathFilterContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(219);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(220);
						match(T__22);
						setState(221);
						pathFilter(3);
						}
						break;
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(XQueryRewriteGrammarParser.NAME, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(T__31);
			setState(228);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XQueryRewriteGrammarParser.STRING, 0); }
		public FileNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterFileName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitFileName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitFileName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileNameContext fileName() throws RecognitionException {
		FileNameContext _localctx = new FileNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fileName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(XQueryRewriteGrammarParser.NAME, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(XQueryRewriteGrammarParser.NAME, 0); }
		public AttNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterAttName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitAttName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitAttName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttNameContext attName() throws RecognitionException {
		AttNameContext _localctx = new AttNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__32);
			setState(235);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringConstantContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XQueryRewriteGrammarParser.STRING, 0); }
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryRewriteGrammarListener ) ((XQueryRewriteGrammarListener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryRewriteGrammarVisitor ) return ((XQueryRewriteGrammarVisitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stringConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return xquery_sempred((XqueryContext)_localctx, predIndex);
		case 1:
			return forClause_sempred((ForClauseContext)_localctx, predIndex);
		case 4:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 6:
			return relativePath_sempred((RelativePathContext)_localctx, predIndex);
		case 7:
			return pathFilter_sempred((PathFilterContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xquery_sempred(XqueryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean forClause_sempred(ForClauseContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relativePath_sempred(RelativePathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		case 9:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean pathFilter_sempred(PathFilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00f0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000/\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u00003\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000>\b\u0000\n\u0000\f\u0000A\t\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001O\b\u0001"+
		"\n\u0001\f\u0001R\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004~\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0086\b\u0004"+
		"\n\u0004\f\u0004\u0089\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0099"+
		"\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00a6\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00b6\b\u0006\n"+
		"\u0006\f\u0006\u00b9\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00d7\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00df\b\u0007\n\u0007\f\u0007"+
		"\u00e2\t\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0000\u0005"+
		"\u0000\u0002\b\f\u000e\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u0000\u0000\u010a\u00002\u0001\u0000\u0000\u0000\u0002"+
		"B\u0001\u0000\u0000\u0000\u0004S\u0001\u0000\u0000\u0000\u0006V\u0001"+
		"\u0000\u0000\u0000\b}\u0001\u0000\u0000\u0000\n\u0098\u0001\u0000\u0000"+
		"\u0000\f\u00a5\u0001\u0000\u0000\u0000\u000e\u00d6\u0001\u0000\u0000\u0000"+
		"\u0010\u00e3\u0001\u0000\u0000\u0000\u0012\u00e6\u0001\u0000\u0000\u0000"+
		"\u0014\u00e8\u0001\u0000\u0000\u0000\u0016\u00ea\u0001\u0000\u0000\u0000"+
		"\u0018\u00ed\u0001\u0000\u0000\u0000\u001a\u001b\u0006\u0000\uffff\uffff"+
		"\u0000\u001b3\u0003\u0010\b\u0000\u001c3\u0003\u0018\f\u0000\u001d3\u0003"+
		"\n\u0005\u0000\u001e\u001f\u0005\u0001\u0000\u0000\u001f \u0003\u0000"+
		"\u0000\u0000 !\u0005\u0002\u0000\u0000!3\u0001\u0000\u0000\u0000\"#\u0005"+
		"\u0006\u0000\u0000#$\u0003\u0014\n\u0000$%\u0005\u0007\u0000\u0000%&\u0005"+
		"\b\u0000\u0000&\'\u0003\u0000\u0000\u0000\'(\u0005\t\u0000\u0000()\u0005"+
		"\n\u0000\u0000)*\u0003\u0014\n\u0000*+\u0005\u0007\u0000\u0000+3\u0001"+
		"\u0000\u0000\u0000,.\u0003\u0002\u0001\u0000-/\u0003\u0004\u0002\u0000"+
		".-\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000"+
		"\u000001\u0003\u0006\u0003\u000013\u0001\u0000\u0000\u00002\u001a\u0001"+
		"\u0000\u0000\u00002\u001c\u0001\u0000\u0000\u00002\u001d\u0001\u0000\u0000"+
		"\u00002\u001e\u0001\u0000\u0000\u00002\"\u0001\u0000\u0000\u00002,\u0001"+
		"\u0000\u0000\u00003?\u0001\u0000\u0000\u000045\n\u0005\u0000\u000056\u0005"+
		"\u0003\u0000\u00006>\u0003\u0000\u0000\u000678\n\u0004\u0000\u000089\u0005"+
		"\u0004\u0000\u00009>\u0003\f\u0006\u0000:;\n\u0003\u0000\u0000;<\u0005"+
		"\u0005\u0000\u0000<>\u0003\f\u0006\u0000=4\u0001\u0000\u0000\u0000=7\u0001"+
		"\u0000\u0000\u0000=:\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000"+
		"?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@\u0001\u0001\u0000"+
		"\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0006\u0001\uffff\uffff\u0000"+
		"CD\u0005\u000b\u0000\u0000DE\u0003\u0010\b\u0000EF\u0005\f\u0000\u0000"+
		"FG\u0003\u0000\u0000\u0000GP\u0001\u0000\u0000\u0000HI\n\u0001\u0000\u0000"+
		"IJ\u0005\u0003\u0000\u0000JK\u0003\u0010\b\u0000KL\u0005\f\u0000\u0000"+
		"LM\u0003\u0000\u0000\u0000MO\u0001\u0000\u0000\u0000NH\u0001\u0000\u0000"+
		"\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000"+
		"\u0000\u0000Q\u0003\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"ST\u0005\r\u0000\u0000TU\u0003\b\u0004\u0000U\u0005\u0001\u0000\u0000"+
		"\u0000VW\u0005\u000e\u0000\u0000WX\u0003\u0000\u0000\u0000X\u0007\u0001"+
		"\u0000\u0000\u0000YZ\u0006\u0004\uffff\uffff\u0000Z~\u0003\u0000\u0000"+
		"\u0000[\\\u0003\u0000\u0000\u0000\\]\u0005\u000f\u0000\u0000]^\u0003\u0000"+
		"\u0000\u0000^~\u0001\u0000\u0000\u0000_`\u0003\u0000\u0000\u0000`a\u0005"+
		"\u0010\u0000\u0000ab\u0003\u0000\u0000\u0000b~\u0001\u0000\u0000\u0000"+
		"cd\u0003\u0000\u0000\u0000de\u0005\u0011\u0000\u0000ef\u0003\u0000\u0000"+
		"\u0000f~\u0001\u0000\u0000\u0000gh\u0003\u0000\u0000\u0000hi\u0005\u0012"+
		"\u0000\u0000ij\u0003\u0000\u0000\u0000j~\u0001\u0000\u0000\u0000kl\u0005"+
		"\u0013\u0000\u0000lm\u0005\u0001\u0000\u0000mn\u0003\u0000\u0000\u0000"+
		"no\u0005\u0002\u0000\u0000o~\u0001\u0000\u0000\u0000pq\u0005\u0014\u0000"+
		"\u0000qr\u0003\u0010\b\u0000rs\u0005\f\u0000\u0000st\u0003\u0000\u0000"+
		"\u0000tu\u0005\u0015\u0000\u0000uv\u0003\b\u0004\u0005v~\u0001\u0000\u0000"+
		"\u0000wx\u0005\u0001\u0000\u0000xy\u0003\b\u0004\u0000yz\u0005\u0002\u0000"+
		"\u0000z~\u0001\u0000\u0000\u0000{|\u0005\u0018\u0000\u0000|~\u0003\b\u0004"+
		"\u0001}Y\u0001\u0000\u0000\u0000}[\u0001\u0000\u0000\u0000}_\u0001\u0000"+
		"\u0000\u0000}c\u0001\u0000\u0000\u0000}g\u0001\u0000\u0000\u0000}k\u0001"+
		"\u0000\u0000\u0000}p\u0001\u0000\u0000\u0000}w\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000~\u0087\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\n\u0003\u0000\u0000\u0080\u0081\u0005\u0016\u0000\u0000\u0081\u0086\u0003"+
		"\b\u0004\u0004\u0082\u0083\n\u0002\u0000\u0000\u0083\u0084\u0005\u0017"+
		"\u0000\u0000\u0084\u0086\u0003\b\u0004\u0003\u0085\u007f\u0001\u0000\u0000"+
		"\u0000\u0085\u0082\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\t\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\u0019\u0000\u0000\u008b\u008c\u0005\u0001\u0000\u0000"+
		"\u008c\u008d\u0003\u0012\t\u0000\u008d\u008e\u0005\u0002\u0000\u0000\u008e"+
		"\u008f\u0005\u0004\u0000\u0000\u008f\u0090\u0003\f\u0006\u0000\u0090\u0099"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u0019\u0000\u0000\u0092\u0093"+
		"\u0005\u0001\u0000\u0000\u0093\u0094\u0003\u0012\t\u0000\u0094\u0095\u0005"+
		"\u0002\u0000\u0000\u0095\u0096\u0005\u0005\u0000\u0000\u0096\u0097\u0003"+
		"\f\u0006\u0000\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u008a\u0001\u0000"+
		"\u0000\u0000\u0098\u0091\u0001\u0000\u0000\u0000\u0099\u000b\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0006\u0006\uffff\uffff\u0000\u009b\u00a6\u0003"+
		"\u0014\n\u0000\u009c\u00a6\u0005\u001a\u0000\u0000\u009d\u00a6\u0005\u001b"+
		"\u0000\u0000\u009e\u00a6\u0005\u001c\u0000\u0000\u009f\u00a6\u0005\u001d"+
		"\u0000\u0000\u00a0\u00a6\u0003\u0016\u000b\u0000\u00a1\u00a2\u0005\u0001"+
		"\u0000\u0000\u00a2\u00a3\u0003\f\u0006\u0000\u00a3\u00a4\u0005\u0002\u0000"+
		"\u0000\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u009a\u0001\u0000\u0000"+
		"\u0000\u00a5\u009c\u0001\u0000\u0000\u0000\u00a5\u009d\u0001\u0000\u0000"+
		"\u0000\u00a5\u009e\u0001\u0000\u0000\u0000\u00a5\u009f\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a0\u0001\u0000\u0000\u0000\u00a5\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a6\u00b7\u0001\u0000\u0000\u0000\u00a7\u00a8\n\u0003\u0000\u0000"+
		"\u00a8\u00a9\u0005\u0003\u0000\u0000\u00a9\u00b6\u0003\f\u0006\u0004\u00aa"+
		"\u00ab\n\u0002\u0000\u0000\u00ab\u00ac\u0005\u0004\u0000\u0000\u00ac\u00b6"+
		"\u0003\f\u0006\u0003\u00ad\u00ae\n\u0001\u0000\u0000\u00ae\u00af\u0005"+
		"\u0005\u0000\u0000\u00af\u00b6\u0003\f\u0006\u0002\u00b0\u00b1\n\u0005"+
		"\u0000\u0000\u00b1\u00b2\u0005\u001e\u0000\u0000\u00b2\u00b3\u0003\u000e"+
		"\u0007\u0000\u00b3\u00b4\u0005\u001f\u0000\u0000\u00b4\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b5\u00a7\u0001\u0000\u0000\u0000\u00b5\u00aa\u0001\u0000"+
		"\u0000\u0000\u00b5\u00ad\u0001\u0000\u0000\u0000\u00b5\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\r\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bb\u0006\u0007\uffff"+
		"\uffff\u0000\u00bb\u00d7\u0003\f\u0006\u0000\u00bc\u00bd\u0003\f\u0006"+
		"\u0000\u00bd\u00be\u0005\u000f\u0000\u0000\u00be\u00bf\u0003\f\u0006\u0000"+
		"\u00bf\u00d7\u0001\u0000\u0000\u0000\u00c0\u00c1\u0003\f\u0006\u0000\u00c1"+
		"\u00c2\u0005\u0010\u0000\u0000\u00c2\u00c3\u0003\f\u0006\u0000\u00c3\u00d7"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0003\f\u0006\u0000\u00c5\u00c6\u0005"+
		"\u0011\u0000\u0000\u00c6\u00c7\u0003\f\u0006\u0000\u00c7\u00d7\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c9\u0003\f\u0006\u0000\u00c9\u00ca\u0005\u0012\u0000"+
		"\u0000\u00ca\u00cb\u0003\f\u0006\u0000\u00cb\u00d7\u0001\u0000\u0000\u0000"+
		"\u00cc\u00cd\u0003\f\u0006\u0000\u00cd\u00ce\u0005\u000f\u0000\u0000\u00ce"+
		"\u00cf\u0003\u0018\f\u0000\u00cf\u00d7\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u0005\u0001\u0000\u0000\u00d1\u00d2\u0003\u000e\u0007\u0000\u00d2\u00d3"+
		"\u0005\u0002\u0000\u0000\u00d3\u00d7\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0005\u0018\u0000\u0000\u00d5\u00d7\u0003\u000e\u0007\u0001\u00d6\u00ba"+
		"\u0001\u0000\u0000\u0000\u00d6\u00bc\u0001\u0000\u0000\u0000\u00d6\u00c0"+
		"\u0001\u0000\u0000\u0000\u00d6\u00c4\u0001\u0000\u0000\u0000\u00d6\u00c8"+
		"\u0001\u0000\u0000\u0000\u00d6\u00cc\u0001\u0000\u0000\u0000\u00d6\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00e0"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\n\u0003\u0000\u0000\u00d9\u00da\u0005"+
		"\u0016\u0000\u0000\u00da\u00df\u0003\u000e\u0007\u0004\u00db\u00dc\n\u0002"+
		"\u0000\u0000\u00dc\u00dd\u0005\u0017\u0000\u0000\u00dd\u00df\u0003\u000e"+
		"\u0007\u0003\u00de\u00d8\u0001\u0000\u0000\u0000\u00de\u00db\u0001\u0000"+
		"\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u000f\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005 \u0000"+
		"\u0000\u00e4\u00e5\u0005#\u0000\u0000\u00e5\u0011\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0005$\u0000\u0000\u00e7\u0013\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e9\u0005#\u0000\u0000\u00e9\u0015\u0001\u0000\u0000\u0000\u00ea\u00eb"+
		"\u0005!\u0000\u0000\u00eb\u00ec\u0005#\u0000\u0000\u00ec\u0017\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ee\u0005$\u0000\u0000\u00ee\u0019\u0001\u0000\u0000"+
		"\u0000\u000f.2=?P}\u0085\u0087\u0098\u00a5\u00b5\u00b7\u00d6\u00de\u00e0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}