package eapli.base.interviewModelManagement.integration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterviewModelResult {
    private boolean valid;
    private String errorMessage;
    private float grade;

    protected InterviewModelResult() {
    }

    public InterviewModelResult(boolean valid, String errorMessage, float grade) {
        this.valid = valid;
        this.errorMessage = errorMessage;
        this.grade = grade;
    }

}
