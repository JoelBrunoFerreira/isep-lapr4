// Generated from C:/Users/fabio/Downloads/antlr/Jobs4uGrammar.g4 by ANTLR 4.13.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Jobs4uGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Jobs4uGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(Jobs4uGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(Jobs4uGrammarParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(Jobs4uGrammarParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(Jobs4uGrammarParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(Jobs4uGrammarParser.AnswerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrade(Jobs4uGrammarParser.GradeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#format}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat(Jobs4uGrammarParser.FormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#boolean_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_answer(Jobs4uGrammarParser.Boolean_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#short_text_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_text_answer(Jobs4uGrammarParser.Short_text_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#choice_single_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice_single_answer(Jobs4uGrammarParser.Choice_single_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#choice_multiple_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice_multiple_answer(Jobs4uGrammarParser.Choice_multiple_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#integer_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_answer(Jobs4uGrammarParser.Integer_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#decimal_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimal_answer(Jobs4uGrammarParser.Decimal_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#date_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_answer(Jobs4uGrammarParser.Date_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#time_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime_answer(Jobs4uGrammarParser.Time_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#integer_scale_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger_scale_answer(Jobs4uGrammarParser.Integer_scale_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#format_conf_choice_single_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat_conf_choice_single_answer(Jobs4uGrammarParser.Format_conf_choice_single_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#format_conf_choice_multiple_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat_conf_choice_multiple_answer(Jobs4uGrammarParser.Format_conf_choice_multiple_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#format_answer_choice_multiple_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat_answer_choice_multiple_answer(Jobs4uGrammarParser.Format_answer_choice_multiple_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jobs4uGrammarParser#format_answer_choice_multiple_answer_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat_answer_choice_multiple_answer_option(Jobs4uGrammarParser.Format_answer_choice_multiple_answer_optionContext ctx);
}