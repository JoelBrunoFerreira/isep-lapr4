package eapli.base.interviewModelManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InterviewModelClass implements ValueObject, Serializable {

    private final String fileName;

    protected InterviewModelClass(){
        this.fileName=null;
    }
    public InterviewModelClass(final String fileName){
        Preconditions.nonNull(fileName);
        Preconditions.nonEmpty(fileName);
        this.fileName=fileName;
    }

    @Override
    public String toString() {
        return fileName;
    }
}
