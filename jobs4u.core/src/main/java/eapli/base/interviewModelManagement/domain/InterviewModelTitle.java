package eapli.base.interviewModelManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InterviewModelTitle implements ValueObject, Serializable {
    private final String title;
    protected InterviewModelTitle(){
        this.title=null;
    }
    public InterviewModelTitle(final String title){
        Preconditions.nonEmpty(title);
        Preconditions.nonNull(title);
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
