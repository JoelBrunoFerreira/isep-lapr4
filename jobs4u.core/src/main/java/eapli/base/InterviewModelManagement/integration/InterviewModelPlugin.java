package eapli.base.InterviewModelManagement.integration;

public interface InterviewModelPlugin {
    InterviewModelResult validateQuestionAnswers(String answers);
    String generateTemplate();
}
