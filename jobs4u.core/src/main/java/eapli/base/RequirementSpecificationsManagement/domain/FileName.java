package eapli.base.RequirementSpecificationsManagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class FileName implements ValueObject, Serializable {

    private final String fileName;

    public FileName(final String jar) {
        Preconditions.nonNull(jar);
        Preconditions.nonEmpty(jar);
        this.fileName = jar;
    }

    protected FileName() {
        this.fileName = null;
    }

    @Override
    public String toString() {
        return fileName;
    }
}
