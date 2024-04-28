package eapli.base.JobOpeningManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import java.util.Objects;

public enum WorkingMode {
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