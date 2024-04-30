package eapli.base.JobOpeningManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;

public enum ContractType implements Serializable {
    FULL_TIME("Full-time"),
    PART_TIME("Part-time"),
    INTERNSHIP("Internship");

    private String designation;

    ContractType(final String designation) {
        Preconditions.nonEmpty(designation);
        this.designation = designation;
    }

    public String toString() {
        return designation;
    }
    public static ContractType parse(String contractType) {
        return ContractType.valueOf(contractType.trim().toUpperCase().replace("-", "_"));
    }
}
