package eapli.base.interviewModelManagement.integration;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface InterviewModelPlugin {
    String generateTemplate(String path);

    InterviewModelResult evaluateInterviewModel(String path);
}
