package interviewModelQuestions;
// Generated from C:/Users/fabio/OneDrive/Documentos/ISEP_LEI/2o ANO/2º S/LPROG/TRABALHO_PRÁTICO/Exemplo_ANTLR/Questions/LabeledExpr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LabeledExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, COLON=23, LEFT_BRACE=24, 
		RIGHT_BRACE=25, LEFT_BRACKET=26, RIGHT_BRACKET=27, DASH=28, SLASH=29, 
		COMMENT=30, FLOAT=31, INT=32, BOOL=33, STRING=34, DAY=35, MONTH=36, YEAR=37, 
		DATE=38, TIME=39, WS=40;
	public static final int
		RULE_start = 0, RULE_question = 1, RULE_true_false = 2, RULE_bool_solution = 3, 
		RULE_short_text = 4, RULE_short_text_solution = 5, RULE_case_sensitive = 6, 
		RULE_single_choice = 7, RULE_subquestion = 8, RULE_answer = 9, RULE_matching_solution = 10, 
		RULE_match = 11, RULE_multiple_choice = 12, RULE_numerical_solution = 13, 
		RULE_combinations = 14, RULE_choice_type = 15, RULE_integer_number = 16, 
		RULE_integer_number_solution = 17, RULE_decimal_number = 18, RULE_description = 19, 
		RULE_feedback_text = 20, RULE_feedback_combination = 21, RULE_wrong_answer = 22, 
		RULE_correct_answer = 23, RULE_date = 24, RULE_date_solution = 25, RULE_time = 26, 
		RULE_time_solution = 27, RULE_numeric_scale = 28, RULE_numeric_scale_solution = 29, 
		RULE_error = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "question", "true_false", "bool_solution", "short_text", "short_text_solution", 
			"case_sensitive", "single_choice", "subquestion", "answer", "matching_solution", 
			"match", "multiple_choice", "numerical_solution", "combinations", "choice_type", 
			"integer_number", "integer_number_solution", "decimal_number", "description", 
			"feedback_text", "feedback_combination", "wrong_answer", "correct_answer", 
			"date", "date_solution", "time", "time_solution", "numeric_scale", "numeric_scale_solution", 
			"error"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TRUE_FALSE'", "'SOLUTION'", "'SHORT_ANSWER'", "'CASE_SENSITIVE:'", 
			"'MATCHING'", "'SUBQUESTION'", "'ANSWER'", "'MULTIPLE_CHOICE'", "','", 
			"'CHOICE_TYPE'", "'single-answer'", "'multiple-answer'", "'INTEGER_NUMBER'", 
			"'FLOAT'", "'DESCRIPTION'", "'FEEDBACK'", "'WRONG_ANSWER'", "'CORRECT_ANSWER'", 
			"'DATE'", "'TIME'", "'NUMERICAL'", "'ERROR'", "':'", "'{'", "'}'", "'['", 
			"']'", "'-'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "COLON", 
			"LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", "DASH", 
			"SLASH", "COMMENT", "FLOAT", "INT", "BOOL", "STRING", "DAY", "MONTH", 
			"YEAR", "DATE", "TIME", "WS"
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
	public String getGrammarFileName() { return "LabeledExpr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LabeledExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			question();
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
		public True_falseContext true_false() {
			return getRuleContext(True_falseContext.class,0);
		}
		public Short_textContext short_text() {
			return getRuleContext(Short_textContext.class,0);
		}
		public Single_choiceContext single_choice() {
			return getRuleContext(Single_choiceContext.class,0);
		}
		public Multiple_choiceContext multiple_choice() {
			return getRuleContext(Multiple_choiceContext.class,0);
		}
		public Integer_numberContext integer_number() {
			return getRuleContext(Integer_numberContext.class,0);
		}
		public Decimal_numberContext decimal_number() {
			return getRuleContext(Decimal_numberContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public Numeric_scaleContext numeric_scale() {
			return getRuleContext(Numeric_scaleContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_question);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				true_false();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				short_text();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				single_choice();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				multiple_choice();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(69);
				integer_number();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 7);
				{
				setState(70);
				decimal_number();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 8);
				{
				setState(71);
				date();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 9);
				{
				setState(72);
				time();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 10);
				{
				setState(73);
				numeric_scale();
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
	public static class True_falseContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(LabeledExprParser.LEFT_BRACE, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public Bool_solutionContext bool_solution() {
			return getRuleContext(Bool_solutionContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LabeledExprParser.RIGHT_BRACE, 0); }
		public Feedback_textContext feedback_text() {
			return getRuleContext(Feedback_textContext.class,0);
		}
		public True_falseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterTrue_false(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitTrue_false(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitTrue_false(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_falseContext true_false() throws RecognitionException {
		True_falseContext _localctx = new True_falseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_true_false);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__0);
			setState(77);
			match(LEFT_BRACE);
			setState(78);
			description();
			setState(79);
			bool_solution();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(80);
				feedback_text();
				}
			}

			setState(83);
			match(RIGHT_BRACE);
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
	public static class Bool_solutionContext extends ParserRuleContext {
		public Token id;
		public Token value;
		public Token points;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(LabeledExprParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LabeledExprParser.RIGHT_BRACKET, 0); }
		public TerminalNode INT() { return getToken(LabeledExprParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(LabeledExprParser.BOOL, 0); }
		public TerminalNode FLOAT() { return getToken(LabeledExprParser.FLOAT, 0); }
		public Bool_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterBool_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitBool_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitBool_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_solutionContext bool_solution() throws RecognitionException {
		Bool_solutionContext _localctx = new Bool_solutionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bool_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__1);
			setState(86);
			((Bool_solutionContext)_localctx).id = match(INT);
			setState(87);
			match(COLON);
			setState(88);
			((Bool_solutionContext)_localctx).value = match(BOOL);
			setState(89);
			match(LEFT_BRACKET);
			setState(90);
			((Bool_solutionContext)_localctx).points = match(FLOAT);
			setState(91);
			match(RIGHT_BRACKET);
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
	public static class Short_textContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(LabeledExprParser.LEFT_BRACE, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public Case_sensitiveContext case_sensitive() {
			return getRuleContext(Case_sensitiveContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LabeledExprParser.RIGHT_BRACE, 0); }
		public List<Short_text_solutionContext> short_text_solution() {
			return getRuleContexts(Short_text_solutionContext.class);
		}
		public Short_text_solutionContext short_text_solution(int i) {
			return getRuleContext(Short_text_solutionContext.class,i);
		}
		public Feedback_textContext feedback_text() {
			return getRuleContext(Feedback_textContext.class,0);
		}
		public Short_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterShort_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitShort_text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitShort_text(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_textContext short_text() throws RecognitionException {
		Short_textContext _localctx = new Short_textContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_short_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__2);
			setState(94);
			match(LEFT_BRACE);
			setState(95);
			description();
			setState(96);
			case_sensitive();
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				short_text_solution();
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(102);
				feedback_text();
				}
			}

			setState(105);
			match(RIGHT_BRACE);
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
	public static class Short_text_solutionContext extends ParserRuleContext {
		public Token id;
		public Token value;
		public Token points;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(LabeledExprParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LabeledExprParser.RIGHT_BRACKET, 0); }
		public TerminalNode INT() { return getToken(LabeledExprParser.INT, 0); }
		public TerminalNode STRING() { return getToken(LabeledExprParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(LabeledExprParser.FLOAT, 0); }
		public Short_text_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_text_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterShort_text_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitShort_text_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitShort_text_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_text_solutionContext short_text_solution() throws RecognitionException {
		Short_text_solutionContext _localctx = new Short_text_solutionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_short_text_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__1);
			setState(108);
			((Short_text_solutionContext)_localctx).id = match(INT);
			setState(109);
			match(COLON);
			setState(110);
			((Short_text_solutionContext)_localctx).value = match(STRING);
			setState(111);
			match(LEFT_BRACKET);
			setState(112);
			((Short_text_solutionContext)_localctx).points = match(FLOAT);
			setState(113);
			match(RIGHT_BRACKET);
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
	public static class Case_sensitiveContext extends ParserRuleContext {
		public Token value;
		public TerminalNode BOOL() { return getToken(LabeledExprParser.BOOL, 0); }
		public Case_sensitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_sensitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterCase_sensitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitCase_sensitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitCase_sensitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_sensitiveContext case_sensitive() throws RecognitionException {
		Case_sensitiveContext _localctx = new Case_sensitiveContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_case_sensitive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__3);
			setState(116);
			((Case_sensitiveContext)_localctx).value = match(BOOL);
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
	public static class Single_choiceContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(LabeledExprParser.LEFT_BRACE, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LabeledExprParser.RIGHT_BRACE, 0); }
		public List<SubquestionContext> subquestion() {
			return getRuleContexts(SubquestionContext.class);
		}
		public SubquestionContext subquestion(int i) {
			return getRuleContext(SubquestionContext.class,i);
		}
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public List<Matching_solutionContext> matching_solution() {
			return getRuleContexts(Matching_solutionContext.class);
		}
		public Matching_solutionContext matching_solution(int i) {
			return getRuleContext(Matching_solutionContext.class,i);
		}
		public Feedback_textContext feedback_text() {
			return getRuleContext(Feedback_textContext.class,0);
		}
		public Single_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterSingle_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitSingle_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitSingle_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_choiceContext single_choice() throws RecognitionException {
		Single_choiceContext _localctx = new Single_choiceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_single_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__4);
			setState(119);
			match(LEFT_BRACE);
			setState(120);
			description();
			setState(122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(121);
				subquestion();
				}
				}
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 );
			setState(127); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				answer();
				}
				}
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(131);
				matching_solution();
				}
				}
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(136);
				feedback_text();
				}
			}

			setState(139);
			match(RIGHT_BRACE);
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
	public static class SubquestionContext extends ParserRuleContext {
		public Token id;
		public Token value;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode INT() { return getToken(LabeledExprParser.INT, 0); }
		public TerminalNode STRING() { return getToken(LabeledExprParser.STRING, 0); }
		public SubquestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterSubquestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitSubquestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitSubquestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubquestionContext subquestion() throws RecognitionException {
		SubquestionContext _localctx = new SubquestionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_subquestion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__5);
			setState(142);
			((SubquestionContext)_localctx).id = match(INT);
			setState(143);
			match(COLON);
			setState(144);
			((SubquestionContext)_localctx).value = match(STRING);
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
		public Token id;
		public Token value;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode INT() { return getToken(LabeledExprParser.INT, 0); }
		public TerminalNode STRING() { return getToken(LabeledExprParser.STRING, 0); }
		public AnswerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterAnswer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitAnswer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitAnswer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerContext answer() throws RecognitionException {
		AnswerContext _localctx = new AnswerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__6);
			setState(147);
			((AnswerContext)_localctx).id = match(INT);
			setState(148);
			match(COLON);
			setState(149);
			((AnswerContext)_localctx).value = match(STRING);
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
	public static class Matching_solutionContext extends ParserRuleContext {
		public Token id;
		public Token points;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public MatchContext match() {
			return getRuleContext(MatchContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(LabeledExprParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LabeledExprParser.RIGHT_BRACKET, 0); }
		public TerminalNode INT() { return getToken(LabeledExprParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LabeledExprParser.FLOAT, 0); }
		public Matching_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterMatching_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitMatching_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitMatching_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_solutionContext matching_solution() throws RecognitionException {
		Matching_solutionContext _localctx = new Matching_solutionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_matching_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__1);
			setState(152);
			((Matching_solutionContext)_localctx).id = match(INT);
			setState(153);
			match(COLON);
			setState(154);
			match();
			setState(155);
			match(LEFT_BRACKET);
			setState(156);
			((Matching_solutionContext)_localctx).points = match(FLOAT);
			setState(157);
			match(RIGHT_BRACKET);
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
	public static class MatchContext extends ParserRuleContext {
		public Token subquestion_id;
		public Token answer_id;
		public TerminalNode DASH() { return getToken(LabeledExprParser.DASH, 0); }
		public List<TerminalNode> INT() { return getTokens(LabeledExprParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(LabeledExprParser.INT, i);
		}
		public MatchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitMatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitMatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchContext match() throws RecognitionException {
		MatchContext _localctx = new MatchContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_match);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			((MatchContext)_localctx).subquestion_id = match(INT);
			setState(160);
			match(DASH);
			setState(161);
			((MatchContext)_localctx).answer_id = match(INT);
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
	public static class Multiple_choiceContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(LabeledExprParser.LEFT_BRACE, 0); }
		public Choice_typeContext choice_type() {
			return getRuleContext(Choice_typeContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LabeledExprParser.RIGHT_BRACE, 0); }
		public List<AnswerContext> answer() {
			return getRuleContexts(AnswerContext.class);
		}
		public AnswerContext answer(int i) {
			return getRuleContext(AnswerContext.class,i);
		}
		public List<Numerical_solutionContext> numerical_solution() {
			return getRuleContexts(Numerical_solutionContext.class);
		}
		public Numerical_solutionContext numerical_solution(int i) {
			return getRuleContext(Numerical_solutionContext.class,i);
		}
		public Feedback_textContext feedback_text() {
			return getRuleContext(Feedback_textContext.class,0);
		}
		public Multiple_choiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterMultiple_choice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitMultiple_choice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitMultiple_choice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choiceContext multiple_choice() throws RecognitionException {
		Multiple_choiceContext _localctx = new Multiple_choiceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_multiple_choice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__7);
			setState(164);
			match(LEFT_BRACE);
			setState(165);
			choice_type();
			setState(166);
			description();
			setState(168); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(167);
				answer();
				}
				}
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
			setState(173); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(172);
				numerical_solution();
				}
				}
				setState(175); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(177);
				feedback_text();
				}
			}

			setState(180);
			match(RIGHT_BRACE);
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
	public static class Numerical_solutionContext extends ParserRuleContext {
		public Token id;
		public Token points;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public CombinationsContext combinations() {
			return getRuleContext(CombinationsContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(LabeledExprParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LabeledExprParser.RIGHT_BRACKET, 0); }
		public TerminalNode INT() { return getToken(LabeledExprParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LabeledExprParser.FLOAT, 0); }
		public Numerical_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterNumerical_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitNumerical_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitNumerical_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numerical_solutionContext numerical_solution() throws RecognitionException {
		Numerical_solutionContext _localctx = new Numerical_solutionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_numerical_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__1);
			setState(183);
			((Numerical_solutionContext)_localctx).id = match(INT);
			setState(184);
			match(COLON);
			setState(185);
			combinations();
			setState(186);
			match(LEFT_BRACKET);
			setState(187);
			((Numerical_solutionContext)_localctx).points = match(FLOAT);
			setState(188);
			match(RIGHT_BRACKET);
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
	public static class CombinationsContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(LabeledExprParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(LabeledExprParser.INT, i);
		}
		public CombinationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_combinations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterCombinations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitCombinations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitCombinations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CombinationsContext combinations() throws RecognitionException {
		CombinationsContext _localctx = new CombinationsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_combinations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(INT);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(191);
				match(T__8);
				setState(192);
				match(INT);
				}
				}
				setState(197);
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
	public static class Choice_typeContext extends ParserRuleContext {
		public Token value;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public Choice_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterChoice_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitChoice_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitChoice_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Choice_typeContext choice_type() throws RecognitionException {
		Choice_typeContext _localctx = new Choice_typeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_choice_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__9);
			setState(199);
			match(COLON);
			setState(200);
			((Choice_typeContext)_localctx).value = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__10 || _la==T__11) ) {
				((Choice_typeContext)_localctx).value = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class Integer_numberContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(LabeledExprParser.LEFT_BRACE, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public Integer_number_solutionContext integer_number_solution() {
			return getRuleContext(Integer_number_solutionContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LabeledExprParser.RIGHT_BRACE, 0); }
		public ErrorContext error() {
			return getRuleContext(ErrorContext.class,0);
		}
		public Feedback_textContext feedback_text() {
			return getRuleContext(Feedback_textContext.class,0);
		}
		public Integer_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterInteger_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitInteger_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitInteger_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integer_numberContext integer_number() throws RecognitionException {
		Integer_numberContext _localctx = new Integer_numberContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_integer_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(T__12);
			setState(203);
			match(LEFT_BRACE);
			setState(204);
			description();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(205);
				error();
				}
			}

			setState(208);
			integer_number_solution();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(209);
				feedback_text();
				}
			}

			setState(212);
			match(RIGHT_BRACE);
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
	public static class Integer_number_solutionContext extends ParserRuleContext {
		public Token id;
		public Token value;
		public Token points;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(LabeledExprParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LabeledExprParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> INT() { return getTokens(LabeledExprParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(LabeledExprParser.INT, i);
		}
		public TerminalNode FLOAT() { return getToken(LabeledExprParser.FLOAT, 0); }
		public Integer_number_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_number_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterInteger_number_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitInteger_number_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitInteger_number_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Integer_number_solutionContext integer_number_solution() throws RecognitionException {
		Integer_number_solutionContext _localctx = new Integer_number_solutionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_integer_number_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(T__1);
			setState(215);
			((Integer_number_solutionContext)_localctx).id = match(INT);
			setState(216);
			match(COLON);
			setState(217);
			((Integer_number_solutionContext)_localctx).value = match(INT);
			setState(218);
			match(LEFT_BRACKET);
			setState(219);
			((Integer_number_solutionContext)_localctx).points = match(FLOAT);
			setState(220);
			match(RIGHT_BRACKET);
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
	public static class Decimal_numberContext extends ParserRuleContext {
		public Decimal_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterDecimal_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitDecimal_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitDecimal_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decimal_numberContext decimal_number() throws RecognitionException {
		Decimal_numberContext _localctx = new Decimal_numberContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_decimal_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(T__13);
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
	public static class DescriptionContext extends ParserRuleContext {
		public Token value;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(LabeledExprParser.STRING, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__14);
			setState(225);
			match(COLON);
			setState(226);
			((DescriptionContext)_localctx).value = match(STRING);
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
	public static class Feedback_textContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(LabeledExprParser.LEFT_BRACE, 0); }
		public Feedback_combinationContext feedback_combination() {
			return getRuleContext(Feedback_combinationContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LabeledExprParser.RIGHT_BRACE, 0); }
		public Feedback_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterFeedback_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitFeedback_text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitFeedback_text(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Feedback_textContext feedback_text() throws RecognitionException {
		Feedback_textContext _localctx = new Feedback_textContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_feedback_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__15);
			setState(229);
			match(LEFT_BRACE);
			setState(230);
			feedback_combination();
			setState(231);
			match(RIGHT_BRACE);
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
	public static class Feedback_combinationContext extends ParserRuleContext {
		public Correct_answerContext correct_answer() {
			return getRuleContext(Correct_answerContext.class,0);
		}
		public Wrong_answerContext wrong_answer() {
			return getRuleContext(Wrong_answerContext.class,0);
		}
		public Feedback_combinationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback_combination; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterFeedback_combination(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitFeedback_combination(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitFeedback_combination(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Feedback_combinationContext feedback_combination() throws RecognitionException {
		Feedback_combinationContext _localctx = new Feedback_combinationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_feedback_combination);
		int _la;
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(233);
					wrong_answer();
					}
				}

				setState(236);
				correct_answer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__17) {
					{
					setState(237);
					correct_answer();
					}
				}

				setState(240);
				wrong_answer();
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
	public static class Wrong_answerContext extends ParserRuleContext {
		public Token value;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(LabeledExprParser.STRING, 0); }
		public Wrong_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wrong_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterWrong_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitWrong_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitWrong_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Wrong_answerContext wrong_answer() throws RecognitionException {
		Wrong_answerContext _localctx = new Wrong_answerContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_wrong_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(T__16);
			setState(244);
			match(COLON);
			setState(245);
			((Wrong_answerContext)_localctx).value = match(STRING);
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
	public static class Correct_answerContext extends ParserRuleContext {
		public Token value;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode STRING() { return getToken(LabeledExprParser.STRING, 0); }
		public Correct_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_correct_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterCorrect_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitCorrect_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitCorrect_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Correct_answerContext correct_answer() throws RecognitionException {
		Correct_answerContext _localctx = new Correct_answerContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_correct_answer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__17);
			setState(248);
			match(COLON);
			setState(249);
			((Correct_answerContext)_localctx).value = match(STRING);
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
	public static class DateContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(LabeledExprParser.LEFT_BRACE, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public Date_solutionContext date_solution() {
			return getRuleContext(Date_solutionContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LabeledExprParser.RIGHT_BRACE, 0); }
		public Feedback_textContext feedback_text() {
			return getRuleContext(Feedback_textContext.class,0);
		}
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_date);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__18);
			setState(252);
			match(LEFT_BRACE);
			setState(253);
			description();
			setState(254);
			date_solution();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(255);
				feedback_text();
				}
			}

			setState(258);
			match(RIGHT_BRACE);
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
	public static class Date_solutionContext extends ParserRuleContext {
		public Token id;
		public Token value;
		public Token points;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(LabeledExprParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LabeledExprParser.RIGHT_BRACKET, 0); }
		public TerminalNode INT() { return getToken(LabeledExprParser.INT, 0); }
		public TerminalNode DATE() { return getToken(LabeledExprParser.DATE, 0); }
		public TerminalNode FLOAT() { return getToken(LabeledExprParser.FLOAT, 0); }
		public Date_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterDate_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitDate_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitDate_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_solutionContext date_solution() throws RecognitionException {
		Date_solutionContext _localctx = new Date_solutionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_date_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__1);
			setState(261);
			((Date_solutionContext)_localctx).id = match(INT);
			setState(262);
			match(COLON);
			setState(263);
			((Date_solutionContext)_localctx).value = match(DATE);
			setState(264);
			match(LEFT_BRACKET);
			setState(265);
			((Date_solutionContext)_localctx).points = match(FLOAT);
			setState(266);
			match(RIGHT_BRACKET);
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
	public static class TimeContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(LabeledExprParser.LEFT_BRACE, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public Time_solutionContext time_solution() {
			return getRuleContext(Time_solutionContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LabeledExprParser.RIGHT_BRACE, 0); }
		public Feedback_textContext feedback_text() {
			return getRuleContext(Feedback_textContext.class,0);
		}
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_time);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(T__19);
			setState(269);
			match(LEFT_BRACE);
			setState(270);
			description();
			setState(271);
			time_solution();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(272);
				feedback_text();
				}
			}

			setState(275);
			match(RIGHT_BRACE);
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
	public static class Time_solutionContext extends ParserRuleContext {
		public Token id;
		public Token value;
		public Token points;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(LabeledExprParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LabeledExprParser.RIGHT_BRACKET, 0); }
		public TerminalNode INT() { return getToken(LabeledExprParser.INT, 0); }
		public TerminalNode TIME() { return getToken(LabeledExprParser.TIME, 0); }
		public TerminalNode FLOAT() { return getToken(LabeledExprParser.FLOAT, 0); }
		public Time_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterTime_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitTime_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitTime_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_solutionContext time_solution() throws RecognitionException {
		Time_solutionContext _localctx = new Time_solutionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_time_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(T__1);
			setState(278);
			((Time_solutionContext)_localctx).id = match(INT);
			setState(279);
			match(COLON);
			setState(280);
			((Time_solutionContext)_localctx).value = match(TIME);
			setState(281);
			match(LEFT_BRACKET);
			setState(282);
			((Time_solutionContext)_localctx).points = match(FLOAT);
			setState(283);
			match(RIGHT_BRACKET);
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
	public static class Numeric_scaleContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(LabeledExprParser.LEFT_BRACE, 0); }
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public Numeric_scale_solutionContext numeric_scale_solution() {
			return getRuleContext(Numeric_scale_solutionContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(LabeledExprParser.RIGHT_BRACE, 0); }
		public ErrorContext error() {
			return getRuleContext(ErrorContext.class,0);
		}
		public Feedback_textContext feedback_text() {
			return getRuleContext(Feedback_textContext.class,0);
		}
		public Numeric_scaleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_scale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterNumeric_scale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitNumeric_scale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitNumeric_scale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numeric_scaleContext numeric_scale() throws RecognitionException {
		Numeric_scaleContext _localctx = new Numeric_scaleContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_numeric_scale);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(T__20);
			setState(286);
			match(LEFT_BRACE);
			setState(287);
			description();
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(288);
				error();
				}
			}

			setState(291);
			numeric_scale_solution();
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(292);
				feedback_text();
				}
			}

			setState(295);
			match(RIGHT_BRACE);
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
	public static class Numeric_scale_solutionContext extends ParserRuleContext {
		public Token id;
		public Token value;
		public Token points;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(LabeledExprParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(LabeledExprParser.RIGHT_BRACKET, 0); }
		public List<TerminalNode> INT() { return getTokens(LabeledExprParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(LabeledExprParser.INT, i);
		}
		public TerminalNode FLOAT() { return getToken(LabeledExprParser.FLOAT, 0); }
		public Numeric_scale_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_scale_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterNumeric_scale_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitNumeric_scale_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitNumeric_scale_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numeric_scale_solutionContext numeric_scale_solution() throws RecognitionException {
		Numeric_scale_solutionContext _localctx = new Numeric_scale_solutionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_numeric_scale_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(T__1);
			setState(298);
			((Numeric_scale_solutionContext)_localctx).id = match(INT);
			setState(299);
			match(COLON);
			setState(300);
			((Numeric_scale_solutionContext)_localctx).value = match(INT);
			setState(301);
			match(LEFT_BRACKET);
			setState(302);
			((Numeric_scale_solutionContext)_localctx).points = match(FLOAT);
			setState(303);
			match(RIGHT_BRACKET);
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
	public static class ErrorContext extends ParserRuleContext {
		public Token value;
		public TerminalNode COLON() { return getToken(LabeledExprParser.COLON, 0); }
		public TerminalNode INT() { return getToken(LabeledExprParser.INT, 0); }
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).enterError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LabeledExprListener ) ((LabeledExprListener)listener).exitError(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LabeledExprVisitor ) return ((LabeledExprVisitor<? extends T>)visitor).visitError(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(T__21);
			setState(306);
			match(COLON);
			setState(307);
			((ErrorContext)_localctx).value = match(INT);
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
		"\u0004\u0001(\u0136\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001K\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002R\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004c\b\u0004\u000b\u0004\f\u0004d\u0001\u0004\u0003\u0004h\b"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004"+
		"\u0007{\b\u0007\u000b\u0007\f\u0007|\u0001\u0007\u0004\u0007\u0080\b\u0007"+
		"\u000b\u0007\f\u0007\u0081\u0001\u0007\u0004\u0007\u0085\b\u0007\u000b"+
		"\u0007\f\u0007\u0086\u0001\u0007\u0003\u0007\u008a\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0004\f\u00a9\b\f\u000b\f\f\f\u00aa\u0001\f"+
		"\u0004\f\u00ae\b\f\u000b\f\f\f\u00af\u0001\f\u0003\f\u00b3\b\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00c2\b\u000e\n\u000e"+
		"\f\u000e\u00c5\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00cf\b\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u00d3\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0003\u0015\u00eb\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u00ef\b\u0015\u0001\u0015\u0003\u0015\u00f2\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u0101\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u0112\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0122\b\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u0126\b\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0000\u0000\u001f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<\u0000\u0001\u0001"+
		"\u0000\u000b\f\u0133\u0000>\u0001\u0000\u0000\u0000\u0002J\u0001\u0000"+
		"\u0000\u0000\u0004L\u0001\u0000\u0000\u0000\u0006U\u0001\u0000\u0000\u0000"+
		"\b]\u0001\u0000\u0000\u0000\nk\u0001\u0000\u0000\u0000\fs\u0001\u0000"+
		"\u0000\u0000\u000ev\u0001\u0000\u0000\u0000\u0010\u008d\u0001\u0000\u0000"+
		"\u0000\u0012\u0092\u0001\u0000\u0000\u0000\u0014\u0097\u0001\u0000\u0000"+
		"\u0000\u0016\u009f\u0001\u0000\u0000\u0000\u0018\u00a3\u0001\u0000\u0000"+
		"\u0000\u001a\u00b6\u0001\u0000\u0000\u0000\u001c\u00be\u0001\u0000\u0000"+
		"\u0000\u001e\u00c6\u0001\u0000\u0000\u0000 \u00ca\u0001\u0000\u0000\u0000"+
		"\"\u00d6\u0001\u0000\u0000\u0000$\u00de\u0001\u0000\u0000\u0000&\u00e0"+
		"\u0001\u0000\u0000\u0000(\u00e4\u0001\u0000\u0000\u0000*\u00f1\u0001\u0000"+
		"\u0000\u0000,\u00f3\u0001\u0000\u0000\u0000.\u00f7\u0001\u0000\u0000\u0000"+
		"0\u00fb\u0001\u0000\u0000\u00002\u0104\u0001\u0000\u0000\u00004\u010c"+
		"\u0001\u0000\u0000\u00006\u0115\u0001\u0000\u0000\u00008\u011d\u0001\u0000"+
		"\u0000\u0000:\u0129\u0001\u0000\u0000\u0000<\u0131\u0001\u0000\u0000\u0000"+
		">?\u0003\u0002\u0001\u0000?\u0001\u0001\u0000\u0000\u0000@K\u0001\u0000"+
		"\u0000\u0000AK\u0003\u0004\u0002\u0000BK\u0003\b\u0004\u0000CK\u0003\u000e"+
		"\u0007\u0000DK\u0003\u0018\f\u0000EK\u0003 \u0010\u0000FK\u0003$\u0012"+
		"\u0000GK\u00030\u0018\u0000HK\u00034\u001a\u0000IK\u00038\u001c\u0000"+
		"J@\u0001\u0000\u0000\u0000JA\u0001\u0000\u0000\u0000JB\u0001\u0000\u0000"+
		"\u0000JC\u0001\u0000\u0000\u0000JD\u0001\u0000\u0000\u0000JE\u0001\u0000"+
		"\u0000\u0000JF\u0001\u0000\u0000\u0000JG\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000JI\u0001\u0000\u0000\u0000K\u0003\u0001\u0000\u0000"+
		"\u0000LM\u0005\u0001\u0000\u0000MN\u0005\u0018\u0000\u0000NO\u0003&\u0013"+
		"\u0000OQ\u0003\u0006\u0003\u0000PR\u0003(\u0014\u0000QP\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0005\u0019"+
		"\u0000\u0000T\u0005\u0001\u0000\u0000\u0000UV\u0005\u0002\u0000\u0000"+
		"VW\u0005 \u0000\u0000WX\u0005\u0017\u0000\u0000XY\u0005!\u0000\u0000Y"+
		"Z\u0005\u001a\u0000\u0000Z[\u0005\u001f\u0000\u0000[\\\u0005\u001b\u0000"+
		"\u0000\\\u0007\u0001\u0000\u0000\u0000]^\u0005\u0003\u0000\u0000^_\u0005"+
		"\u0018\u0000\u0000_`\u0003&\u0013\u0000`b\u0003\f\u0006\u0000ac\u0003"+
		"\n\u0005\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000db\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000"+
		"fh\u0003(\u0014\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000ij\u0005\u0019\u0000\u0000j\t\u0001\u0000\u0000"+
		"\u0000kl\u0005\u0002\u0000\u0000lm\u0005 \u0000\u0000mn\u0005\u0017\u0000"+
		"\u0000no\u0005\"\u0000\u0000op\u0005\u001a\u0000\u0000pq\u0005\u001f\u0000"+
		"\u0000qr\u0005\u001b\u0000\u0000r\u000b\u0001\u0000\u0000\u0000st\u0005"+
		"\u0004\u0000\u0000tu\u0005!\u0000\u0000u\r\u0001\u0000\u0000\u0000vw\u0005"+
		"\u0005\u0000\u0000wx\u0005\u0018\u0000\u0000xz\u0003&\u0013\u0000y{\u0003"+
		"\u0010\b\u0000zy\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001"+
		"\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001\u0000\u0000"+
		"\u0000~\u0080\u0003\u0012\t\u0000\u007f~\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083"+
		"\u0085\u0003\u0014\n\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0001\u0000\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u008a"+
		"\u0003(\u0014\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u0089\u008a\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0005"+
		"\u0019\u0000\u0000\u008c\u000f\u0001\u0000\u0000\u0000\u008d\u008e\u0005"+
		"\u0006\u0000\u0000\u008e\u008f\u0005 \u0000\u0000\u008f\u0090\u0005\u0017"+
		"\u0000\u0000\u0090\u0091\u0005\"\u0000\u0000\u0091\u0011\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0005\u0007\u0000\u0000\u0093\u0094\u0005 \u0000\u0000"+
		"\u0094\u0095\u0005\u0017\u0000\u0000\u0095\u0096\u0005\"\u0000\u0000\u0096"+
		"\u0013\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0002\u0000\u0000\u0098"+
		"\u0099\u0005 \u0000\u0000\u0099\u009a\u0005\u0017\u0000\u0000\u009a\u009b"+
		"\u0003\u0016\u000b\u0000\u009b\u009c\u0005\u001a\u0000\u0000\u009c\u009d"+
		"\u0005\u001f\u0000\u0000\u009d\u009e\u0005\u001b\u0000\u0000\u009e\u0015"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0005 \u0000\u0000\u00a0\u00a1\u0005"+
		"\u001c\u0000\u0000\u00a1\u00a2\u0005 \u0000\u0000\u00a2\u0017\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0005\b\u0000\u0000\u00a4\u00a5\u0005\u0018\u0000"+
		"\u0000\u00a5\u00a6\u0003\u001e\u000f\u0000\u00a6\u00a8\u0003&\u0013\u0000"+
		"\u00a7\u00a9\u0003\u0012\t\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ae\u0003\u001a\r\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b2\u0001\u0000\u0000\u0000\u00b1\u00b3"+
		"\u0003(\u0014\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005"+
		"\u0019\u0000\u0000\u00b5\u0019\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005"+
		"\u0002\u0000\u0000\u00b7\u00b8\u0005 \u0000\u0000\u00b8\u00b9\u0005\u0017"+
		"\u0000\u0000\u00b9\u00ba\u0003\u001c\u000e\u0000\u00ba\u00bb\u0005\u001a"+
		"\u0000\u0000\u00bb\u00bc\u0005\u001f\u0000\u0000\u00bc\u00bd\u0005\u001b"+
		"\u0000\u0000\u00bd\u001b\u0001\u0000\u0000\u0000\u00be\u00c3\u0005 \u0000"+
		"\u0000\u00bf\u00c0\u0005\t\u0000\u0000\u00c0\u00c2\u0005 \u0000\u0000"+
		"\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c4\u001d\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0005\n\u0000\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000\u00c8"+
		"\u00c9\u0007\u0000\u0000\u0000\u00c9\u001f\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cb\u0005\r\u0000\u0000\u00cb\u00cc\u0005\u0018\u0000\u0000\u00cc\u00ce"+
		"\u0003&\u0013\u0000\u00cd\u00cf\u0003<\u001e\u0000\u00ce\u00cd\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d2\u0003\"\u0011\u0000\u00d1\u00d3\u0003(\u0014"+
		"\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u0019\u0000"+
		"\u0000\u00d5!\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u0002\u0000\u0000"+
		"\u00d7\u00d8\u0005 \u0000\u0000\u00d8\u00d9\u0005\u0017\u0000\u0000\u00d9"+
		"\u00da\u0005 \u0000\u0000\u00da\u00db\u0005\u001a\u0000\u0000\u00db\u00dc"+
		"\u0005\u001f\u0000\u0000\u00dc\u00dd\u0005\u001b\u0000\u0000\u00dd#\u0001"+
		"\u0000\u0000\u0000\u00de\u00df\u0005\u000e\u0000\u0000\u00df%\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e1\u0005\u000f\u0000\u0000\u00e1\u00e2\u0005\u0017"+
		"\u0000\u0000\u00e2\u00e3\u0005\"\u0000\u0000\u00e3\'\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e5\u0005\u0010\u0000\u0000\u00e5\u00e6\u0005\u0018\u0000"+
		"\u0000\u00e6\u00e7\u0003*\u0015\u0000\u00e7\u00e8\u0005\u0019\u0000\u0000"+
		"\u00e8)\u0001\u0000\u0000\u0000\u00e9\u00eb\u0003,\u0016\u0000\u00ea\u00e9"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec"+
		"\u0001\u0000\u0000\u0000\u00ec\u00f2\u0003.\u0017\u0000\u00ed\u00ef\u0003"+
		".\u0017\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f2\u0003,\u0016"+
		"\u0000\u00f1\u00ea\u0001\u0000\u0000\u0000\u00f1\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f2+\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005\u0011\u0000\u0000"+
		"\u00f4\u00f5\u0005\u0017\u0000\u0000\u00f5\u00f6\u0005\"\u0000\u0000\u00f6"+
		"-\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u0012\u0000\u0000\u00f8\u00f9"+
		"\u0005\u0017\u0000\u0000\u00f9\u00fa\u0005\"\u0000\u0000\u00fa/\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0005\u0013\u0000\u0000\u00fc\u00fd\u0005"+
		"\u0018\u0000\u0000\u00fd\u00fe\u0003&\u0013\u0000\u00fe\u0100\u00032\u0019"+
		"\u0000\u00ff\u0101\u0003(\u0014\u0000\u0100\u00ff\u0001\u0000\u0000\u0000"+
		"\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000"+
		"\u0102\u0103\u0005\u0019\u0000\u0000\u01031\u0001\u0000\u0000\u0000\u0104"+
		"\u0105\u0005\u0002\u0000\u0000\u0105\u0106\u0005 \u0000\u0000\u0106\u0107"+
		"\u0005\u0017\u0000\u0000\u0107\u0108\u0005&\u0000\u0000\u0108\u0109\u0005"+
		"\u001a\u0000\u0000\u0109\u010a\u0005\u001f\u0000\u0000\u010a\u010b\u0005"+
		"\u001b\u0000\u0000\u010b3\u0001\u0000\u0000\u0000\u010c\u010d\u0005\u0014"+
		"\u0000\u0000\u010d\u010e\u0005\u0018\u0000\u0000\u010e\u010f\u0003&\u0013"+
		"\u0000\u010f\u0111\u00036\u001b\u0000\u0110\u0112\u0003(\u0014\u0000\u0111"+
		"\u0110\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112"+
		"\u0113\u0001\u0000\u0000\u0000\u0113\u0114\u0005\u0019\u0000\u0000\u0114"+
		"5\u0001\u0000\u0000\u0000\u0115\u0116\u0005\u0002\u0000\u0000\u0116\u0117"+
		"\u0005 \u0000\u0000\u0117\u0118\u0005\u0017\u0000\u0000\u0118\u0119\u0005"+
		"\'\u0000\u0000\u0119\u011a\u0005\u001a\u0000\u0000\u011a\u011b\u0005\u001f"+
		"\u0000\u0000\u011b\u011c\u0005\u001b\u0000\u0000\u011c7\u0001\u0000\u0000"+
		"\u0000\u011d\u011e\u0005\u0015\u0000\u0000\u011e\u011f\u0005\u0018\u0000"+
		"\u0000\u011f\u0121\u0003&\u0013\u0000\u0120\u0122\u0003<\u001e\u0000\u0121"+
		"\u0120\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0001\u0000\u0000\u0000\u0123\u0125\u0003:\u001d\u0000\u0124\u0126"+
		"\u0003(\u0014\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0125\u0126\u0001"+
		"\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0128\u0005"+
		"\u0019\u0000\u0000\u01289\u0001\u0000\u0000\u0000\u0129\u012a\u0005\u0002"+
		"\u0000\u0000\u012a\u012b\u0005 \u0000\u0000\u012b\u012c\u0005\u0017\u0000"+
		"\u0000\u012c\u012d\u0005 \u0000\u0000\u012d\u012e\u0005\u001a\u0000\u0000"+
		"\u012e\u012f\u0005\u001f\u0000\u0000\u012f\u0130\u0005\u001b\u0000\u0000"+
		"\u0130;\u0001\u0000\u0000\u0000\u0131\u0132\u0005\u0016\u0000\u0000\u0132"+
		"\u0133\u0005\u0017\u0000\u0000\u0133\u0134\u0005 \u0000\u0000\u0134=\u0001"+
		"\u0000\u0000\u0000\u0015JQdg|\u0081\u0086\u0089\u00aa\u00af\u00b2\u00c3"+
		"\u00ce\u00d2\u00ea\u00ee\u00f1\u0100\u0111\u0121\u0125";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}