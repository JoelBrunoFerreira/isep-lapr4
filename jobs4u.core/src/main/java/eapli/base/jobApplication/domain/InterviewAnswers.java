package eapli.base.jobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InterviewAnswers implements ValueObject, Serializable {

    @Column(columnDefinition = "TEXT")
    private String modelAnswered;

    protected InterviewAnswers() {
    }

    public InterviewAnswers(String modelAnswered) {
        this.modelAnswered = modelAnswered;
    }

    @Override
    public String toString() {
        return this.modelAnswered;
    }
}
