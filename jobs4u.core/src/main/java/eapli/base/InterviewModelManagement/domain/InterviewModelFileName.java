package eapli.base.InterviewModelManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class InterviewModelFileName implements ValueObject, Serializable {

    private final String fileName;

    protected InterviewModelFileName(){
        this.fileName=null;
    }
    public InterviewModelFileName(final String fileName){
        Preconditions.nonNull(fileName);
        Preconditions.nonEmpty(fileName);
        this.fileName=fileName;
    }
}
