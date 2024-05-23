
package interviewModelQuestions;
// Generated from C:/Users/fabio/OneDrive/Documentos/ISEP_LEI/2o ANO/2º S/LPROG/TRABALHO_PRÁTICO/Exemplo_ANTLR/Questions/LabeledExpr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LabeledExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LabeledExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(LabeledExprParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(LabeledExprParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#true_false}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false(LabeledExprParser.True_falseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#bool_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_solution(LabeledExprParser.Bool_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#short_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_text(LabeledExprParser.Short_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#short_text_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_text_solution(LabeledExprParser.Short_text_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#case_sensitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_sensitive(LabeledExprParser.Case_sensitiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#single_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_choice(LabeledExprParser.Single_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#subquestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquestion(LabeledExprParser.SubquestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(LabeledExprParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#matching_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_solution(LabeledExprParser.Matching_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#match}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatch(LabeledExprParser.MatchContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#multiple_choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice(LabeledExprParser.Multiple_choiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#numerical_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_solution(LabeledExprParser.Numerical_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#combinations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCombinations(LabeledExprParser.CombinationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#choice_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice_type(LabeledExprParser.Choice_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#integer_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_number(LabeledExprParser.Integer_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#integer_number_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_number_solution(LabeledExprParser.Integer_number_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#decimal_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal_number(LabeledExprParser.Decimal_numberContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(LabeledExprParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#feedback_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback_text(LabeledExprParser.Feedback_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#feedback_combination}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback_combination(LabeledExprParser.Feedback_combinationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#wrong_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrong_answer(LabeledExprParser.Wrong_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#correct_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorrect_answer(LabeledExprParser.Correct_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(LabeledExprParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#date_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_solution(LabeledExprParser.Date_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(LabeledExprParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#time_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_solution(LabeledExprParser.Time_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#numeric_scale}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_scale(LabeledExprParser.Numeric_scaleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#numeric_scale_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_scale_solution(LabeledExprParser.Numeric_scale_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LabeledExprParser#error}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitError(LabeledExprParser.ErrorContext ctx);
}