package antlr;

public class Jobs4uVisitor extends Jobs4uGrammarBaseVisitor<String> {
    private final StringBuilder template= new StringBuilder();

    @Override
    public String visitStart(Jobs4uGrammarParser.StartContext ctx) {
        return visitModel(ctx.model());
    }

    @Override
    public String visitModel(Jobs4uGrammarParser.ModelContext ctx) {
        for (Jobs4uGrammarParser.QuestionContext question : ctx.question()) {
            visit(question);
        }
        return template.toString(); //visitChildren(ctx);
    }

    @Override
    public String visitQuestion(Jobs4uGrammarParser.QuestionContext ctx) {

        String title = visitTitle(ctx.title(0));
        String answer = visitAnswer(ctx.answer(0));

        buildQuestion(title,answer);
        return "";
    }

    public String visitAnswer(Jobs4uGrammarParser.AnswerContext ctx) {
        return ctx.QUOTE_STRING().getText().replaceAll("\"", "");
    }

    @Override
    public String visitTitle(Jobs4uGrammarParser.TitleContext ctx) {
        return ctx.QUOTE_STRING().getText().replaceAll("\"", "");
    }
    private void buildQuestion(String title, String question){
        template.append("# ").append(title).append("\n");
        template.append("# ").append(question).append("\n\n");
    }
    public String generateTemplate(){
        return template.toString();
    }
}
