package eapli.base.jobApplication.domain;

import java.io.Serializable;

public enum JobApplicationState implements Serializable {
    RECEIVED("received"), //Application phase
    UNDER_REVIEW("under_review"), //Screening phase
    INTERVIEWING("interviewing"), //Interview phase
    REJECTED("rejected"), //post Screening or Analysis phase
    ACCEPTED("accepted"); //Result phase
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
