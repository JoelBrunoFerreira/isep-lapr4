package eapli.base.jobRequirementsManagement.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class JobRequirementTemplate implements ValueObject, Serializable {
    @Column(columnDefinition = "TEXT")
    private String model; //file in string format

    protected JobRequirementTemplate() {
    }

    public JobRequirementTemplate(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return this.model;
    }
}