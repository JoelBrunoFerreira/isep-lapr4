package eapli.base.interviewModelManagement.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Column;

import java.io.Serializable;

public class InterviewModelModel implements ValueObject, Serializable {

    @Column(columnDefinition = "TEXT")
    private String model;

    public InterviewModelModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model;
    }
}
