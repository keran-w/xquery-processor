// Generated from /Users/keranwang/Desktop/Winter 24/CSE 232B/project/xquery-processor/src/main/java/edu/ucsd/xmlqueryprocessor/antlr4/xpath/XPathGrammar.g4 by ANTLR 4.13.1
package edu.ucsd.xmlqueryprocessor.antlr4.xpath;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XPathGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, NAME=22, STRING=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "NAME", "STRING", "WS"
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


	public XPathGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XPathGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0018\u0089\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0005\u0015"+
		"q\b\u0015\n\u0015\f\u0015t\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016|\b\u0016\n\u0016\f\u0016"+
		"\u007f\t\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0004\u0017\u0084\b"+
		"\u0017\u000b\u0017\f\u0017\u0085\u0001\u0017\u0001\u0017\u0000\u0000\u0018"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u0018\u0001\u0000\u0004\u0003\u0000AZ__az\u0004\u000009AZ__az\u0002"+
		"\u0000\"\"\\\\\u0003\u0000\t\n\r\r  \u008d\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00011"+
		"\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000\u0000\u00057\u0001\u0000"+
		"\u0000\u0000\u00079\u0001\u0000\u0000\u0000\t;\u0001\u0000\u0000\u0000"+
		"\u000b>\u0001\u0000\u0000\u0000\r@\u0001\u0000\u0000\u0000\u000fB\u0001"+
		"\u0000\u0000\u0000\u0011D\u0001\u0000\u0000\u0000\u0013F\u0001\u0000\u0000"+
		"\u0000\u0015H\u0001\u0000\u0000\u0000\u0017K\u0001\u0000\u0000\u0000\u0019"+
		"R\u0001\u0000\u0000\u0000\u001bT\u0001\u0000\u0000\u0000\u001dV\u0001"+
		"\u0000\u0000\u0000\u001fY\u0001\u0000\u0000\u0000!\\\u0001\u0000\u0000"+
		"\u0000#_\u0001\u0000\u0000\u0000%c\u0001\u0000\u0000\u0000\'g\u0001\u0000"+
		"\u0000\u0000)j\u0001\u0000\u0000\u0000+n\u0001\u0000\u0000\u0000-u\u0001"+
		"\u0000\u0000\u0000/\u0083\u0001\u0000\u0000\u000012\u0005d\u0000\u0000"+
		"23\u0005o\u0000\u000034\u0005c\u0000\u00004\u0002\u0001\u0000\u0000\u0000"+
		"56\u0005(\u0000\u00006\u0004\u0001\u0000\u0000\u000078\u0005)\u0000\u0000"+
		"8\u0006\u0001\u0000\u0000\u00009:\u0005/\u0000\u0000:\b\u0001\u0000\u0000"+
		"\u0000;<\u0005/\u0000\u0000<=\u0005/\u0000\u0000=\n\u0001\u0000\u0000"+
		"\u0000>?\u0005[\u0000\u0000?\f\u0001\u0000\u0000\u0000@A\u0005]\u0000"+
		"\u0000A\u000e\u0001\u0000\u0000\u0000BC\u0005,\u0000\u0000C\u0010\u0001"+
		"\u0000\u0000\u0000DE\u0005*\u0000\u0000E\u0012\u0001\u0000\u0000\u0000"+
		"FG\u0005.\u0000\u0000G\u0014\u0001\u0000\u0000\u0000HI\u0005.\u0000\u0000"+
		"IJ\u0005.\u0000\u0000J\u0016\u0001\u0000\u0000\u0000KL\u0005t\u0000\u0000"+
		"LM\u0005e\u0000\u0000MN\u0005x\u0000\u0000NO\u0005t\u0000\u0000OP\u0005"+
		"(\u0000\u0000PQ\u0005)\u0000\u0000Q\u0018\u0001\u0000\u0000\u0000RS\u0005"+
		"@\u0000\u0000S\u001a\u0001\u0000\u0000\u0000TU\u0005=\u0000\u0000U\u001c"+
		"\u0001\u0000\u0000\u0000VW\u0005e\u0000\u0000WX\u0005q\u0000\u0000X\u001e"+
		"\u0001\u0000\u0000\u0000YZ\u0005=\u0000\u0000Z[\u0005=\u0000\u0000[ \u0001"+
		"\u0000\u0000\u0000\\]\u0005i\u0000\u0000]^\u0005s\u0000\u0000^\"\u0001"+
		"\u0000\u0000\u0000_`\u0005 \u0000\u0000`a\u0005=\u0000\u0000ab\u0005 "+
		"\u0000\u0000b$\u0001\u0000\u0000\u0000cd\u0005a\u0000\u0000de\u0005n\u0000"+
		"\u0000ef\u0005d\u0000\u0000f&\u0001\u0000\u0000\u0000gh\u0005o\u0000\u0000"+
		"hi\u0005r\u0000\u0000i(\u0001\u0000\u0000\u0000jk\u0005n\u0000\u0000k"+
		"l\u0005o\u0000\u0000lm\u0005t\u0000\u0000m*\u0001\u0000\u0000\u0000nr"+
		"\u0007\u0000\u0000\u0000oq\u0007\u0001\u0000\u0000po\u0001\u0000\u0000"+
		"\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000"+
		"\u0000\u0000s,\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000u}\u0005"+
		"\"\u0000\u0000v|\b\u0002\u0000\u0000wx\u0005\\\u0000\u0000x|\u0005\\\u0000"+
		"\u0000yz\u0005\\\u0000\u0000z|\u0005\"\u0000\u0000{v\u0001\u0000\u0000"+
		"\u0000{w\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000|\u007f\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u0080\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0005\"\u0000\u0000\u0081.\u0001\u0000\u0000\u0000\u0082\u0084\u0007"+
		"\u0003\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001"+
		"\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0006"+
		"\u0017\u0000\u0000\u00880\u0001\u0000\u0000\u0000\u0005\u0000r{}\u0085"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}