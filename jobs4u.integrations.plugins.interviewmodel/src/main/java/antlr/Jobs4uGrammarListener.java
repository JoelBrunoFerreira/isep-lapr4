// Generated from C:/Users/fabio/Downloads/antlr/Jobs4uGrammar.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Jobs4uGrammarParser}.
 */
public interface Jobs4uGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(Jobs4uGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(Jobs4uGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#model}.
	 * @param ctx the parse tree
	 */
	void enterModel(Jobs4uGrammarParser.ModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#model}.
	 * @param ctx the parse tree
	 */
	void exitModel(Jobs4uGrammarParser.ModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(Jobs4uGrammarParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(Jobs4uGrammarParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(Jobs4uGrammarParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(Jobs4uGrammarParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(Jobs4uGrammarParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(Jobs4uGrammarParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#grade}.
	 * @param ctx the parse tree
	 */
	void enterGrade(Jobs4uGrammarParser.GradeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#grade}.
	 * @param ctx the parse tree
	 */
	void exitGrade(Jobs4uGrammarParser.GradeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#format}.
	 * @param ctx the parse tree
	 */
	void enterFormat(Jobs4uGrammarParser.FormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#format}.
	 * @param ctx the parse tree
	 */
	void exitFormat(Jobs4uGrammarParser.FormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#boolean_answer}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_answer(Jobs4uGrammarParser.Boolean_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#boolean_answer}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_answer(Jobs4uGrammarParser.Boolean_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#short_text_answer}.
	 * @param ctx the parse tree
	 */
	void enterShort_text_answer(Jobs4uGrammarParser.Short_text_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#short_text_answer}.
	 * @param ctx the parse tree
	 */
	void exitShort_text_answer(Jobs4uGrammarParser.Short_text_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#choice_single_answer}.
	 * @param ctx the parse tree
	 */
	void enterChoice_single_answer(Jobs4uGrammarParser.Choice_single_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#choice_single_answer}.
	 * @param ctx the parse tree
	 */
	void exitChoice_single_answer(Jobs4uGrammarParser.Choice_single_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#choice_multiple_answer}.
	 * @param ctx the parse tree
	 */
	void enterChoice_multiple_answer(Jobs4uGrammarParser.Choice_multiple_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#choice_multiple_answer}.
	 * @param ctx the parse tree
	 */
	void exitChoice_multiple_answer(Jobs4uGrammarParser.Choice_multiple_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#integer_answer}.
	 * @param ctx the parse tree
	 */
	void enterInteger_answer(Jobs4uGrammarParser.Integer_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#integer_answer}.
	 * @param ctx the parse tree
	 */
	void exitInteger_answer(Jobs4uGrammarParser.Integer_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#decimal_answer}.
	 * @param ctx the parse tree
	 */
	void enterDecimal_answer(Jobs4uGrammarParser.Decimal_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#decimal_answer}.
	 * @param ctx the parse tree
	 */
	void exitDecimal_answer(Jobs4uGrammarParser.Decimal_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#date_answer}.
	 * @param ctx the parse tree
	 */
	void enterDate_answer(Jobs4uGrammarParser.Date_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#date_answer}.
	 * @param ctx the parse tree
	 */
	void exitDate_answer(Jobs4uGrammarParser.Date_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#time_answer}.
	 * @param ctx the parse tree
	 */
	void enterTime_answer(Jobs4uGrammarParser.Time_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#time_answer}.
	 * @param ctx the parse tree
	 */
	void exitTime_answer(Jobs4uGrammarParser.Time_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#integer_scale_answer}.
	 * @param ctx the parse tree
	 */
	void enterInteger_scale_answer(Jobs4uGrammarParser.Integer_scale_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#integer_scale_answer}.
	 * @param ctx the parse tree
	 */
	void exitInteger_scale_answer(Jobs4uGrammarParser.Integer_scale_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#format_conf_choice_single_answer}.
	 * @param ctx the parse tree
	 */
	void enterFormat_conf_choice_single_answer(Jobs4uGrammarParser.Format_conf_choice_single_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#format_conf_choice_single_answer}.
	 * @param ctx the parse tree
	 */
	void exitFormat_conf_choice_single_answer(Jobs4uGrammarParser.Format_conf_choice_single_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#format_conf_choice_multiple_answer}.
	 * @param ctx the parse tree
	 */
	void enterFormat_conf_choice_multiple_answer(Jobs4uGrammarParser.Format_conf_choice_multiple_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#format_conf_choice_multiple_answer}.
	 * @param ctx the parse tree
	 */
	void exitFormat_conf_choice_multiple_answer(Jobs4uGrammarParser.Format_conf_choice_multiple_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#format_answer_choice_multiple_answer}.
	 * @param ctx the parse tree
	 */
	void enterFormat_answer_choice_multiple_answer(Jobs4uGrammarParser.Format_answer_choice_multiple_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#format_answer_choice_multiple_answer}.
	 * @param ctx the parse tree
	 */
	void exitFormat_answer_choice_multiple_answer(Jobs4uGrammarParser.Format_answer_choice_multiple_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jobs4uGrammarParser#format_answer_choice_multiple_answer_option}.
	 * @param ctx the parse tree
	 */
	void enterFormat_answer_choice_multiple_answer_option(Jobs4uGrammarParser.Format_answer_choice_multiple_answer_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jobs4uGrammarParser#format_answer_choice_multiple_answer_option}.
	 * @param ctx the parse tree
	 */
	void exitFormat_answer_choice_multiple_answer_option(Jobs4uGrammarParser.Format_answer_choice_multiple_answer_optionContext ctx);
}