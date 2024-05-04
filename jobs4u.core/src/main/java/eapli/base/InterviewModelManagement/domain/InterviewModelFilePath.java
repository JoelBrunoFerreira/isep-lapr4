package eapli.base.InterviewModelManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InterviewModelFilePath implements ValueObject, Serializable {

    private final String fileName;

    protected InterviewModelFilePath(){
        this.fileName=null;
    }
    public InterviewModelFilePath(final String fileName){
        Preconditions.nonNull(fileName);
        Preconditions.nonEmpty(fileName);
        this.fileName=fileName;
    }
}
