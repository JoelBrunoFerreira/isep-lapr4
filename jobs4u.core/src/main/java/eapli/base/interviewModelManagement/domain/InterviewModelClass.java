package eapli.base.interviewModelManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InterviewModelClass implements ValueObject, Serializable {

    private final String className;

    protected InterviewModelClass(){
        this.className =null;
    }
    public InterviewModelClass(final String className){
        Preconditions.nonNull(className);
        Preconditions.nonEmpty(className);
        this.className = className;
    }

    @Override
    public String toString() {
        return className;
    }
}
