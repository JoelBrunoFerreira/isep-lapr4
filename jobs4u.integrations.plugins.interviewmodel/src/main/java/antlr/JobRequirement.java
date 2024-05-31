package antlr;


import eapli.base.jobRequirementsManagement.integration.JobRequirementPlugin;
import eapli.base.jobRequirementsManagement.integration.JobRequirementResult;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class JobRequirement implements JobRequirementPlugin {
    Jobs4uVisitor generateTemplateVisitor = new Jobs4uVisitor();

    @Override
    public JobRequirementResult validateRequirements(String model, String requirements) {
        return null;
    }

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
            ParseTree tree = parser.start();//parser.start(); // parse
            generateTemplateVisitor.visit(tree);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return generateTemplateVisitor.generateTemplate();
    }
}
