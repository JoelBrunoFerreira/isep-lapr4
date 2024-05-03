package eapli.base.RecruitmentProcessManagement.domain;

import eapli.framework.validations.Preconditions;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter

public enum Phase implements Serializable {
    APPLICATION("Application"),
    SCREENING("Screening"),
    INTERVIEWS("Interviews"),
    ANALYSIS("Analysis"),
    RESULT("Result");

    private String designation;

    private Phase(final String designation) {
        Preconditions.nonNull(designation);
        Preconditions.nonEmpty(designation);
        this.designation = designation;
    }
    public static Phase parse(String phase) {
        return Phase.valueOf(phase.trim().toUpperCase());
    }

    @Override
    public String toString() {
        return designation;
    }
}
