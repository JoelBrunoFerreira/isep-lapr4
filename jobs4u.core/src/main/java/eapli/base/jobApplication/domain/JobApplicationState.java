package eapli.base.jobApplication.domain;

import java.io.Serializable;

public enum JobApplicationState implements Serializable {
    RECEIVED("received"), //Application phase
    SCREENING("screening"), //Screening phase
    INTERVIEWING("interviewing"), //Interview phase
    REJECTED("rejected"), //post Screening or Analysis phase

    ANALYSIS("analysis"), //Analysis phase
    RESULT("result"), //post Screening or Analysis phase
    ACCEPTED("accepted"), //Result phase
    FINALIZED("finalized");
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
