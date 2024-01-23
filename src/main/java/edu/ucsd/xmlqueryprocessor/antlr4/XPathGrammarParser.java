// Generated from /Users/keranwang/Desktop/Winter 24/CSE 232B/project/xquery-processor/src/main/java/edu/ucsd/xmlqueryprocessor/antlr4/XPathGrammar.g4 by ANTLR 4.13.1
package edu.ucsd.xmlqueryprocessor.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class XPathGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, NAME=22, STRING=23, WS=24;
	public static final int
		RULE_absolutePath = 0, RULE_relativePath = 1, RULE_rpLeaf = 2, RULE_pathFilter = 3, 
		RULE_fileName = 4, RULE_tagName = 5, RULE_attName = 6, RULE_stringConstant = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"absolutePath", "relativePath", "rpLeaf", "pathFilter", "fileName", "tagName", 
			"attName", "stringConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'doc'", "'('", "')'", "'/'", "'//'", "'['", "']'", "','", "'*'", 
			"'.'", "'..'", "'text()'", "'@'", "'='", "'eq'", "'=='", "'is'", "' = '", 
			"'and'", "'or'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "NAME", "STRING", 
			"WS"
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
	public String getGrammarFileName() { return "XPathGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterAbsolutePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitAbsolutePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitAbsolutePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsolutePathContext absolutePath() throws RecognitionException {
		AbsolutePathContext _localctx = new AbsolutePathContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_absolutePath);
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				match(T__0);
				setState(17);
				match(T__1);
				setState(18);
				fileName();
				setState(19);
				match(T__2);
				setState(20);
				match(T__3);
				setState(21);
				relativePath(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				match(T__0);
				setState(24);
				match(T__1);
				setState(25);
				fileName();
				setState(26);
				match(T__2);
				setState(27);
				match(T__4);
				setState(28);
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
		public RpLeafContext rpLeaf() {
			return getRuleContext(RpLeafContext.class,0);
		}
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterRelativePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitRelativePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitRelativePath(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_relativePath, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(33);
				rpLeaf();
				}
				break;
			case 2:
				{
				setState(34);
				match(T__1);
				setState(35);
				relativePath(0);
				setState(36);
				match(T__2);
				}
				break;
			case 3:
				{
				setState(38);
				rpLeaf();
				setState(39);
				match(T__7);
				setState(40);
				relativePath(3);
				}
				break;
			case 4:
				{
				setState(42);
				rpLeaf();
				setState(43);
				match(T__3);
				setState(44);
				relativePath(2);
				}
				break;
			case 5:
				{
				setState(46);
				rpLeaf();
				setState(47);
				match(T__4);
				setState(48);
				relativePath(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelativePathContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
					setState(52);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(53);
					match(T__5);
					setState(54);
					pathFilter(0);
					setState(55);
					match(T__6);
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
	public static class RpLeafContext extends ParserRuleContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public AttNameContext attName() {
			return getRuleContext(AttNameContext.class,0);
		}
		public RpLeafContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpLeaf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterRpLeaf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitRpLeaf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitRpLeaf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpLeafContext rpLeaf() throws RecognitionException {
		RpLeafContext _localctx = new RpLeafContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rpLeaf);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				tagName();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				match(T__10);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				match(T__11);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(67);
				match(T__12);
				setState(68);
				attName();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterPathFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitPathFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitPathFilter(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_pathFilter, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(72);
				relativePath(0);
				}
				break;
			case 2:
				{
				setState(73);
				relativePath(0);
				setState(74);
				match(T__13);
				setState(75);
				relativePath(0);
				}
				break;
			case 3:
				{
				setState(77);
				relativePath(0);
				setState(78);
				match(T__14);
				setState(79);
				relativePath(0);
				}
				break;
			case 4:
				{
				setState(81);
				relativePath(0);
				setState(82);
				match(T__15);
				setState(83);
				relativePath(0);
				}
				break;
			case 5:
				{
				setState(85);
				relativePath(0);
				setState(86);
				match(T__16);
				setState(87);
				relativePath(0);
				}
				break;
			case 6:
				{
				setState(89);
				relativePath(0);
				setState(90);
				match(T__17);
				setState(91);
				stringConstant();
				}
				break;
			case 7:
				{
				setState(93);
				match(T__1);
				setState(94);
				pathFilter(0);
				setState(95);
				match(T__2);
				}
				break;
			case 8:
				{
				setState(97);
				match(T__20);
				setState(98);
				pathFilter(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(107);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new PathFilterContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(101);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(102);
						match(T__18);
						setState(103);
						pathFilter(4);
						}
						break;
					case 2:
						{
						_localctx = new PathFilterContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
						setState(104);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(105);
						match(T__19);
						setState(106);
						pathFilter(3);
						}
						break;
					}
					} 
				}
				setState(111);
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
	public static class FileNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XPathGrammarParser.STRING, 0); }
		public FileNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterFileName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitFileName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitFileName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileNameContext fileName() throws RecognitionException {
		FileNameContext _localctx = new FileNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fileName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
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
		public TerminalNode NAME() { return getToken(XPathGrammarParser.NAME, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
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
		public TerminalNode NAME() { return getToken(XPathGrammarParser.NAME, 0); }
		public AttNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterAttName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitAttName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitAttName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttNameContext attName() throws RecognitionException {
		AttNameContext _localctx = new AttNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
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
		public TerminalNode STRING() { return getToken(XPathGrammarParser.STRING, 0); }
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stringConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
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
		case 1:
			return relativePath_sempred((RelativePathContext)_localctx, predIndex);
		case 3:
			return pathFilter_sempred((PathFilterContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean relativePath_sempred(RelativePathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean pathFilter_sempred(PathFilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018y\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000\u001f\b\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00013\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001:\b"+
		"\u0001\n\u0001\f\u0001=\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002F\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003d\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003l\b\u0003\n\u0003\f\u0003o\t\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0000\u0002\u0002\u0006\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000"+
		"\u0000\u0084\u0000\u001e\u0001\u0000\u0000\u0000\u00022\u0001\u0000\u0000"+
		"\u0000\u0004E\u0001\u0000\u0000\u0000\u0006c\u0001\u0000\u0000\u0000\b"+
		"p\u0001\u0000\u0000\u0000\nr\u0001\u0000\u0000\u0000\ft\u0001\u0000\u0000"+
		"\u0000\u000ev\u0001\u0000\u0000\u0000\u0010\u0011\u0005\u0001\u0000\u0000"+
		"\u0011\u0012\u0005\u0002\u0000\u0000\u0012\u0013\u0003\b\u0004\u0000\u0013"+
		"\u0014\u0005\u0003\u0000\u0000\u0014\u0015\u0005\u0004\u0000\u0000\u0015"+
		"\u0016\u0003\u0002\u0001\u0000\u0016\u001f\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0005\u0001\u0000\u0000\u0018\u0019\u0005\u0002\u0000\u0000\u0019"+
		"\u001a\u0003\b\u0004\u0000\u001a\u001b\u0005\u0003\u0000\u0000\u001b\u001c"+
		"\u0005\u0005\u0000\u0000\u001c\u001d\u0003\u0002\u0001\u0000\u001d\u001f"+
		"\u0001\u0000\u0000\u0000\u001e\u0010\u0001\u0000\u0000\u0000\u001e\u0017"+
		"\u0001\u0000\u0000\u0000\u001f\u0001\u0001\u0000\u0000\u0000 !\u0006\u0001"+
		"\uffff\uffff\u0000!3\u0003\u0004\u0002\u0000\"#\u0005\u0002\u0000\u0000"+
		"#$\u0003\u0002\u0001\u0000$%\u0005\u0003\u0000\u0000%3\u0001\u0000\u0000"+
		"\u0000&\'\u0003\u0004\u0002\u0000\'(\u0005\b\u0000\u0000()\u0003\u0002"+
		"\u0001\u0003)3\u0001\u0000\u0000\u0000*+\u0003\u0004\u0002\u0000+,\u0005"+
		"\u0004\u0000\u0000,-\u0003\u0002\u0001\u0002-3\u0001\u0000\u0000\u0000"+
		"./\u0003\u0004\u0002\u0000/0\u0005\u0005\u0000\u000001\u0003\u0002\u0001"+
		"\u000113\u0001\u0000\u0000\u00002 \u0001\u0000\u0000\u00002\"\u0001\u0000"+
		"\u0000\u00002&\u0001\u0000\u0000\u00002*\u0001\u0000\u0000\u00002.\u0001"+
		"\u0000\u0000\u00003;\u0001\u0000\u0000\u000045\n\u0005\u0000\u000056\u0005"+
		"\u0006\u0000\u000067\u0003\u0006\u0003\u000078\u0005\u0007\u0000\u0000"+
		"8:\u0001\u0000\u0000\u000094\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000"+
		"\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<\u0003\u0001"+
		"\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>F\u0003\n\u0005\u0000?F\u0005"+
		"\t\u0000\u0000@F\u0005\n\u0000\u0000AF\u0005\u000b\u0000\u0000BF\u0005"+
		"\f\u0000\u0000CD\u0005\r\u0000\u0000DF\u0003\f\u0006\u0000E>\u0001\u0000"+
		"\u0000\u0000E?\u0001\u0000\u0000\u0000E@\u0001\u0000\u0000\u0000EA\u0001"+
		"\u0000\u0000\u0000EB\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"F\u0005\u0001\u0000\u0000\u0000GH\u0006\u0003\uffff\uffff\u0000Hd\u0003"+
		"\u0002\u0001\u0000IJ\u0003\u0002\u0001\u0000JK\u0005\u000e\u0000\u0000"+
		"KL\u0003\u0002\u0001\u0000Ld\u0001\u0000\u0000\u0000MN\u0003\u0002\u0001"+
		"\u0000NO\u0005\u000f\u0000\u0000OP\u0003\u0002\u0001\u0000Pd\u0001\u0000"+
		"\u0000\u0000QR\u0003\u0002\u0001\u0000RS\u0005\u0010\u0000\u0000ST\u0003"+
		"\u0002\u0001\u0000Td\u0001\u0000\u0000\u0000UV\u0003\u0002\u0001\u0000"+
		"VW\u0005\u0011\u0000\u0000WX\u0003\u0002\u0001\u0000Xd\u0001\u0000\u0000"+
		"\u0000YZ\u0003\u0002\u0001\u0000Z[\u0005\u0012\u0000\u0000[\\\u0003\u000e"+
		"\u0007\u0000\\d\u0001\u0000\u0000\u0000]^\u0005\u0002\u0000\u0000^_\u0003"+
		"\u0006\u0003\u0000_`\u0005\u0003\u0000\u0000`d\u0001\u0000\u0000\u0000"+
		"ab\u0005\u0015\u0000\u0000bd\u0003\u0006\u0003\u0001cG\u0001\u0000\u0000"+
		"\u0000cI\u0001\u0000\u0000\u0000cM\u0001\u0000\u0000\u0000cQ\u0001\u0000"+
		"\u0000\u0000cU\u0001\u0000\u0000\u0000cY\u0001\u0000\u0000\u0000c]\u0001"+
		"\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000dm\u0001\u0000\u0000\u0000"+
		"ef\n\u0003\u0000\u0000fg\u0005\u0013\u0000\u0000gl\u0003\u0006\u0003\u0004"+
		"hi\n\u0002\u0000\u0000ij\u0005\u0014\u0000\u0000jl\u0003\u0006\u0003\u0003"+
		"ke\u0001\u0000\u0000\u0000kh\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000"+
		"\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u0007\u0001"+
		"\u0000\u0000\u0000om\u0001\u0000\u0000\u0000pq\u0005\u0017\u0000\u0000"+
		"q\t\u0001\u0000\u0000\u0000rs\u0005\u0016\u0000\u0000s\u000b\u0001\u0000"+
		"\u0000\u0000tu\u0005\u0016\u0000\u0000u\r\u0001\u0000\u0000\u0000vw\u0005"+
		"\u0017\u0000\u0000w\u000f\u0001\u0000\u0000\u0000\u0007\u001e2;Eckm";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}