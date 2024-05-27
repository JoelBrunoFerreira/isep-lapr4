package interviewModelQuestions;
// Generated from C:/Users/fabio/OneDrive/Documentos/ISEP_LEI/2o ANO/2º S/LPROG/TRABALHO_PRÁTICO/Exemplo_ANTLR/Questions/LabeledExpr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LabeledExprParser}.
 */
public interface LabeledExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(LabeledExprParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(LabeledExprParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(LabeledExprParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(LabeledExprParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#true_false}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false(LabeledExprParser.True_falseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#true_false}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false(LabeledExprParser.True_falseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#bool_solution}.
	 * @param ctx the parse tree
	 */
	void enterBool_solution(LabeledExprParser.Bool_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#bool_solution}.
	 * @param ctx the parse tree
	 */
	void exitBool_solution(LabeledExprParser.Bool_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#short_text}.
	 * @param ctx the parse tree
	 */
	void enterShort_text(LabeledExprParser.Short_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#short_text}.
	 * @param ctx the parse tree
	 */
	void exitShort_text(LabeledExprParser.Short_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#short_text_solution}.
	 * @param ctx the parse tree
	 */
	void enterShort_text_solution(LabeledExprParser.Short_text_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#short_text_solution}.
	 * @param ctx the parse tree
	 */
	void exitShort_text_solution(LabeledExprParser.Short_text_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#case_sensitive}.
	 * @param ctx the parse tree
	 */
	void enterCase_sensitive(LabeledExprParser.Case_sensitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#case_sensitive}.
	 * @param ctx the parse tree
	 */
	void exitCase_sensitive(LabeledExprParser.Case_sensitiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#single_choice}.
	 * @param ctx the parse tree
	 */
	void enterSingle_choice(LabeledExprParser.Single_choiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#single_choice}.
	 * @param ctx the parse tree
	 */
	void exitSingle_choice(LabeledExprParser.Single_choiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#subquestion}.
	 * @param ctx the parse tree
	 */
	void enterSubquestion(LabeledExprParser.SubquestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#subquestion}.
	 * @param ctx the parse tree
	 */
	void exitSubquestion(LabeledExprParser.SubquestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(LabeledExprParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(LabeledExprParser.AnswerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#matching_solution}.
	 * @param ctx the parse tree
	 */
	void enterMatching_solution(LabeledExprParser.Matching_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#matching_solution}.
	 * @param ctx the parse tree
	 */
	void exitMatching_solution(LabeledExprParser.Matching_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#match}.
	 * @param ctx the parse tree
	 */
	void enterMatch(LabeledExprParser.MatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#match}.
	 * @param ctx the parse tree
	 */
	void exitMatch(LabeledExprParser.MatchContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#multiple_choice}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice(LabeledExprParser.Multiple_choiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#multiple_choice}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice(LabeledExprParser.Multiple_choiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#numerical_solution}.
	 * @param ctx the parse tree
	 */
	void enterNumerical_solution(LabeledExprParser.Numerical_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#numerical_solution}.
	 * @param ctx the parse tree
	 */
	void exitNumerical_solution(LabeledExprParser.Numerical_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#combinations}.
	 * @param ctx the parse tree
	 */
	void enterCombinations(LabeledExprParser.CombinationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#combinations}.
	 * @param ctx the parse tree
	 */
	void exitCombinations(LabeledExprParser.CombinationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#choice_type}.
	 * @param ctx the parse tree
	 */
	void enterChoice_type(LabeledExprParser.Choice_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#choice_type}.
	 * @param ctx the parse tree
	 */
	void exitChoice_type(LabeledExprParser.Choice_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#integer_number}.
	 * @param ctx the parse tree
	 */
	void enterInteger_number(LabeledExprParser.Integer_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#integer_number}.
	 * @param ctx the parse tree
	 */
	void exitInteger_number(LabeledExprParser.Integer_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#integer_number_solution}.
	 * @param ctx the parse tree
	 */
	void enterInteger_number_solution(LabeledExprParser.Integer_number_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#integer_number_solution}.
	 * @param ctx the parse tree
	 */
	void exitInteger_number_solution(LabeledExprParser.Integer_number_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#decimal_number}.
	 * @param ctx the parse tree
	 */
	void enterDecimal_number(LabeledExprParser.Decimal_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#decimal_number}.
	 * @param ctx the parse tree
	 */
	void exitDecimal_number(LabeledExprParser.Decimal_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(LabeledExprParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(LabeledExprParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#feedback_text}.
	 * @param ctx the parse tree
	 */
	void enterFeedback_text(LabeledExprParser.Feedback_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#feedback_text}.
	 * @param ctx the parse tree
	 */
	void exitFeedback_text(LabeledExprParser.Feedback_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#feedback_combination}.
	 * @param ctx the parse tree
	 */
	void enterFeedback_combination(LabeledExprParser.Feedback_combinationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#feedback_combination}.
	 * @param ctx the parse tree
	 */
	void exitFeedback_combination(LabeledExprParser.Feedback_combinationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#wrong_answer}.
	 * @param ctx the parse tree
	 */
	void enterWrong_answer(LabeledExprParser.Wrong_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#wrong_answer}.
	 * @param ctx the parse tree
	 */
	void exitWrong_answer(LabeledExprParser.Wrong_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#correct_answer}.
	 * @param ctx the parse tree
	 */
	void enterCorrect_answer(LabeledExprParser.Correct_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#correct_answer}.
	 * @param ctx the parse tree
	 */
	void exitCorrect_answer(LabeledExprParser.Correct_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(LabeledExprParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(LabeledExprParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#date_solution}.
	 * @param ctx the parse tree
	 */
	void enterDate_solution(LabeledExprParser.Date_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#date_solution}.
	 * @param ctx the parse tree
	 */
	void exitDate_solution(LabeledExprParser.Date_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(LabeledExprParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(LabeledExprParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#time_solution}.
	 * @param ctx the parse tree
	 */
	void enterTime_solution(LabeledExprParser.Time_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#time_solution}.
	 * @param ctx the parse tree
	 */
	void exitTime_solution(LabeledExprParser.Time_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#numeric_scale}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_scale(LabeledExprParser.Numeric_scaleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#numeric_scale}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_scale(LabeledExprParser.Numeric_scaleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#numeric_scale_solution}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_scale_solution(LabeledExprParser.Numeric_scale_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#numeric_scale_solution}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_scale_solution(LabeledExprParser.Numeric_scale_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LabeledExprParser#error}.
	 * @param ctx the parse tree
	 */
	void enterError(LabeledExprParser.ErrorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LabeledExprParser#error}.
	 * @param ctx the parse tree
	 */
	void exitError(LabeledExprParser.ErrorContext ctx);
}