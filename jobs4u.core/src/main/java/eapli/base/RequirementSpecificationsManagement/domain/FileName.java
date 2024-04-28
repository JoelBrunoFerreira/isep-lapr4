package eapli.base.RequirementSpecificationsManagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class FileName implements ValueObject, Serializable {
    /**
     * full path of jar file
     */
    private final String jar;

    public FileName(final String jar) {
        Preconditions.nonNull(jar);
        Preconditions.nonEmpty(jar);
        this.jar = jar;
    }

    protected FileName() {
        this.jar = "";
    }
}
