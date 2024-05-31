package eapli.base.interviewModelManagement.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InterviewModelTemplate implements ValueObject, Serializable {

    @Column(columnDefinition = "TEXT")
    private String model; //file in string format

    public InterviewModelTemplate(String model) {
        this.model = model;
    }

    protected InterviewModelTemplate() {

    }

    @Override
    public String toString() {
        return model;
    }
}
