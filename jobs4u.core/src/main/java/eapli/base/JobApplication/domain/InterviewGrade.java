package eapli.base.JobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InterviewGrade implements ValueObject, Serializable {
    private final int grade;

    protected InterviewGrade() {
        this.grade = 0;
    }
    public InterviewGrade(final int grade) {
        Preconditions.nonNegative(grade);
        this.grade = grade;
    }

    public InterviewGrade valueOf(int grade) {
        return new InterviewGrade(grade);
    }

    @Override
    public String toString() {
        return String.valueOf(grade);
    }
}
