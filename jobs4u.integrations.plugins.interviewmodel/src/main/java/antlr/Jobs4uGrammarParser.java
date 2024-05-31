// Generated from C:/Users/fabio/Downloads/antlr/Jobs4uGrammar.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Jobs4uGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, NEWLINE=21, WS=22, BOOLEAN=23, FORMAT_CONF_START=24, 
		FORMAT_CONF_END=25, SOLUTION_START=26, SOLUTION_END=27, FORMAT_START=28, 
		FORMAT_END=29, PERCENTAGE=30, SCALE=31, INTEGER=32, DECIMAL=33, DATE=34, 
		TIME=35, COMMA=36, DASH=37, QUOTE_STRING=38, STRING=39;
	public static final int
		RULE_start = 0, RULE_model = 1, RULE_question = 2, RULE_title = 3, RULE_answer = 4, 
		RULE_grade = 5, RULE_format = 6, RULE_boolean_answer = 7, RULE_short_text_answer = 8, 
		RULE_choice_single_answer = 9, RULE_choice_multiple_answer = 10, RULE_integer_answer = 11, 
		RULE_decimal_answer = 12, RULE_date_answer = 13, RULE_time_answer = 14, 
		RULE_integer_scale_answer = 15, RULE_format_conf_choice_single_answer = 16, 
		RULE_format_conf_choice_multiple_answer = 17, RULE_format_answer_choice_multiple_answer = 18, 
		RULE_format_answer_choice_multiple_answer_option = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "model", "question", "title", "answer", "grade", "format", "boolean_answer", 
			"short_text_answer", "choice_single_answer", "choice_multiple_answer", 
			"integer_answer", "decimal_answer", "date_answer", "time_answer", "integer_scale_answer", 
			"format_conf_choice_single_answer", "format_conf_choice_multiple_answer", 
			"format_answer_choice_multiple_answer", "format_answer_choice_multiple_answer_option"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<MODEL>'", "'</MODEL>'", "'<QUESTION>'", "'</QUESTION>'", "'<TITLE>'", 
			"'</TITLE>'", "'<ANSWER>'", "'</ANSWER>'", "'<GRADE>'", "'</GRADE>'", 
			"'BOOLEAN'", "'SHORT_TEXT'", "'CHOICE_SINGLE_ANSWER'", "'CHOICE_MULTIPLE_ANSWER'", 
			"'INTEGER'", "'DECIMAL'", "'DATE'", "'TIME'", "'INTEGER_SCALE'", "';'", 
			null, null, null, "'<FORMAT_CONF>'", "'</FORMAT_CONF>'", "'<SOLUTION>'", 
			"'</SOLUTION>'", "'<FORMAT>'", "'</FORMAT>'", null, null, null, null, 
			null, null, "','", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "NEWLINE", "WS", 
			"BOOLEAN", "FORMAT_CONF_START", "FORMAT_CONF_END", "SOLUTION_START", 
			"SOLUTION_END", "FORMAT_START", "FORMAT_END", "PERCENTAGE", "SCALE", 
			"INTEGER", "DECIMAL", "DATE", "TIME", "COMMA", "DASH", "QUOTE_STRING", 
			"STRING"
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
	public String getGrammarFileName() { return "Jobs4uGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Jobs4uGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ModelContext model() {
			return getRuleContext(ModelContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			model();
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
	public static class ModelContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Jobs4uGrammarParser.EOF, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__0);
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				question();
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(48);
			match(T__1);
			setState(49);
			match(EOF);
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
	public static class QuestionContext extends ParserRuleContext {
		public List<TitleContext> title() {
			return getRuleContexts(TitleContext.class);
		}
		public TitleContext title(int i) {
			return getRuleContext(TitleContext.class,i);
		}
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public List<GradeContext> grade() {
			return getRuleContexts(GradeContext.class);
		}
		public GradeContext grade(int i) {
			return getRuleContext(GradeContext.class,i);
		}
		public List<FormatContext> format() {
			return getRuleContexts(FormatContext.class);
		}
		public FormatContext format(int i) {
			return getRuleContext(FormatContext.class,i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__2);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268436128L) != 0)) {
				{
				setState(56);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(52);
					title();
					}
					break;
				case T__6:
					{
					setState(53);
					answer();
					}
					break;
				case T__8:
					{
					setState(54);
					grade();
					}
					break;
				case FORMAT_START:
					{
					setState(55);
					format();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(T__3);
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
	public static class TitleContext extends ParserRuleContext {
		public TerminalNode QUOTE_STRING() { return getToken(Jobs4uGrammarParser.QUOTE_STRING, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__4);
			setState(64);
			match(QUOTE_STRING);
			setState(65);
			match(T__5);
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
	public static class AnswerContext extends ParserRuleContext {
		public TerminalNode QUOTE_STRING() { return getToken(Jobs4uGrammarParser.QUOTE_STRING, 0); }
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__6);
			setState(68);
			match(QUOTE_STRING);
			setState(69);
			match(T__7);
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
	public static class GradeContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(Jobs4uGrammarParser.INTEGER, 0); }
		public GradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterGrade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitGrade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitGrade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GradeContext grade() throws RecognitionException {
		GradeContext _localctx = new GradeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_grade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__8);
			setState(72);
			match(INTEGER);
			setState(73);
			match(T__9);
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
	public static class FormatContext extends ParserRuleContext {
		public Boolean_answerContext boolean_answer() {
			return getRuleContext(Boolean_answerContext.class,0);
		}
		public Short_text_answerContext short_text_answer() {
			return getRuleContext(Short_text_answerContext.class,0);
		}
		public Choice_single_answerContext choice_single_answer() {
			return getRuleContext(Choice_single_answerContext.class,0);
		}
		public Choice_multiple_answerContext choice_multiple_answer() {
			return getRuleContext(Choice_multiple_answerContext.class,0);
		}
		public Integer_answerContext integer_answer() {
			return getRuleContext(Integer_answerContext.class,0);
		}
		public Decimal_answerContext decimal_answer() {
			return getRuleContext(Decimal_answerContext.class,0);
		}
		public Date_answerContext date_answer() {
			return getRuleContext(Date_answerContext.class,0);
		}
		public Time_answerContext time_answer() {
			return getRuleContext(Time_answerContext.class,0);
		}
		public Integer_scale_answerContext integer_scale_answer() {
			return getRuleContext(Integer_scale_answerContext.class,0);
		}
		public FormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_format; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormatContext format() throws RecognitionException {
		FormatContext _localctx = new FormatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_format);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				boolean_answer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				short_text_answer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				choice_single_answer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				choice_multiple_answer();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				integer_answer();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				decimal_answer();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(81);
				date_answer();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				time_answer();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(83);
				integer_scale_answer();
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
	public static class Boolean_answerContext extends ParserRuleContext {
		public TerminalNode FORMAT_START() { return getToken(Jobs4uGrammarParser.FORMAT_START, 0); }
		public TerminalNode FORMAT_END() { return getToken(Jobs4uGrammarParser.FORMAT_END, 0); }
		public TerminalNode SOLUTION_START() { return getToken(Jobs4uGrammarParser.SOLUTION_START, 0); }
		public TerminalNode BOOLEAN() { return getToken(Jobs4uGrammarParser.BOOLEAN, 0); }
		public TerminalNode SOLUTION_END() { return getToken(Jobs4uGrammarParser.SOLUTION_END, 0); }
		public Boolean_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterBoolean_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitBoolean_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitBoolean_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_answerContext boolean_answer() throws RecognitionException {
		Boolean_answerContext _localctx = new Boolean_answerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_boolean_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(FORMAT_START);
			setState(87);
			match(T__10);
			setState(88);
			match(FORMAT_END);
			setState(89);
			match(SOLUTION_START);
			setState(90);
			match(BOOLEAN);
			setState(91);
			match(SOLUTION_END);
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
	public static class Short_text_answerContext extends ParserRuleContext {
		public TerminalNode FORMAT_START() { return getToken(Jobs4uGrammarParser.FORMAT_START, 0); }
		public TerminalNode FORMAT_END() { return getToken(Jobs4uGrammarParser.FORMAT_END, 0); }
		public TerminalNode FORMAT_CONF_START() { return getToken(Jobs4uGrammarParser.FORMAT_CONF_START, 0); }
		public List<TerminalNode> QUOTE_STRING() { return getTokens(Jobs4uGrammarParser.QUOTE_STRING); }
		public TerminalNode QUOTE_STRING(int i) {
			return getToken(Jobs4uGrammarParser.QUOTE_STRING, i);
		}
		public TerminalNode FORMAT_CONF_END() { return getToken(Jobs4uGrammarParser.FORMAT_CONF_END, 0); }
		public TerminalNode SOLUTION_START() { return getToken(Jobs4uGrammarParser.SOLUTION_START, 0); }
		public TerminalNode SOLUTION_END() { return getToken(Jobs4uGrammarParser.SOLUTION_END, 0); }
		public Short_text_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_text_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterShort_text_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitShort_text_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitShort_text_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_text_answerContext short_text_answer() throws RecognitionException {
		Short_text_answerContext _localctx = new Short_text_answerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_short_text_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(FORMAT_START);
			setState(94);
			match(T__11);
			setState(95);
			match(FORMAT_END);
			setState(96);
			match(FORMAT_CONF_START);
			setState(97);
			match(QUOTE_STRING);
			setState(98);
			match(FORMAT_CONF_END);
			setState(99);
			match(SOLUTION_START);
			setState(100);
			match(QUOTE_STRING);
			setState(101);
			match(SOLUTION_END);
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
	public static class Choice_single_answerContext extends ParserRuleContext {
		public TerminalNode FORMAT_START() { return getToken(Jobs4uGrammarParser.FORMAT_START, 0); }
		public TerminalNode FORMAT_END() { return getToken(Jobs4uGrammarParser.FORMAT_END, 0); }
		public TerminalNode FORMAT_CONF_START() { return getToken(Jobs4uGrammarParser.FORMAT_CONF_START, 0); }
		public Format_conf_choice_single_answerContext format_conf_choice_single_answer() {
			return getRuleContext(Format_conf_choice_single_answerContext.class,0);
		}
		public TerminalNode FORMAT_CONF_END() { return getToken(Jobs4uGrammarParser.FORMAT_CONF_END, 0); }
		public TerminalNode SOLUTION_START() { return getToken(Jobs4uGrammarParser.SOLUTION_START, 0); }
		public TerminalNode QUOTE_STRING() { return getToken(Jobs4uGrammarParser.QUOTE_STRING, 0); }
		public TerminalNode SOLUTION_END() { return getToken(Jobs4uGrammarParser.SOLUTION_END, 0); }
		public Choice_single_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice_single_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterChoice_single_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitChoice_single_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitChoice_single_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Choice_single_answerContext choice_single_answer() throws RecognitionException {
		Choice_single_answerContext _localctx = new Choice_single_answerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_choice_single_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(FORMAT_START);
			setState(104);
			match(T__12);
			setState(105);
			match(FORMAT_END);
			setState(106);
			match(FORMAT_CONF_START);
			setState(107);
			format_conf_choice_single_answer();
			setState(108);
			match(FORMAT_CONF_END);
			setState(109);
			match(SOLUTION_START);
			setState(110);
			match(QUOTE_STRING);
			setState(111);
			match(SOLUTION_END);
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
	public static class Choice_multiple_answerContext extends ParserRuleContext {
		public TerminalNode FORMAT_START() { return getToken(Jobs4uGrammarParser.FORMAT_START, 0); }
		public TerminalNode FORMAT_END() { return getToken(Jobs4uGrammarParser.FORMAT_END, 0); }
		public TerminalNode FORMAT_CONF_START() { return getToken(Jobs4uGrammarParser.FORMAT_CONF_START, 0); }
		public Format_conf_choice_multiple_answerContext format_conf_choice_multiple_answer() {
			return getRuleContext(Format_conf_choice_multiple_answerContext.class,0);
		}
		public TerminalNode FORMAT_CONF_END() { return getToken(Jobs4uGrammarParser.FORMAT_CONF_END, 0); }
		public TerminalNode SOLUTION_START() { return getToken(Jobs4uGrammarParser.SOLUTION_START, 0); }
		public Format_answer_choice_multiple_answerContext format_answer_choice_multiple_answer() {
			return getRuleContext(Format_answer_choice_multiple_answerContext.class,0);
		}
		public TerminalNode SOLUTION_END() { return getToken(Jobs4uGrammarParser.SOLUTION_END, 0); }
		public Choice_multiple_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice_multiple_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterChoice_multiple_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitChoice_multiple_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitChoice_multiple_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Choice_multiple_answerContext choice_multiple_answer() throws RecognitionException {
		Choice_multiple_answerContext _localctx = new Choice_multiple_answerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_choice_multiple_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(FORMAT_START);
			setState(114);
			match(T__13);
			setState(115);
			match(FORMAT_END);
			setState(116);
			match(FORMAT_CONF_START);
			setState(117);
			format_conf_choice_multiple_answer();
			setState(118);
			match(FORMAT_CONF_END);
			setState(119);
			match(SOLUTION_START);
			setState(120);
			format_answer_choice_multiple_answer();
			setState(121);
			match(SOLUTION_END);
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
	public static class Integer_answerContext extends ParserRuleContext {
		public TerminalNode FORMAT_START() { return getToken(Jobs4uGrammarParser.FORMAT_START, 0); }
		public TerminalNode FORMAT_END() { return getToken(Jobs4uGrammarParser.FORMAT_END, 0); }
		public TerminalNode SOLUTION_START() { return getToken(Jobs4uGrammarParser.SOLUTION_START, 0); }
		public TerminalNode INTEGER() { return getToken(Jobs4uGrammarParser.INTEGER, 0); }
		public TerminalNode SOLUTION_END() { return getToken(Jobs4uGrammarParser.SOLUTION_END, 0); }
		public Integer_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterInteger_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitInteger_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitInteger_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integer_answerContext integer_answer() throws RecognitionException {
		Integer_answerContext _localctx = new Integer_answerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_integer_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(FORMAT_START);
			setState(124);
			match(T__14);
			setState(125);
			match(FORMAT_END);
			setState(126);
			match(SOLUTION_START);
			setState(127);
			match(INTEGER);
			setState(128);
			match(SOLUTION_END);
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
	public static class Decimal_answerContext extends ParserRuleContext {
		public TerminalNode FORMAT_START() { return getToken(Jobs4uGrammarParser.FORMAT_START, 0); }
		public TerminalNode FORMAT_END() { return getToken(Jobs4uGrammarParser.FORMAT_END, 0); }
		public TerminalNode SOLUTION_START() { return getToken(Jobs4uGrammarParser.SOLUTION_START, 0); }
		public TerminalNode DECIMAL() { return getToken(Jobs4uGrammarParser.DECIMAL, 0); }
		public TerminalNode SOLUTION_END() { return getToken(Jobs4uGrammarParser.SOLUTION_END, 0); }
		public Decimal_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterDecimal_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitDecimal_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitDecimal_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decimal_answerContext decimal_answer() throws RecognitionException {
		Decimal_answerContext _localctx = new Decimal_answerContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_decimal_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(FORMAT_START);
			setState(131);
			match(T__15);
			setState(132);
			match(FORMAT_END);
			setState(133);
			match(SOLUTION_START);
			setState(134);
			match(DECIMAL);
			setState(135);
			match(SOLUTION_END);
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
	public static class Date_answerContext extends ParserRuleContext {
		public TerminalNode FORMAT_START() { return getToken(Jobs4uGrammarParser.FORMAT_START, 0); }
		public TerminalNode FORMAT_END() { return getToken(Jobs4uGrammarParser.FORMAT_END, 0); }
		public TerminalNode SOLUTION_START() { return getToken(Jobs4uGrammarParser.SOLUTION_START, 0); }
		public TerminalNode DATE() { return getToken(Jobs4uGrammarParser.DATE, 0); }
		public TerminalNode SOLUTION_END() { return getToken(Jobs4uGrammarParser.SOLUTION_END, 0); }
		public Date_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterDate_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitDate_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitDate_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_answerContext date_answer() throws RecognitionException {
		Date_answerContext _localctx = new Date_answerContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_date_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(FORMAT_START);
			setState(138);
			match(T__16);
			setState(139);
			match(FORMAT_END);
			setState(140);
			match(SOLUTION_START);
			setState(141);
			match(DATE);
			setState(142);
			match(SOLUTION_END);
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
	public static class Time_answerContext extends ParserRuleContext {
		public TerminalNode FORMAT_START() { return getToken(Jobs4uGrammarParser.FORMAT_START, 0); }
		public TerminalNode FORMAT_END() { return getToken(Jobs4uGrammarParser.FORMAT_END, 0); }
		public TerminalNode SOLUTION_START() { return getToken(Jobs4uGrammarParser.SOLUTION_START, 0); }
		public TerminalNode TIME() { return getToken(Jobs4uGrammarParser.TIME, 0); }
		public TerminalNode SOLUTION_END() { return getToken(Jobs4uGrammarParser.SOLUTION_END, 0); }
		public Time_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterTime_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitTime_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitTime_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_answerContext time_answer() throws RecognitionException {
		Time_answerContext _localctx = new Time_answerContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_time_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(FORMAT_START);
			setState(145);
			match(T__17);
			setState(146);
			match(FORMAT_END);
			setState(147);
			match(SOLUTION_START);
			setState(148);
			match(TIME);
			setState(149);
			match(SOLUTION_END);
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
	public static class Integer_scale_answerContext extends ParserRuleContext {
		public TerminalNode FORMAT_START() { return getToken(Jobs4uGrammarParser.FORMAT_START, 0); }
		public TerminalNode FORMAT_END() { return getToken(Jobs4uGrammarParser.FORMAT_END, 0); }
		public TerminalNode FORMAT_CONF_START() { return getToken(Jobs4uGrammarParser.FORMAT_CONF_START, 0); }
		public List<TerminalNode> SCALE() { return getTokens(Jobs4uGrammarParser.SCALE); }
		public TerminalNode SCALE(int i) {
			return getToken(Jobs4uGrammarParser.SCALE, i);
		}
		public TerminalNode FORMAT_CONF_END() { return getToken(Jobs4uGrammarParser.FORMAT_CONF_END, 0); }
		public TerminalNode SOLUTION_START() { return getToken(Jobs4uGrammarParser.SOLUTION_START, 0); }
		public TerminalNode SOLUTION_END() { return getToken(Jobs4uGrammarParser.SOLUTION_END, 0); }
		public Integer_scale_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_scale_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterInteger_scale_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitInteger_scale_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitInteger_scale_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integer_scale_answerContext integer_scale_answer() throws RecognitionException {
		Integer_scale_answerContext _localctx = new Integer_scale_answerContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_integer_scale_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(FORMAT_START);
			setState(152);
			match(T__18);
			setState(153);
			match(FORMAT_END);
			setState(154);
			match(FORMAT_CONF_START);
			setState(155);
			match(SCALE);
			setState(156);
			match(FORMAT_CONF_END);
			setState(157);
			match(SOLUTION_START);
			setState(158);
			match(SCALE);
			setState(159);
			match(SOLUTION_END);
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
	public static class Format_conf_choice_single_answerContext extends ParserRuleContext {
		public List<TerminalNode> QUOTE_STRING() { return getTokens(Jobs4uGrammarParser.QUOTE_STRING); }
		public TerminalNode QUOTE_STRING(int i) {
			return getToken(Jobs4uGrammarParser.QUOTE_STRING, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Jobs4uGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Jobs4uGrammarParser.COMMA, i);
		}
		public Format_conf_choice_single_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_format_conf_choice_single_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterFormat_conf_choice_single_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitFormat_conf_choice_single_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitFormat_conf_choice_single_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Format_conf_choice_single_answerContext format_conf_choice_single_answer() throws RecognitionException {
		Format_conf_choice_single_answerContext _localctx = new Format_conf_choice_single_answerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_format_conf_choice_single_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(QUOTE_STRING);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(162);
				match(COMMA);
				setState(163);
				match(QUOTE_STRING);
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class Format_conf_choice_multiple_answerContext extends ParserRuleContext {
		public List<TerminalNode> QUOTE_STRING() { return getTokens(Jobs4uGrammarParser.QUOTE_STRING); }
		public TerminalNode QUOTE_STRING(int i) {
			return getToken(Jobs4uGrammarParser.QUOTE_STRING, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Jobs4uGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Jobs4uGrammarParser.COMMA, i);
		}
		public Format_conf_choice_multiple_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_format_conf_choice_multiple_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterFormat_conf_choice_multiple_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitFormat_conf_choice_multiple_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitFormat_conf_choice_multiple_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Format_conf_choice_multiple_answerContext format_conf_choice_multiple_answer() throws RecognitionException {
		Format_conf_choice_multiple_answerContext _localctx = new Format_conf_choice_multiple_answerContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_format_conf_choice_multiple_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(QUOTE_STRING);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(170);
				match(COMMA);
				setState(171);
				match(QUOTE_STRING);
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class Format_answer_choice_multiple_answerContext extends ParserRuleContext {
		public List<Format_answer_choice_multiple_answer_optionContext> format_answer_choice_multiple_answer_option() {
			return getRuleContexts(Format_answer_choice_multiple_answer_optionContext.class);
		}
		public Format_answer_choice_multiple_answer_optionContext format_answer_choice_multiple_answer_option(int i) {
			return getRuleContext(Format_answer_choice_multiple_answer_optionContext.class,i);
		}
		public Format_answer_choice_multiple_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_format_answer_choice_multiple_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterFormat_answer_choice_multiple_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitFormat_answer_choice_multiple_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitFormat_answer_choice_multiple_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Format_answer_choice_multiple_answerContext format_answer_choice_multiple_answer() throws RecognitionException {
		Format_answer_choice_multiple_answerContext _localctx = new Format_answer_choice_multiple_answerContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_format_answer_choice_multiple_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			format_answer_choice_multiple_answer_option();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(178);
				match(T__19);
				setState(179);
				format_answer_choice_multiple_answer_option();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class Format_answer_choice_multiple_answer_optionContext extends ParserRuleContext {
		public List<TerminalNode> QUOTE_STRING() { return getTokens(Jobs4uGrammarParser.QUOTE_STRING); }
		public TerminalNode QUOTE_STRING(int i) {
			return getToken(Jobs4uGrammarParser.QUOTE_STRING, i);
		}
		public TerminalNode PERCENTAGE() { return getToken(Jobs4uGrammarParser.PERCENTAGE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Jobs4uGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Jobs4uGrammarParser.COMMA, i);
		}
		public Format_answer_choice_multiple_answer_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_format_answer_choice_multiple_answer_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).enterFormat_answer_choice_multiple_answer_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jobs4uGrammarListener ) ((Jobs4uGrammarListener)listener).exitFormat_answer_choice_multiple_answer_option(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jobs4uGrammarVisitor ) return ((Jobs4uGrammarVisitor<? extends T>)visitor).visitFormat_answer_choice_multiple_answer_option(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Format_answer_choice_multiple_answer_optionContext format_answer_choice_multiple_answer_option() throws RecognitionException {
		Format_answer_choice_multiple_answer_optionContext _localctx = new Format_answer_choice_multiple_answer_optionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_format_answer_choice_multiple_answer_option);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(QUOTE_STRING);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(186);
				match(COMMA);
				setState(187);
				match(QUOTE_STRING);
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
			match(PERCENTAGE);
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

	public static final String _serializedATN =
		"\u0004\u0001\'\u00c4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0004\u0001-\b\u0001\u000b\u0001\f\u0001.\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u00029\b\u0002\n\u0002\f\u0002<\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006U\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00a5\b\u0010\n\u0010\f\u0010\u00a8"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00ad\b\u0011"+
		"\n\u0011\f\u0011\u00b0\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u00b5\b\u0012\n\u0012\f\u0012\u00b8\t\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u00bd\b\u0013\n\u0013\f\u0013\u00c0\t\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000"+
		"\u0000\u00c0\u0000(\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000"+
		"\u00043\u0001\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000\bC\u0001"+
		"\u0000\u0000\u0000\nG\u0001\u0000\u0000\u0000\fT\u0001\u0000\u0000\u0000"+
		"\u000eV\u0001\u0000\u0000\u0000\u0010]\u0001\u0000\u0000\u0000\u0012g"+
		"\u0001\u0000\u0000\u0000\u0014q\u0001\u0000\u0000\u0000\u0016{\u0001\u0000"+
		"\u0000\u0000\u0018\u0082\u0001\u0000\u0000\u0000\u001a\u0089\u0001\u0000"+
		"\u0000\u0000\u001c\u0090\u0001\u0000\u0000\u0000\u001e\u0097\u0001\u0000"+
		"\u0000\u0000 \u00a1\u0001\u0000\u0000\u0000\"\u00a9\u0001\u0000\u0000"+
		"\u0000$\u00b1\u0001\u0000\u0000\u0000&\u00b9\u0001\u0000\u0000\u0000("+
		")\u0003\u0002\u0001\u0000)\u0001\u0001\u0000\u0000\u0000*,\u0005\u0001"+
		"\u0000\u0000+-\u0003\u0004\u0002\u0000,+\u0001\u0000\u0000\u0000-.\u0001"+
		"\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u000001\u0005\u0002\u0000\u000012\u0005\u0000\u0000"+
		"\u00012\u0003\u0001\u0000\u0000\u00003:\u0005\u0003\u0000\u000049\u0003"+
		"\u0006\u0003\u000059\u0003\b\u0004\u000069\u0003\n\u0005\u000079\u0003"+
		"\f\u0006\u000084\u0001\u0000\u0000\u000085\u0001\u0000\u0000\u000086\u0001"+
		"\u0000\u0000\u000087\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000"+
		"\u0000<:\u0001\u0000\u0000\u0000=>\u0005\u0004\u0000\u0000>\u0005\u0001"+
		"\u0000\u0000\u0000?@\u0005\u0005\u0000\u0000@A\u0005&\u0000\u0000AB\u0005"+
		"\u0006\u0000\u0000B\u0007\u0001\u0000\u0000\u0000CD\u0005\u0007\u0000"+
		"\u0000DE\u0005&\u0000\u0000EF\u0005\b\u0000\u0000F\t\u0001\u0000\u0000"+
		"\u0000GH\u0005\t\u0000\u0000HI\u0005 \u0000\u0000IJ\u0005\n\u0000\u0000"+
		"J\u000b\u0001\u0000\u0000\u0000KU\u0003\u000e\u0007\u0000LU\u0003\u0010"+
		"\b\u0000MU\u0003\u0012\t\u0000NU\u0003\u0014\n\u0000OU\u0003\u0016\u000b"+
		"\u0000PU\u0003\u0018\f\u0000QU\u0003\u001a\r\u0000RU\u0003\u001c\u000e"+
		"\u0000SU\u0003\u001e\u000f\u0000TK\u0001\u0000\u0000\u0000TL\u0001\u0000"+
		"\u0000\u0000TM\u0001\u0000\u0000\u0000TN\u0001\u0000\u0000\u0000TO\u0001"+
		"\u0000\u0000\u0000TP\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000\u0000"+
		"TR\u0001\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000U\r\u0001\u0000\u0000"+
		"\u0000VW\u0005\u001c\u0000\u0000WX\u0005\u000b\u0000\u0000XY\u0005\u001d"+
		"\u0000\u0000YZ\u0005\u001a\u0000\u0000Z[\u0005\u0017\u0000\u0000[\\\u0005"+
		"\u001b\u0000\u0000\\\u000f\u0001\u0000\u0000\u0000]^\u0005\u001c\u0000"+
		"\u0000^_\u0005\f\u0000\u0000_`\u0005\u001d\u0000\u0000`a\u0005\u0018\u0000"+
		"\u0000ab\u0005&\u0000\u0000bc\u0005\u0019\u0000\u0000cd\u0005\u001a\u0000"+
		"\u0000de\u0005&\u0000\u0000ef\u0005\u001b\u0000\u0000f\u0011\u0001\u0000"+
		"\u0000\u0000gh\u0005\u001c\u0000\u0000hi\u0005\r\u0000\u0000ij\u0005\u001d"+
		"\u0000\u0000jk\u0005\u0018\u0000\u0000kl\u0003 \u0010\u0000lm\u0005\u0019"+
		"\u0000\u0000mn\u0005\u001a\u0000\u0000no\u0005&\u0000\u0000op\u0005\u001b"+
		"\u0000\u0000p\u0013\u0001\u0000\u0000\u0000qr\u0005\u001c\u0000\u0000"+
		"rs\u0005\u000e\u0000\u0000st\u0005\u001d\u0000\u0000tu\u0005\u0018\u0000"+
		"\u0000uv\u0003\"\u0011\u0000vw\u0005\u0019\u0000\u0000wx\u0005\u001a\u0000"+
		"\u0000xy\u0003$\u0012\u0000yz\u0005\u001b\u0000\u0000z\u0015\u0001\u0000"+
		"\u0000\u0000{|\u0005\u001c\u0000\u0000|}\u0005\u000f\u0000\u0000}~\u0005"+
		"\u001d\u0000\u0000~\u007f\u0005\u001a\u0000\u0000\u007f\u0080\u0005 \u0000"+
		"\u0000\u0080\u0081\u0005\u001b\u0000\u0000\u0081\u0017\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0005\u001c\u0000\u0000\u0083\u0084\u0005\u0010\u0000"+
		"\u0000\u0084\u0085\u0005\u001d\u0000\u0000\u0085\u0086\u0005\u001a\u0000"+
		"\u0000\u0086\u0087\u0005!\u0000\u0000\u0087\u0088\u0005\u001b\u0000\u0000"+
		"\u0088\u0019\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u001c\u0000\u0000"+
		"\u008a\u008b\u0005\u0011\u0000\u0000\u008b\u008c\u0005\u001d\u0000\u0000"+
		"\u008c\u008d\u0005\u001a\u0000\u0000\u008d\u008e\u0005\"\u0000\u0000\u008e"+
		"\u008f\u0005\u001b\u0000\u0000\u008f\u001b\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0005\u001c\u0000\u0000\u0091\u0092\u0005\u0012\u0000\u0000\u0092"+
		"\u0093\u0005\u001d\u0000\u0000\u0093\u0094\u0005\u001a\u0000\u0000\u0094"+
		"\u0095\u0005#\u0000\u0000\u0095\u0096\u0005\u001b\u0000\u0000\u0096\u001d"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u001c\u0000\u0000\u0098\u0099"+
		"\u0005\u0013\u0000\u0000\u0099\u009a\u0005\u001d\u0000\u0000\u009a\u009b"+
		"\u0005\u0018\u0000\u0000\u009b\u009c\u0005\u001f\u0000\u0000\u009c\u009d"+
		"\u0005\u0019\u0000\u0000\u009d\u009e\u0005\u001a\u0000\u0000\u009e\u009f"+
		"\u0005\u001f\u0000\u0000\u009f\u00a0\u0005\u001b\u0000\u0000\u00a0\u001f"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a6\u0005&\u0000\u0000\u00a2\u00a3\u0005"+
		"$\u0000\u0000\u00a3\u00a5\u0005&\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7!\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00ae\u0005&\u0000\u0000\u00aa"+
		"\u00ab\u0005$\u0000\u0000\u00ab\u00ad\u0005&\u0000\u0000\u00ac\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af#\u0001\u0000"+
		"\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b6\u0003&\u0013"+
		"\u0000\u00b2\u00b3\u0005\u0014\u0000\u0000\u00b3\u00b5\u0003&\u0013\u0000"+
		"\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7%\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9"+
		"\u00be\u0005&\u0000\u0000\u00ba\u00bb\u0005$\u0000\u0000\u00bb\u00bd\u0005"+
		"&\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000"+
		"\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0005\u001e\u0000\u0000\u00c2\'\u0001\u0000\u0000"+
		"\u0000\b.8:T\u00a6\u00ae\u00b6\u00be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}