package eapli.base.JobOpeningManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

public enum ContractType {
    FULL_TIME("Full-time"),
    PART_TIME("Part-time"),
    INTERN("Internship");

    private String designation;

    ContractType(final String designation) {
        Preconditions.nonEmpty(designation);
        this.designation = designation;
    }

    public static ContractType parse(String mode) {
        return ContractType.valueOf(mode.trim().toUpperCase());
    }

    public String toString() {
        return designation;
    }
}
