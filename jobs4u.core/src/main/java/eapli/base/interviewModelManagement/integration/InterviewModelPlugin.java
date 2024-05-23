package eapli.base.interviewModelManagement.integration;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InterviewModelPlugin {
    InterviewModelResult validateQuestionAnswers(String answers) throws IOException;
    String generateTemplate();
}
