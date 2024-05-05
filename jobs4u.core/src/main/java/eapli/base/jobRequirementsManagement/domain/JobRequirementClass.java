package eapli.base.jobRequirementsManagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobRequirementClass implements ValueObject, Serializable {

    private String className;

    public JobRequirementClass(String name) {
        Preconditions.nonEmpty(name);
        this.className = name;
    }

    protected JobRequirementClass() {
        this.className = null;
    }

    @Override
    public String toString() {
        return className;
    }
}
