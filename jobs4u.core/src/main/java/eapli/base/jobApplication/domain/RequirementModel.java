package eapli.base.jobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RequirementModel implements ValueObject, Serializable {
    @Column(columnDefinition = "TEXT")
    private String model;

    protected RequirementModel() {
    }

    public RequirementModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
