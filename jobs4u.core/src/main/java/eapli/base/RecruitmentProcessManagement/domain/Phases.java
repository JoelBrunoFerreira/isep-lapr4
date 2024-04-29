package eapli.base.RecruitmentProcessManagement.domain;

import eapli.framework.validations.Preconditions;
import lombok.Getter;

@Getter
public enum Phases {
    APPLICATION("Application"),
    SCREENING("Screening"),
    INTERVIEWS("Interviews"),
    ANALYSIS("Analysis"),
    RESULT("Result");

    private String designation;

    private Phases(final String designation) {
        Preconditions.nonNull(designation);
        Preconditions.nonEmpty(designation);
        this.designation = designation;
    }

}
