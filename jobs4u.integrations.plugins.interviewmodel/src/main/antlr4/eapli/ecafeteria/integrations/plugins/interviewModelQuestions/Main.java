package interviewModelQuestions;

import eapli.base.interviewModelManagement.integration.InterviewModelPlugin;
import eapli.base.interviewModelManagement.integration.InterviewModelResult;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main /*implements InterviewModelPlugin*/ {

/*        @Override
        public InterviewModelResult validateQuestionAnswers(String answers) throws IOException {

            //Create other visitor to get answers

            FileInputStream fis = new FileInputStream(new File("model.txt"));
            LabeledExprLexer lexer = new LabeledExprLexer(new ANTLRInputStream(fis));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LabeledExprParser parser = new LabeledExprParser(tokens);
            ParseTree tree = parser.start(); // parse, se não funcionar, retorna false ou null
            EvalVisitor eval = new EvalVisitor();
            eval.visit(tree);

            return null;
        }

        @Override
        public String generateTemplate() *//*throws IOException*//* {

        //visitor to get questions

//        FileInputStream fis = new FileInputStream(new File("model.txt"));
//        LabeledExprLexer lexer = new LabeledExprLexer(new ANTLRInputStream(fis));
        //        LabeledExprLexer lexer = new LabeledExprLexer(new ANTLRInputStream(string do model));
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        LabeledExprParser parser = new LabeledExprParser(tokens);
//        ParseTree tree = parser.start(); // parse, se não funcionar, retorna false ou null
//        EvalVisitor eval = new EvalVisitor();
//        eval.visit(tree);



        return "FUNCIONA";
    }

    @Override
    public InterviewModelResult validateQuestionAnswers(String answers) throws IOException {
        return null;
    }

    @Override
    public String generateTemplate(String model) {
        return "";
    }
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("model.txt"));
        LabeledExprLexer lexer = new LabeledExprLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.start(); // parse, se não funcionar, retorna false ou null
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }*/
}