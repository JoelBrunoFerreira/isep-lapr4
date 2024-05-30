package antlr;

import eapli.base.interviewModelManagement.integration.InterviewModelPlugin;
import eapli.base.interviewModelManagement.integration.InterviewModelResult;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

public class InterviewModel implements InterviewModelPlugin {
    Jobs4uVisitor generateTemplateVisitor = new Jobs4uVisitor();


    @Override
    public String generateTemplate(String model) {
        Reader r;
        FileInputStream fis;
        try {
            fis = new FileInputStream(model);
            r = new InputStreamReader(fis, "UTF-8");
            Jobs4uGrammarLexer lexer = new Jobs4uGrammarLexer(new ANTLRInputStream(r));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Jobs4uGrammarParser parser = new Jobs4uGrammarParser(tokens);
            ParseTree tree = parser.start();
            generateTemplateVisitor.visit(tree);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        return generateTemplateVisitor.generateTemplate();
    }

    @Override
    public InterviewModelResult validateQuestionAnswers(String model, String answers) throws IOException {
        return null;
    }


}
