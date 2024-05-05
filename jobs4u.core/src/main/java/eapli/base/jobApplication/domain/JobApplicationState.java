package eapli.base.jobApplication.domain;

import java.io.Serializable;

public enum JobApplicationState implements Serializable {
    RECEIVED("received"),
    INTERVIEWING("interviewing"),
    UNDER_REVIEW("under_review"),
    REJECTED("rejected"),
    ACCEPTED("accepted");
    private String description;
    JobApplicationState(String description) {
        this.description = description;
    }
    public static JobApplicationState parse(String state) {
        return JobApplicationState.valueOf(state.trim().toUpperCase());
    }

    @Override
    public String toString() {
        return description;
    }
}
