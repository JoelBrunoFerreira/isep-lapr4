package eapli.base.jobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InterviewResult implements ValueObject, Serializable {
    private final float grade;

    protected InterviewResult() {
        this.grade = 0;
    }
    public InterviewResult(final float grade) {
        this.grade = grade;
    }

    public InterviewResult valueOf(float grade) {
        return new InterviewResult(grade);
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.valueOf(grade);
    }
}
