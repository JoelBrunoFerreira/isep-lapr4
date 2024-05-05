package eapli.base.jobRequirementsManagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobRequirementTitle implements ValueObject, Serializable {
    private final String name;

    public JobRequirementTitle(final String name) {
        Preconditions.nonEmpty(name);
        this.name = name;
    }

    protected JobRequirementTitle() {
        this.name = "";
    }

    @Override
    public String toString() {
        return name;
    }
}
