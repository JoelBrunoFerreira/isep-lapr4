package eapli.base.interviewModelManagement.integration;

public interface InterviewModelPlugin {
    InterviewModelResult validateQuestionAnswers(String answers);
    String generateTemplate();
}
