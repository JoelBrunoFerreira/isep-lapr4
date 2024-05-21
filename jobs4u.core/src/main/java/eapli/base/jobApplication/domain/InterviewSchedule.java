package eapli.base.jobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

@Embeddable
public class InterviewSchedule implements ValueObject, Serializable {
    private Calendar interviewDateTime;

    protected InterviewSchedule(){}

    public InterviewSchedule(Calendar interviewDateTime) {
        this.interviewDateTime = interviewDateTime;
    }
}
