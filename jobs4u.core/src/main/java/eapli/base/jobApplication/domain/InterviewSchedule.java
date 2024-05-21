package eapli.base.jobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class InterviewSchedule implements ValueObject, Serializable {
    private LocalDateTime interviewDateTime;

    protected InterviewSchedule(){}

    public InterviewSchedule(LocalDateTime interviewDateTime) {
        this.interviewDateTime = interviewDateTime;
    }
}
