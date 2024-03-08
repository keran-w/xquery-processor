// Generated from D:/Java-code/CSE232b_git/xquery-processor/src/main/java/edu/ucsd/xmlqueryprocessor/antlr4/xquery/XQueryGrammar.g4 by ANTLR 4.13.1
package edu.ucsd.xmlqueryprocessor.antlr4.xquery;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class XQueryGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, NAME=36, STRING=37, WS=38;
	public static final int
		RULE_xquery = 0, RULE_forClause = 1, RULE_letClause = 2, RULE_whereClause = 3, 
		RULE_returnClause = 4, RULE_cond = 5, RULE_absolutePath = 6, RULE_relativePath = 7, 
		RULE_pathFilter = 8, RULE_var = 9, RULE_fileName = 10, RULE_tagName = 11, 
		RULE_attName = 12, RULE_stringConstant = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"xquery", "forClause", "letClause", "whereClause", "returnClause", "cond", 
			"absolutePath", "relativePath", "pathFilter", "var", "fileName", "tagName", 
			"attName", "stringConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'/'", "'//'", "'<'", "'>'", "'{'", "'}'", 
			"'</'", "'for'", "'in'", "'let'", "':='", "'where'", "'return'", "'='", 
			"'eq'", "'=='", "'is'", "'empty'", "'some'", "'satisfies'", "'and'", 
			"'or'", "'not'", "'doc'", "'*'", "'.'", "'..'", "'text()'", "'['", "']'", 
			"'$'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"NAME", "STRING", "WS"
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
	public String getGrammarFileName() { return "XQueryGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryGrammarParser(TokenStream input) {
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
		public List<LetClauseContext> letClause() {
			return getRuleContexts(LetClauseContext.class);
		}
		public LetClauseContext letClause(int i) {
			return getRuleContext(LetClauseContext.class,i);
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
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterXquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitXquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitXquery(this);
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
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				{
				setState(29);
				var();
				}
				break;
			case STRING:
				{
				setState(30);
				stringConstant();
				}
				break;
			case T__26:
				{
				setState(31);
				absolutePath();
				}
				break;
			case T__0:
				{
				setState(32);
				match(T__0);
				setState(33);
				xquery(0);
				setState(34);
				match(T__1);
				}
				break;
			case T__5:
				{
				setState(36);
				match(T__5);
				setState(37);
				tagName();
				setState(38);
				match(T__6);
				setState(39);
				match(T__7);
				setState(40);
				xquery(0);
				setState(41);
				match(T__8);
				setState(42);
				match(T__9);
				setState(43);
				tagName();
				setState(44);
				match(T__6);
				}
				break;
			case T__10:
				{
				setState(46);
				forClause(0);
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(47);
					letClause(0);
					}
				}

				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(50);
					whereClause();
					}
				}

				setState(53);
				returnClause();
				}
				break;
			case T__12:
				{
				setState(55);
				letClause(0);
				setState(56);
				forClause(0);
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(57);
					letClause(0);
					}
				}

				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(60);
					whereClause();
					}
				}

				setState(63);
				returnClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(78);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(76);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new XqueryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xquery);
						setState(67);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(68);
						match(T__2);
						setState(69);
						xquery(7);
						}
						break;
					case 2:
						{
						_localctx = new XqueryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xquery);
						setState(70);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(71);
						match(T__3);
						setState(72);
						relativePath(0);
						}
						break;
					case 3:
						{
						_localctx = new XqueryContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xquery);
						setState(73);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(74);
						match(T__4);
						setState(75);
						relativePath(0);
						}
						break;
					}
					} 
				}
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitForClause(this);
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
			setState(82);
			match(T__10);
			setState(83);
			var();
			setState(84);
			match(T__11);
			setState(85);
			xquery(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ForClauseContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_forClause);
					setState(87);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(88);
					match(T__2);
					setState(89);
					var();
					setState(90);
					match(T__11);
					setState(91);
					xquery(0);
					}
					} 
				}
				setState(97);
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
	public static class LetClauseContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public XqueryContext xquery() {
			return getRuleContext(XqueryContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitLetClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitLetClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		return letClause(0);
	}

	private LetClauseContext letClause(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LetClauseContext _localctx = new LetClauseContext(_ctx, _parentState);
		LetClauseContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_letClause, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(99);
			match(T__12);
			setState(100);
			var();
			setState(101);
			match(T__13);
			setState(102);
			xquery(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LetClauseContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_letClause);
					setState(104);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(105);
					match(T__2);
					setState(106);
					match(T__12);
					setState(107);
					var();
					setState(108);
					match(T__13);
					setState(109);
					xquery(0);
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__14);
			setState(117);
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
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__15);
			setState(120);
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
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitCond(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(123);
				xquery(0);
				}
				break;
			case 2:
				{
				setState(124);
				xquery(0);
				setState(125);
				match(T__16);
				setState(126);
				xquery(0);
				}
				break;
			case 3:
				{
				setState(128);
				xquery(0);
				setState(129);
				match(T__17);
				setState(130);
				xquery(0);
				}
				break;
			case 4:
				{
				setState(132);
				xquery(0);
				setState(133);
				match(T__18);
				setState(134);
				xquery(0);
				}
				break;
			case 5:
				{
				setState(136);
				xquery(0);
				setState(137);
				match(T__19);
				setState(138);
				xquery(0);
				}
				break;
			case 6:
				{
				setState(140);
				match(T__20);
				setState(141);
				match(T__0);
				setState(142);
				xquery(0);
				setState(143);
				match(T__1);
				}
				break;
			case 7:
				{
				setState(145);
				match(T__21);
				setState(146);
				var();
				setState(147);
				match(T__11);
				setState(148);
				xquery(0);
				setState(149);
				match(T__22);
				setState(150);
				cond(5);
				}
				break;
			case 8:
				{
				setState(152);
				match(T__0);
				setState(153);
				cond(0);
				setState(154);
				match(T__1);
				}
				break;
			case 9:
				{
				setState(156);
				match(T__25);
				setState(157);
				cond(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(166);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(160);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(161);
						match(T__23);
						setState(162);
						cond(4);
						}
						break;
					case 2:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(163);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(164);
						match(T__24);
						setState(165);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(170);
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
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterAbsolutePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitAbsolutePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitAbsolutePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsolutePathContext absolutePath() throws RecognitionException {
		AbsolutePathContext _localctx = new AbsolutePathContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_absolutePath);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(T__26);
				setState(172);
				match(T__0);
				setState(173);
				fileName();
				setState(174);
				match(T__1);
				setState(175);
				match(T__3);
				setState(176);
				relativePath(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(T__26);
				setState(179);
				match(T__0);
				setState(180);
				fileName();
				setState(181);
				match(T__1);
				setState(182);
				match(T__4);
				setState(183);
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
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterRelativePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitRelativePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitRelativePath(this);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_relativePath, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(188);
				tagName();
				}
				break;
			case T__27:
				{
				setState(189);
				match(T__27);
				}
				break;
			case T__28:
				{
				setState(190);
				match(T__28);
				}
				break;
			case T__29:
				{
				setState(191);
				match(T__29);
				}
				break;
			case T__30:
				{
				setState(192);
				match(T__30);
				}
				break;
			case T__34:
				{
				setState(193);
				attName();
				}
				break;
			case T__0:
				{
				setState(194);
				match(T__0);
				setState(195);
				relativePath(0);
				setState(196);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(200);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(201);
						match(T__2);
						setState(202);
						relativePath(4);
						}
						break;
					case 2:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(203);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(204);
						match(T__3);
						setState(205);
						relativePath(3);
						}
						break;
					case 3:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(206);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(207);
						match(T__4);
						setState(208);
						relativePath(2);
						}
						break;
					case 4:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(209);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(210);
						match(T__31);
						setState(211);
						pathFilter(0);
						setState(212);
						match(T__32);
						}
						break;
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterPathFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitPathFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitPathFilter(this);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_pathFilter, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(220);
				relativePath(0);
				}
				break;
			case 2:
				{
				setState(221);
				relativePath(0);
				setState(222);
				match(T__16);
				setState(223);
				relativePath(0);
				}
				break;
			case 3:
				{
				setState(225);
				relativePath(0);
				setState(226);
				match(T__17);
				setState(227);
				relativePath(0);
				}
				break;
			case 4:
				{
				setState(229);
				relativePath(0);
				setState(230);
				match(T__18);
				setState(231);
				relativePath(0);
				}
				break;
			case 5:
				{
				setState(233);
				relativePath(0);
				setState(234);
				match(T__19);
				setState(235);
				relativePath(0);
				}
				break;
			case 6:
				{
				setState(237);
				relativePath(0);
				setState(238);
				match(T__16);
				setState(239);
				stringConstant();
				}
				break;
			case 7:
				{
				setState(241);
				match(T__0);
				setState(242);
				pathFilter(0);
				setState(243);
				match(T__1);
				}
				break;
			case 8:
				{
				setState(245);
				match(T__25);
				setState(246);
				pathFilter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(257);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(255);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new PathFilterContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(249);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(250);
						match(T__23);
						setState(251);
						pathFilter(4);
						}
						break;
					case 2:
						{
						_localctx = new PathFilterContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(252);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(253);
						match(T__24);
						setState(254);
						pathFilter(3);
						}
						break;
					}
					} 
				}
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		public TerminalNode NAME() { return getToken(XQueryGrammarParser.NAME, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__33);
			setState(261);
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
		public TerminalNode STRING() { return getToken(XQueryGrammarParser.STRING, 0); }
		public FileNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterFileName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitFileName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitFileName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileNameContext fileName() throws RecognitionException {
		FileNameContext _localctx = new FileNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fileName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
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
		public TerminalNode NAME() { return getToken(XQueryGrammarParser.NAME, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
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
		public TerminalNode NAME() { return getToken(XQueryGrammarParser.NAME, 0); }
		public AttNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterAttName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitAttName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitAttName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttNameContext attName() throws RecognitionException {
		AttNameContext _localctx = new AttNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__34);
			setState(268);
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
		public TerminalNode STRING() { return getToken(XQueryGrammarParser.STRING, 0); }
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryGrammarListener ) ((XQueryGrammarListener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryGrammarVisitor ) return ((XQueryGrammarVisitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stringConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
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
		case 2:
			return letClause_sempred((LetClauseContext)_localctx, predIndex);
		case 5:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 7:
			return relativePath_sempred((RelativePathContext)_localctx, predIndex);
		case 8:
			return pathFilter_sempred((PathFilterContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xquery_sempred(XqueryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
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
	private boolean letClause_sempred(LetClauseContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relativePath_sempred(RelativePathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		case 10:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean pathFilter_sempred(PathFilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u0111\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u00001\b\u0000"+
		"\u0001\u0000\u0003\u00004\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000;\b\u0000\u0001\u0000\u0003\u0000"+
		">\b\u0000\u0001\u0000\u0001\u0000\u0003\u0000B\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000M\b\u0000\n\u0000\f\u0000P\t\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001^\b\u0001\n\u0001\f\u0001a\t\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002p\b"+
		"\u0002\n\u0002\f\u0002s\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u009f\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00a7"+
		"\b\u0005\n\u0005\f\u0005\u00aa\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u00ba\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u00c7\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00d7\b\u0007"+
		"\n\u0007\f\u0007\u00da\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00f8\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0100\b\b\n\b\f\b\u0103\t\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0000\u0006\u0000\u0002\u0004"+
		"\n\u000e\u0010\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u0000\u0000\u012f\u0000A\u0001\u0000\u0000\u0000\u0002"+
		"Q\u0001\u0000\u0000\u0000\u0004b\u0001\u0000\u0000\u0000\u0006t\u0001"+
		"\u0000\u0000\u0000\bw\u0001\u0000\u0000\u0000\n\u009e\u0001\u0000\u0000"+
		"\u0000\f\u00b9\u0001\u0000\u0000\u0000\u000e\u00c6\u0001\u0000\u0000\u0000"+
		"\u0010\u00f7\u0001\u0000\u0000\u0000\u0012\u0104\u0001\u0000\u0000\u0000"+
		"\u0014\u0107\u0001\u0000\u0000\u0000\u0016\u0109\u0001\u0000\u0000\u0000"+
		"\u0018\u010b\u0001\u0000\u0000\u0000\u001a\u010e\u0001\u0000\u0000\u0000"+
		"\u001c\u001d\u0006\u0000\uffff\uffff\u0000\u001dB\u0003\u0012\t\u0000"+
		"\u001eB\u0003\u001a\r\u0000\u001fB\u0003\f\u0006\u0000 !\u0005\u0001\u0000"+
		"\u0000!\"\u0003\u0000\u0000\u0000\"#\u0005\u0002\u0000\u0000#B\u0001\u0000"+
		"\u0000\u0000$%\u0005\u0006\u0000\u0000%&\u0003\u0016\u000b\u0000&\'\u0005"+
		"\u0007\u0000\u0000\'(\u0005\b\u0000\u0000()\u0003\u0000\u0000\u0000)*"+
		"\u0005\t\u0000\u0000*+\u0005\n\u0000\u0000+,\u0003\u0016\u000b\u0000,"+
		"-\u0005\u0007\u0000\u0000-B\u0001\u0000\u0000\u0000.0\u0003\u0002\u0001"+
		"\u0000/1\u0003\u0004\u0002\u00000/\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u000013\u0001\u0000\u0000\u000024\u0003\u0006\u0003\u000032\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"56\u0003\b\u0004\u00006B\u0001\u0000\u0000\u000078\u0003\u0004\u0002\u0000"+
		"8:\u0003\u0002\u0001\u00009;\u0003\u0004\u0002\u0000:9\u0001\u0000\u0000"+
		"\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000\u0000<>\u0003\u0006"+
		"\u0003\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?@\u0003\b\u0004\u0000@B\u0001\u0000\u0000\u0000A\u001c"+
		"\u0001\u0000\u0000\u0000A\u001e\u0001\u0000\u0000\u0000A\u001f\u0001\u0000"+
		"\u0000\u0000A \u0001\u0000\u0000\u0000A$\u0001\u0000\u0000\u0000A.\u0001"+
		"\u0000\u0000\u0000A7\u0001\u0000\u0000\u0000BN\u0001\u0000\u0000\u0000"+
		"CD\n\u0006\u0000\u0000DE\u0005\u0003\u0000\u0000EM\u0003\u0000\u0000\u0007"+
		"FG\n\u0005\u0000\u0000GH\u0005\u0004\u0000\u0000HM\u0003\u000e\u0007\u0000"+
		"IJ\n\u0004\u0000\u0000JK\u0005\u0005\u0000\u0000KM\u0003\u000e\u0007\u0000"+
		"LC\u0001\u0000\u0000\u0000LF\u0001\u0000\u0000\u0000LI\u0001\u0000\u0000"+
		"\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000"+
		"\u0000\u0000O\u0001\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000"+
		"QR\u0006\u0001\uffff\uffff\u0000RS\u0005\u000b\u0000\u0000ST\u0003\u0012"+
		"\t\u0000TU\u0005\f\u0000\u0000UV\u0003\u0000\u0000\u0000V_\u0001\u0000"+
		"\u0000\u0000WX\n\u0001\u0000\u0000XY\u0005\u0003\u0000\u0000YZ\u0003\u0012"+
		"\t\u0000Z[\u0005\f\u0000\u0000[\\\u0003\u0000\u0000\u0000\\^\u0001\u0000"+
		"\u0000\u0000]W\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`\u0003\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000bc\u0006\u0002\uffff\uffff\u0000cd\u0005"+
		"\r\u0000\u0000de\u0003\u0012\t\u0000ef\u0005\u000e\u0000\u0000fg\u0003"+
		"\u0000\u0000\u0000gq\u0001\u0000\u0000\u0000hi\n\u0001\u0000\u0000ij\u0005"+
		"\u0003\u0000\u0000jk\u0005\r\u0000\u0000kl\u0003\u0012\t\u0000lm\u0005"+
		"\u000e\u0000\u0000mn\u0003\u0000\u0000\u0000np\u0001\u0000\u0000\u0000"+
		"oh\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000r\u0005\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000tu\u0005\u000f\u0000\u0000uv\u0003\n\u0005\u0000v\u0007"+
		"\u0001\u0000\u0000\u0000wx\u0005\u0010\u0000\u0000xy\u0003\u0000\u0000"+
		"\u0000y\t\u0001\u0000\u0000\u0000z{\u0006\u0005\uffff\uffff\u0000{\u009f"+
		"\u0003\u0000\u0000\u0000|}\u0003\u0000\u0000\u0000}~\u0005\u0011\u0000"+
		"\u0000~\u007f\u0003\u0000\u0000\u0000\u007f\u009f\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0003\u0000\u0000\u0000\u0081\u0082\u0005\u0012\u0000\u0000"+
		"\u0082\u0083\u0003\u0000\u0000\u0000\u0083\u009f\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0003\u0000\u0000\u0000\u0085\u0086\u0005\u0013\u0000\u0000"+
		"\u0086\u0087\u0003\u0000\u0000\u0000\u0087\u009f\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0003\u0000\u0000\u0000\u0089\u008a\u0005\u0014\u0000\u0000"+
		"\u008a\u008b\u0003\u0000\u0000\u0000\u008b\u009f\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0005\u0015\u0000\u0000\u008d\u008e\u0005\u0001\u0000\u0000"+
		"\u008e\u008f\u0003\u0000\u0000\u0000\u008f\u0090\u0005\u0002\u0000\u0000"+
		"\u0090\u009f\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u0016\u0000\u0000"+
		"\u0092\u0093\u0003\u0012\t\u0000\u0093\u0094\u0005\f\u0000\u0000\u0094"+
		"\u0095\u0003\u0000\u0000\u0000\u0095\u0096\u0005\u0017\u0000\u0000\u0096"+
		"\u0097\u0003\n\u0005\u0005\u0097\u009f\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005\u0001\u0000\u0000\u0099\u009a\u0003\n\u0005\u0000\u009a\u009b\u0005"+
		"\u0002\u0000\u0000\u009b\u009f\u0001\u0000\u0000\u0000\u009c\u009d\u0005"+
		"\u001a\u0000\u0000\u009d\u009f\u0003\n\u0005\u0001\u009ez\u0001\u0000"+
		"\u0000\u0000\u009e|\u0001\u0000\u0000\u0000\u009e\u0080\u0001\u0000\u0000"+
		"\u0000\u009e\u0084\u0001\u0000\u0000\u0000\u009e\u0088\u0001\u0000\u0000"+
		"\u0000\u009e\u008c\u0001\u0000\u0000\u0000\u009e\u0091\u0001\u0000\u0000"+
		"\u0000\u009e\u0098\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000"+
		"\u0000\u009f\u00a8\u0001\u0000\u0000\u0000\u00a0\u00a1\n\u0003\u0000\u0000"+
		"\u00a1\u00a2\u0005\u0018\u0000\u0000\u00a2\u00a7\u0003\n\u0005\u0004\u00a3"+
		"\u00a4\n\u0002\u0000\u0000\u00a4\u00a5\u0005\u0019\u0000\u0000\u00a5\u00a7"+
		"\u0003\n\u0005\u0003\u00a6\u00a0\u0001\u0000\u0000\u0000\u00a6\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u000b\u0001"+
		"\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		"\u001b\u0000\u0000\u00ac\u00ad\u0005\u0001\u0000\u0000\u00ad\u00ae\u0003"+
		"\u0014\n\u0000\u00ae\u00af\u0005\u0002\u0000\u0000\u00af\u00b0\u0005\u0004"+
		"\u0000\u0000\u00b0\u00b1\u0003\u000e\u0007\u0000\u00b1\u00ba\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0005\u001b\u0000\u0000\u00b3\u00b4\u0005\u0001"+
		"\u0000\u0000\u00b4\u00b5\u0003\u0014\n\u0000\u00b5\u00b6\u0005\u0002\u0000"+
		"\u0000\u00b6\u00b7\u0005\u0005\u0000\u0000\u00b7\u00b8\u0003\u000e\u0007"+
		"\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9\u00ab\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b2\u0001\u0000\u0000\u0000\u00ba\r\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0006\u0007\uffff\uffff\u0000\u00bc\u00c7\u0003\u0016\u000b"+
		"\u0000\u00bd\u00c7\u0005\u001c\u0000\u0000\u00be\u00c7\u0005\u001d\u0000"+
		"\u0000\u00bf\u00c7\u0005\u001e\u0000\u0000\u00c0\u00c7\u0005\u001f\u0000"+
		"\u0000\u00c1\u00c7\u0003\u0018\f\u0000\u00c2\u00c3\u0005\u0001\u0000\u0000"+
		"\u00c3\u00c4\u0003\u000e\u0007\u0000\u00c4\u00c5\u0005\u0002\u0000\u0000"+
		"\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00bb\u0001\u0000\u0000\u0000"+
		"\u00c6\u00bd\u0001\u0000\u0000\u0000\u00c6\u00be\u0001\u0000\u0000\u0000"+
		"\u00c6\u00bf\u0001\u0000\u0000\u0000\u00c6\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c1\u0001\u0000\u0000\u0000\u00c6\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c7\u00d8\u0001\u0000\u0000\u0000\u00c8\u00c9\n\u0003\u0000\u0000\u00c9"+
		"\u00ca\u0005\u0003\u0000\u0000\u00ca\u00d7\u0003\u000e\u0007\u0004\u00cb"+
		"\u00cc\n\u0002\u0000\u0000\u00cc\u00cd\u0005\u0004\u0000\u0000\u00cd\u00d7"+
		"\u0003\u000e\u0007\u0003\u00ce\u00cf\n\u0001\u0000\u0000\u00cf\u00d0\u0005"+
		"\u0005\u0000\u0000\u00d0\u00d7\u0003\u000e\u0007\u0002\u00d1\u00d2\n\u0005"+
		"\u0000\u0000\u00d2\u00d3\u0005 \u0000\u0000\u00d3\u00d4\u0003\u0010\b"+
		"\u0000\u00d4\u00d5\u0005!\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d6\u00c8\u0001\u0000\u0000\u0000\u00d6\u00cb\u0001\u0000\u0000\u0000"+
		"\u00d6\u00ce\u0001\u0000\u0000\u0000\u00d6\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u000f\u0001\u0000\u0000\u0000"+
		"\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00dc\u0006\b\uffff\uffff\u0000"+
		"\u00dc\u00f8\u0003\u000e\u0007\u0000\u00dd\u00de\u0003\u000e\u0007\u0000"+
		"\u00de\u00df\u0005\u0011\u0000\u0000\u00df\u00e0\u0003\u000e\u0007\u0000"+
		"\u00e0\u00f8\u0001\u0000\u0000\u0000\u00e1\u00e2\u0003\u000e\u0007\u0000"+
		"\u00e2\u00e3\u0005\u0012\u0000\u0000\u00e3\u00e4\u0003\u000e\u0007\u0000"+
		"\u00e4\u00f8\u0001\u0000\u0000\u0000\u00e5\u00e6\u0003\u000e\u0007\u0000"+
		"\u00e6\u00e7\u0005\u0013\u0000\u0000\u00e7\u00e8\u0003\u000e\u0007\u0000"+
		"\u00e8\u00f8\u0001\u0000\u0000\u0000\u00e9\u00ea\u0003\u000e\u0007\u0000"+
		"\u00ea\u00eb\u0005\u0014\u0000\u0000\u00eb\u00ec\u0003\u000e\u0007\u0000"+
		"\u00ec\u00f8\u0001\u0000\u0000\u0000\u00ed\u00ee\u0003\u000e\u0007\u0000"+
		"\u00ee\u00ef\u0005\u0011\u0000\u0000\u00ef\u00f0\u0003\u001a\r\u0000\u00f0"+
		"\u00f8\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005\u0001\u0000\u0000\u00f2"+
		"\u00f3\u0003\u0010\b\u0000\u00f3\u00f4\u0005\u0002\u0000\u0000\u00f4\u00f8"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\u001a\u0000\u0000\u00f6\u00f8"+
		"\u0003\u0010\b\u0001\u00f7\u00db\u0001\u0000\u0000\u0000\u00f7\u00dd\u0001"+
		"\u0000\u0000\u0000\u00f7\u00e1\u0001\u0000\u0000\u0000\u00f7\u00e5\u0001"+
		"\u0000\u0000\u0000\u00f7\u00e9\u0001\u0000\u0000\u0000\u00f7\u00ed\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f1\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f8\u0101\u0001\u0000\u0000\u0000\u00f9\u00fa\n\u0003"+
		"\u0000\u0000\u00fa\u00fb\u0005\u0018\u0000\u0000\u00fb\u0100\u0003\u0010"+
		"\b\u0004\u00fc\u00fd\n\u0002\u0000\u0000\u00fd\u00fe\u0005\u0019\u0000"+
		"\u0000\u00fe\u0100\u0003\u0010\b\u0003\u00ff\u00f9\u0001\u0000\u0000\u0000"+
		"\u00ff\u00fc\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000\u0000"+
		"\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000"+
		"\u0102\u0011\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0005\"\u0000\u0000\u0105\u0106\u0005$\u0000\u0000\u0106"+
		"\u0013\u0001\u0000\u0000\u0000\u0107\u0108\u0005%\u0000\u0000\u0108\u0015"+
		"\u0001\u0000\u0000\u0000\u0109\u010a\u0005$\u0000\u0000\u010a\u0017\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0005#\u0000\u0000\u010c\u010d\u0005$\u0000"+
		"\u0000\u010d\u0019\u0001\u0000\u0000\u0000\u010e\u010f\u0005%\u0000\u0000"+
		"\u010f\u001b\u0001\u0000\u0000\u0000\u001303:=ALN_q\u009e\u00a6\u00a8"+
		"\u00b9\u00c6\u00d6\u00d8\u00f7\u00ff\u0101";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}