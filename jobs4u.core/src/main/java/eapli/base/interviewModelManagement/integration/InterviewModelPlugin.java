package eapli.base.interviewModelManagement.integration;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InterviewModelPlugin {
    String generateTemplate(String model);

    InterviewModelResult validateQuestionAnswers(String model,String answers) throws IOException;
}
