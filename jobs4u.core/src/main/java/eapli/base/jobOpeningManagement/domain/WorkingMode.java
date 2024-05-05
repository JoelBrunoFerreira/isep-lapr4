package eapli.base.jobOpeningManagement.domain;

import eapli.framework.validations.Preconditions;

import java.io.Serializable;

public enum WorkingMode implements Serializable {
    ONSITE("onsite"),
    REMOTE("remote"),
    HYBRID("hybrid");

    private String designation;

    WorkingMode(final String designation) {
        Preconditions.nonEmpty(designation);
        this.designation = designation;
    }

    public static WorkingMode parse(String mode) {
        return WorkingMode.valueOf(mode.trim().toUpperCase());
    }

    public String toString() {
        return designation;
    }


}