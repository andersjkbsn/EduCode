// Generated from C:/Users/User/Desktop/EduCode-P4/src\EduCode.g4 by ANTLR 4.6
package com.educode.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EduCodeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, TRUE=42, FALSE=43, ADDOP=44, MULTOP=45, 
		ANDOP=46, OROP=47, ULOP=48, RELOP=49, EQUALOP=50, NEWLINE=51, NUMLIT=52, 
		STRLIT=53, USTRLIT=54, IDENT=55, LPAREN=56, RPAREN=57, WHITESPACE=58, 
		LINECOMMENT=59;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"TRUE", "FALSE", "ADDOP", "MULTOP", "ANDOP", "OROP", "ULOP", "RELOP", 
		"EQUALOP", "NEWLINE", "LowerChar", "UpperChar", "Digit", "NewLine", "USym", 
		"NUMLIT", "STRLIT", "USTRLIT", "IDENT", "LPAREN", "RPAREN", "WHITESPACE", 
		"LINECOMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'program'", "'end program'", "'on event'", "'call'", "'method'", 
		"'returns'", "'end method'", "'.'", "','", "'return'", "'repeat while'", 
		"'end repeat'", "'if'", "'then'", "'else if'", "'else'", "'end if'", "'foreach'", 
		"'in'", "'end foreach'", "'='", "'new'", "'robotDeath'", "'robotAttacked'", 
		"'entityDeath'", "'chatMessage'", "'stringMessageReceived'", "'entityMessageReceived'", 
		"'number'", "'bool'", "'Coordinates'", "'string'", "'Collection'", "'<'", 
		"'>'", "'Block'", "'Entity'", "'Item'", "'Texture'", "'['", "']'", "'true'", 
		"'false'", null, null, "'and'", "'or'", "'not'", null, null, null, null, 
		null, null, null, "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "TRUE", "FALSE", "ADDOP", "MULTOP", 
		"ANDOP", "OROP", "ULOP", "RELOP", "EQUALOP", "NEWLINE", "NUMLIT", "STRLIT", 
		"USTRLIT", "IDENT", "LPAREN", "RPAREN", "WHITESPACE", "LINECOMMENT"
	};
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


	public EduCodeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EduCode.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2=\u0287\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 "+
		"\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-"+
		"\3-\3.\3.\3.\3.\3.\3.\3.\5.\u01d9\n.\3/\3/\3/\3/\3\60\3\60\3\60\3\61\3"+
		"\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0224\n\62\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\5\63\u0236\n\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3"+
		":\5:\u0245\n:\3:\6:\u0248\n:\r:\16:\u0249\3:\3:\7:\u024e\n:\f:\16:\u0251"+
		"\13:\5:\u0253\n:\3;\3;\3;\3<\3<\3<\3<\3<\5<\u025d\n<\7<\u025f\n<\f<\16"+
		"<\u0262\13<\3=\3=\3=\5=\u0267\n=\3=\3=\3=\3=\7=\u026d\n=\f=\16=\u0270"+
		"\13=\3>\3>\3?\3?\3@\6@\u0277\n@\r@\16@\u0278\3@\3@\3A\3A\3A\3A\7A\u0281"+
		"\nA\fA\16A\u0284\13A\3A\3A\2\2B\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\2k\2m\2o\2q\2s\66u\67w8y9{:};\177<\u0081=\3\2\n"+
		"\4\2--//\4\2,,\61\61\3\2c|\3\2C\\\3\2\62;\6\2\f\f\17\17$$^^\5\2\13\13"+
		"\16\17\"\"\4\2\f\f\17\17\u0295\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\3\u0083\3\2\2\2\5\u008b\3\2\2\2\7\u0097\3\2\2"+
		"\2\t\u00a0\3\2\2\2\13\u00a5\3\2\2\2\r\u00ac\3\2\2\2\17\u00b4\3\2\2\2\21"+
		"\u00bf\3\2\2\2\23\u00c1\3\2\2\2\25\u00c3\3\2\2\2\27\u00ca\3\2\2\2\31\u00d7"+
		"\3\2\2\2\33\u00e2\3\2\2\2\35\u00e5\3\2\2\2\37\u00ea\3\2\2\2!\u00f2\3\2"+
		"\2\2#\u00f7\3\2\2\2%\u00fe\3\2\2\2\'\u0106\3\2\2\2)\u0109\3\2\2\2+\u0115"+
		"\3\2\2\2-\u0117\3\2\2\2/\u011b\3\2\2\2\61\u0126\3\2\2\2\63\u0134\3\2\2"+
		"\2\65\u0140\3\2\2\2\67\u014c\3\2\2\29\u0162\3\2\2\2;\u0178\3\2\2\2=\u017f"+
		"\3\2\2\2?\u0184\3\2\2\2A\u0190\3\2\2\2C\u0197\3\2\2\2E\u01a2\3\2\2\2G"+
		"\u01a4\3\2\2\2I\u01a6\3\2\2\2K\u01ac\3\2\2\2M\u01b3\3\2\2\2O\u01b8\3\2"+
		"\2\2Q\u01c0\3\2\2\2S\u01c2\3\2\2\2U\u01c4\3\2\2\2W\u01c9\3\2\2\2Y\u01cf"+
		"\3\2\2\2[\u01d8\3\2\2\2]\u01da\3\2\2\2_\u01de\3\2\2\2a\u01e1\3\2\2\2c"+
		"\u0223\3\2\2\2e\u0235\3\2\2\2g\u0237\3\2\2\2i\u0239\3\2\2\2k\u023b\3\2"+
		"\2\2m\u023d\3\2\2\2o\u023f\3\2\2\2q\u0241\3\2\2\2s\u0244\3\2\2\2u\u0254"+
		"\3\2\2\2w\u0257\3\2\2\2y\u0266\3\2\2\2{\u0271\3\2\2\2}\u0273\3\2\2\2\177"+
		"\u0276\3\2\2\2\u0081\u027c\3\2\2\2\u0083\u0084\7r\2\2\u0084\u0085\7t\2"+
		"\2\u0085\u0086\7q\2\2\u0086\u0087\7i\2\2\u0087\u0088\7t\2\2\u0088\u0089"+
		"\7c\2\2\u0089\u008a\7o\2\2\u008a\4\3\2\2\2\u008b\u008c\7g\2\2\u008c\u008d"+
		"\7p\2\2\u008d\u008e\7f\2\2\u008e\u008f\7\"\2\2\u008f\u0090\7r\2\2\u0090"+
		"\u0091\7t\2\2\u0091\u0092\7q\2\2\u0092\u0093\7i\2\2\u0093\u0094\7t\2\2"+
		"\u0094\u0095\7c\2\2\u0095\u0096\7o\2\2\u0096\6\3\2\2\2\u0097\u0098\7q"+
		"\2\2\u0098\u0099\7p\2\2\u0099\u009a\7\"\2\2\u009a\u009b\7g\2\2\u009b\u009c"+
		"\7x\2\2\u009c\u009d\7g\2\2\u009d\u009e\7p\2\2\u009e\u009f\7v\2\2\u009f"+
		"\b\3\2\2\2\u00a0\u00a1\7e\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a3\7n\2\2\u00a3"+
		"\u00a4\7n\2\2\u00a4\n\3\2\2\2\u00a5\u00a6\7o\2\2\u00a6\u00a7\7g\2\2\u00a7"+
		"\u00a8\7v\2\2\u00a8\u00a9\7j\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7f\2\2"+
		"\u00ab\f\3\2\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7v"+
		"\2\2\u00af\u00b0\7w\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3"+
		"\7u\2\2\u00b3\16\3\2\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7p\2\2\u00b6\u00b7"+
		"\7f\2\2\u00b7\u00b8\7\"\2\2\u00b8\u00b9\7o\2\2\u00b9\u00ba\7g\2\2\u00ba"+
		"\u00bb\7v\2\2\u00bb\u00bc\7j\2\2\u00bc\u00bd\7q\2\2\u00bd\u00be\7f\2\2"+
		"\u00be\20\3\2\2\2\u00bf\u00c0\7\60\2\2\u00c0\22\3\2\2\2\u00c1\u00c2\7"+
		".\2\2\u00c2\24\3\2\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6"+
		"\7v\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7p\2\2\u00c9"+
		"\26\3\2\2\2\u00ca\u00cb\7t\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7r\2\2\u00cd"+
		"\u00ce\7g\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7\"\2"+
		"\2\u00d1\u00d2\7y\2\2\u00d2\u00d3\7j\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5"+
		"\7n\2\2\u00d5\u00d6\7g\2\2\u00d6\30\3\2\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9"+
		"\7p\2\2\u00d9\u00da\7f\2\2\u00da\u00db\7\"\2\2\u00db\u00dc\7t\2\2\u00dc"+
		"\u00dd\7g\2\2\u00dd\u00de\7r\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7c\2\2"+
		"\u00e0\u00e1\7v\2\2\u00e1\32\3\2\2\2\u00e2\u00e3\7k\2\2\u00e3\u00e4\7"+
		"h\2\2\u00e4\34\3\2\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7j\2\2\u00e7\u00e8"+
		"\7g\2\2\u00e8\u00e9\7p\2\2\u00e9\36\3\2\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec"+
		"\7n\2\2\u00ec\u00ed\7u\2\2\u00ed\u00ee\7g\2\2\u00ee\u00ef\7\"\2\2\u00ef"+
		"\u00f0\7k\2\2\u00f0\u00f1\7h\2\2\u00f1 \3\2\2\2\u00f2\u00f3\7g\2\2\u00f3"+
		"\u00f4\7n\2\2\u00f4\u00f5\7u\2\2\u00f5\u00f6\7g\2\2\u00f6\"\3\2\2\2\u00f7"+
		"\u00f8\7g\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7f\2\2\u00fa\u00fb\7\"\2"+
		"\2\u00fb\u00fc\7k\2\2\u00fc\u00fd\7h\2\2\u00fd$\3\2\2\2\u00fe\u00ff\7"+
		"h\2\2\u00ff\u0100\7q\2\2\u0100\u0101\7t\2\2\u0101\u0102\7g\2\2\u0102\u0103"+
		"\7c\2\2\u0103\u0104\7e\2\2\u0104\u0105\7j\2\2\u0105&\3\2\2\2\u0106\u0107"+
		"\7k\2\2\u0107\u0108\7p\2\2\u0108(\3\2\2\2\u0109\u010a\7g\2\2\u010a\u010b"+
		"\7p\2\2\u010b\u010c\7f\2\2\u010c\u010d\7\"\2\2\u010d\u010e\7h\2\2\u010e"+
		"\u010f\7q\2\2\u010f\u0110\7t\2\2\u0110\u0111\7g\2\2\u0111\u0112\7c\2\2"+
		"\u0112\u0113\7e\2\2\u0113\u0114\7j\2\2\u0114*\3\2\2\2\u0115\u0116\7?\2"+
		"\2\u0116,\3\2\2\2\u0117\u0118\7p\2\2\u0118\u0119\7g\2\2\u0119\u011a\7"+
		"y\2\2\u011a.\3\2\2\2\u011b\u011c\7t\2\2\u011c\u011d\7q\2\2\u011d\u011e"+
		"\7d\2\2\u011e\u011f\7q\2\2\u011f\u0120\7v\2\2\u0120\u0121\7F\2\2\u0121"+
		"\u0122\7g\2\2\u0122\u0123\7c\2\2\u0123\u0124\7v\2\2\u0124\u0125\7j\2\2"+
		"\u0125\60\3\2\2\2\u0126\u0127\7t\2\2\u0127\u0128\7q\2\2\u0128\u0129\7"+
		"d\2\2\u0129\u012a\7q\2\2\u012a\u012b\7v\2\2\u012b\u012c\7C\2\2\u012c\u012d"+
		"\7v\2\2\u012d\u012e\7v\2\2\u012e\u012f\7c\2\2\u012f\u0130\7e\2\2\u0130"+
		"\u0131\7m\2\2\u0131\u0132\7g\2\2\u0132\u0133\7f\2\2\u0133\62\3\2\2\2\u0134"+
		"\u0135\7g\2\2\u0135\u0136\7p\2\2\u0136\u0137\7v\2\2\u0137\u0138\7k\2\2"+
		"\u0138\u0139\7v\2\2\u0139\u013a\7{\2\2\u013a\u013b\7F\2\2\u013b\u013c"+
		"\7g\2\2\u013c\u013d\7c\2\2\u013d\u013e\7v\2\2\u013e\u013f\7j\2\2\u013f"+
		"\64\3\2\2\2\u0140\u0141\7e\2\2\u0141\u0142\7j\2\2\u0142\u0143\7c\2\2\u0143"+
		"\u0144\7v\2\2\u0144\u0145\7O\2\2\u0145\u0146\7g\2\2\u0146\u0147\7u\2\2"+
		"\u0147\u0148\7u\2\2\u0148\u0149\7c\2\2\u0149\u014a\7i\2\2\u014a\u014b"+
		"\7g\2\2\u014b\66\3\2\2\2\u014c\u014d\7u\2\2\u014d\u014e\7v\2\2\u014e\u014f"+
		"\7t\2\2\u014f\u0150\7k\2\2\u0150\u0151\7p\2\2\u0151\u0152\7i\2\2\u0152"+
		"\u0153\7O\2\2\u0153\u0154\7g\2\2\u0154\u0155\7u\2\2\u0155\u0156\7u\2\2"+
		"\u0156\u0157\7c\2\2\u0157\u0158\7i\2\2\u0158\u0159\7g\2\2\u0159\u015a"+
		"\7T\2\2\u015a\u015b\7g\2\2\u015b\u015c\7e\2\2\u015c\u015d\7g\2\2\u015d"+
		"\u015e\7k\2\2\u015e\u015f\7x\2\2\u015f\u0160\7g\2\2\u0160\u0161\7f\2\2"+
		"\u01618\3\2\2\2\u0162\u0163\7g\2\2\u0163\u0164\7p\2\2\u0164\u0165\7v\2"+
		"\2\u0165\u0166\7k\2\2\u0166\u0167\7v\2\2\u0167\u0168\7{\2\2\u0168\u0169"+
		"\7O\2\2\u0169\u016a\7g\2\2\u016a\u016b\7u\2\2\u016b\u016c\7u\2\2\u016c"+
		"\u016d\7c\2\2\u016d\u016e\7i\2\2\u016e\u016f\7g\2\2\u016f\u0170\7T\2\2"+
		"\u0170\u0171\7g\2\2\u0171\u0172\7e\2\2\u0172\u0173\7g\2\2\u0173\u0174"+
		"\7k\2\2\u0174\u0175\7x\2\2\u0175\u0176\7g\2\2\u0176\u0177\7f\2\2\u0177"+
		":\3\2\2\2\u0178\u0179\7p\2\2\u0179\u017a\7w\2\2\u017a\u017b\7o\2\2\u017b"+
		"\u017c\7d\2\2\u017c\u017d\7g\2\2\u017d\u017e\7t\2\2\u017e<\3\2\2\2\u017f"+
		"\u0180\7d\2\2\u0180\u0181\7q\2\2\u0181\u0182\7q\2\2\u0182\u0183\7n\2\2"+
		"\u0183>\3\2\2\2\u0184\u0185\7E\2\2\u0185\u0186\7q\2\2\u0186\u0187\7q\2"+
		"\2\u0187\u0188\7t\2\2\u0188\u0189\7f\2\2\u0189\u018a\7k\2\2\u018a\u018b"+
		"\7p\2\2\u018b\u018c\7c\2\2\u018c\u018d\7v\2\2\u018d\u018e\7g\2\2\u018e"+
		"\u018f\7u\2\2\u018f@\3\2\2\2\u0190\u0191\7u\2\2\u0191\u0192\7v\2\2\u0192"+
		"\u0193\7t\2\2\u0193\u0194\7k\2\2\u0194\u0195\7p\2\2\u0195\u0196\7i\2\2"+
		"\u0196B\3\2\2\2\u0197\u0198\7E\2\2\u0198\u0199\7q\2\2\u0199\u019a\7n\2"+
		"\2\u019a\u019b\7n\2\2\u019b\u019c\7g\2\2\u019c\u019d\7e\2\2\u019d\u019e"+
		"\7v\2\2\u019e\u019f\7k\2\2\u019f\u01a0\7q\2\2\u01a0\u01a1\7p\2\2\u01a1"+
		"D\3\2\2\2\u01a2\u01a3\7>\2\2\u01a3F\3\2\2\2\u01a4\u01a5\7@\2\2\u01a5H"+
		"\3\2\2\2\u01a6\u01a7\7D\2\2\u01a7\u01a8\7n\2\2\u01a8\u01a9\7q\2\2\u01a9"+
		"\u01aa\7e\2\2\u01aa\u01ab\7m\2\2\u01abJ\3\2\2\2\u01ac\u01ad\7G\2\2\u01ad"+
		"\u01ae\7p\2\2\u01ae\u01af\7v\2\2\u01af\u01b0\7k\2\2\u01b0\u01b1\7v\2\2"+
		"\u01b1\u01b2\7{\2\2\u01b2L\3\2\2\2\u01b3\u01b4\7K\2\2\u01b4\u01b5\7v\2"+
		"\2\u01b5\u01b6\7g\2\2\u01b6\u01b7\7o\2\2\u01b7N\3\2\2\2\u01b8\u01b9\7"+
		"V\2\2\u01b9\u01ba\7g\2\2\u01ba\u01bb\7z\2\2\u01bb\u01bc\7v\2\2\u01bc\u01bd"+
		"\7w\2\2\u01bd\u01be\7t\2\2\u01be\u01bf\7g\2\2\u01bfP\3\2\2\2\u01c0\u01c1"+
		"\7]\2\2\u01c1R\3\2\2\2\u01c2\u01c3\7_\2\2\u01c3T\3\2\2\2\u01c4\u01c5\7"+
		"v\2\2\u01c5\u01c6\7t\2\2\u01c6\u01c7\7w\2\2\u01c7\u01c8\7g\2\2\u01c8V"+
		"\3\2\2\2\u01c9\u01ca\7h\2\2\u01ca\u01cb\7c\2\2\u01cb\u01cc\7n\2\2\u01cc"+
		"\u01cd\7u\2\2\u01cd\u01ce\7g\2\2\u01ceX\3\2\2\2\u01cf\u01d0\t\2\2\2\u01d0"+
		"Z\3\2\2\2\u01d1\u01d9\t\3\2\2\u01d2\u01d3\7o\2\2\u01d3\u01d4\7q\2\2\u01d4"+
		"\u01d5\7f\2\2\u01d5\u01d6\7w\2\2\u01d6\u01d7\7n\2\2\u01d7\u01d9\7q\2\2"+
		"\u01d8\u01d1\3\2\2\2\u01d8\u01d2\3\2\2\2\u01d9\\\3\2\2\2\u01da\u01db\7"+
		"c\2\2\u01db\u01dc\7p\2\2\u01dc\u01dd\7f\2\2\u01dd^\3\2\2\2\u01de\u01df"+
		"\7q\2\2\u01df\u01e0\7t\2\2\u01e0`\3\2\2\2\u01e1\u01e2\7p\2\2\u01e2\u01e3"+
		"\7q\2\2\u01e3\u01e4\7v\2\2\u01e4b\3\2\2\2\u01e5\u01e6\7i\2\2\u01e6\u01e7"+
		"\7t\2\2\u01e7\u01e8\7g\2\2\u01e8\u01e9\7c\2\2\u01e9\u01ea\7v\2\2\u01ea"+
		"\u01eb\7g\2\2\u01eb\u01ec\7t\2\2\u01ec\u01ed\7\"\2\2\u01ed\u01ee\7v\2"+
		"\2\u01ee\u01ef\7j\2\2\u01ef\u01f0\7c\2\2\u01f0\u0224\7p\2\2\u01f1\u01f2"+
		"\7n\2\2\u01f2\u01f3\7g\2\2\u01f3\u01f4\7u\2\2\u01f4\u01f5\7u\2\2\u01f5"+
		"\u01f6\7\"\2\2\u01f6\u01f7\7v\2\2\u01f7\u01f8\7j\2\2\u01f8\u01f9\7c\2"+
		"\2\u01f9\u0224\7p\2\2\u01fa\u01fb\7i\2\2\u01fb\u01fc\7t\2\2\u01fc\u01fd"+
		"\7g\2\2\u01fd\u01fe\7c\2\2\u01fe\u01ff\7v\2\2\u01ff\u0200\7g\2\2\u0200"+
		"\u0201\7t\2\2\u0201\u0202\7\"\2\2\u0202\u0203\7v\2\2\u0203\u0204\7j\2"+
		"\2\u0204\u0205\7c\2\2\u0205\u0206\7p\2\2\u0206\u0207\7\"\2\2\u0207\u0208"+
		"\7q\2\2\u0208\u0209\7t\2\2\u0209\u020a\7\"\2\2\u020a\u020b\7g\2\2\u020b"+
		"\u020c\7s\2\2\u020c\u020d\7w\2\2\u020d\u020e\7c\2\2\u020e\u020f\7n\2\2"+
		"\u020f\u0224\7u\2\2\u0210\u0211\7n\2\2\u0211\u0212\7g\2\2\u0212\u0213"+
		"\7u\2\2\u0213\u0214\7u\2\2\u0214\u0215\7\"\2\2\u0215\u0216\7v\2\2\u0216"+
		"\u0217\7j\2\2\u0217\u0218\7c\2\2\u0218\u0219\7p\2\2\u0219\u021a\7\"\2"+
		"\2\u021a\u021b\7q\2\2\u021b\u021c\7t\2\2\u021c\u021d\7\"\2\2\u021d\u021e"+
		"\7g\2\2\u021e\u021f\7s\2\2\u021f\u0220\7w\2\2\u0220\u0221\7c\2\2\u0221"+
		"\u0222\7n\2\2\u0222\u0224\7u\2\2\u0223\u01e5\3\2\2\2\u0223\u01f1\3\2\2"+
		"\2\u0223\u01fa\3\2\2\2\u0223\u0210\3\2\2\2\u0224d\3\2\2\2\u0225\u0226"+
		"\7g\2\2\u0226\u0227\7s\2\2\u0227\u0228\7w\2\2\u0228\u0229\7c\2\2\u0229"+
		"\u022a\7n\2\2\u022a\u0236\7u\2\2\u022b\u022c\7p\2\2\u022c\u022d\7q\2\2"+
		"\u022d\u022e\7v\2\2\u022e\u022f\7\"\2\2\u022f\u0230\7g\2\2\u0230\u0231"+
		"\7s\2\2\u0231\u0232\7w\2\2\u0232\u0233\7c\2\2\u0233\u0234\7n\2\2\u0234"+
		"\u0236\7u\2\2\u0235\u0225\3\2\2\2\u0235\u022b\3\2\2\2\u0236f\3\2\2\2\u0237"+
		"\u0238\5o8\2\u0238h\3\2\2\2\u0239\u023a\t\4\2\2\u023aj\3\2\2\2\u023b\u023c"+
		"\t\5\2\2\u023cl\3\2\2\2\u023d\u023e\t\6\2\2\u023en\3\2\2\2\u023f\u0240"+
		"\7\f\2\2\u0240p\3\2\2\2\u0241\u0242\7a\2\2\u0242r\3\2\2\2\u0243\u0245"+
		"\7/\2\2\u0244\u0243\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0247\3\2\2\2\u0246"+
		"\u0248\5m\67\2\u0247\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u0247\3\2"+
		"\2\2\u0249\u024a\3\2\2\2\u024a\u0252\3\2\2\2\u024b\u024f\7\60\2\2\u024c"+
		"\u024e\5m\67\2\u024d\u024c\3\2\2\2\u024e\u0251\3\2\2\2\u024f\u024d\3\2"+
		"\2\2\u024f\u0250\3\2\2\2\u0250\u0253\3\2\2\2\u0251\u024f\3\2\2\2\u0252"+
		"\u024b\3\2\2\2\u0252\u0253\3\2\2\2\u0253t\3\2\2\2\u0254\u0255\5w<\2\u0255"+
		"\u0256\7$\2\2\u0256v\3\2\2\2\u0257\u0260\7$\2\2\u0258\u025f\n\7\2\2\u0259"+
		"\u025c\7^\2\2\u025a\u025d\13\2\2\2\u025b\u025d\7\2\2\3\u025c\u025a\3\2"+
		"\2\2\u025c\u025b\3\2\2\2\u025d\u025f\3\2\2\2\u025e\u0258\3\2\2\2\u025e"+
		"\u0259\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2"+
		"\2\2\u0261x\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0267\5i\65\2\u0264\u0267"+
		"\5k\66\2\u0265\u0267\5q9\2\u0266\u0263\3\2\2\2\u0266\u0264\3\2\2\2\u0266"+
		"\u0265\3\2\2\2\u0267\u026e\3\2\2\2\u0268\u026d\5i\65\2\u0269\u026d\5k"+
		"\66\2\u026a\u026d\5m\67\2\u026b\u026d\5q9\2\u026c\u0268\3\2\2\2\u026c"+
		"\u0269\3\2\2\2\u026c\u026a\3\2\2\2\u026c\u026b\3\2\2\2\u026d\u0270\3\2"+
		"\2\2\u026e\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026fz\3\2\2\2\u0270\u026e"+
		"\3\2\2\2\u0271\u0272\7*\2\2\u0272|\3\2\2\2\u0273\u0274\7+\2\2\u0274~\3"+
		"\2\2\2\u0275\u0277\t\b\2\2\u0276\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278"+
		"\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027b\b@"+
		"\2\2\u027b\u0080\3\2\2\2\u027c\u027d\7\61\2\2\u027d\u027e\7\61\2\2\u027e"+
		"\u0282\3\2\2\2\u027f\u0281\n\t\2\2\u0280\u027f\3\2\2\2\u0281\u0284\3\2"+
		"\2\2\u0282\u0280\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0285\3\2\2\2\u0284"+
		"\u0282\3\2\2\2\u0285\u0286\bA\2\2\u0286\u0082\3\2\2\2\22\2\u01d8\u0223"+
		"\u0235\u0244\u0249\u024f\u0252\u025c\u025e\u0260\u0266\u026c\u026e\u0278"+
		"\u0282\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}