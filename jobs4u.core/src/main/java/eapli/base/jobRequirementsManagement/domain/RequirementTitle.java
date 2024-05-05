package eapli.base.jobRequirementsManagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class RequirementTitle implements ValueObject, Serializable {
    private final String name;

    public RequirementTitle(final String name) {
        Preconditions.nonNull(name);
        Preconditions.nonEmpty(name);
        this.name = name;
    }

    protected RequirementTitle() {
        this.name = "";
    }

    @Override
    public String toString() {
        return name;
    }
}
