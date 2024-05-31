package eapli.base.jobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InterviewResult implements ValueObject, Serializable {
    private final int grade;

    protected InterviewResult() {
        this.grade = 0;
    }
    public InterviewResult(final int grade) {
        Preconditions.nonNegative(grade);
        this.grade = grade;
    }

    public InterviewResult valueOf(int grade) {
        return new InterviewResult(grade);
    }

    @Override
    public String toString() {
        return String.valueOf(grade);
    }
}
