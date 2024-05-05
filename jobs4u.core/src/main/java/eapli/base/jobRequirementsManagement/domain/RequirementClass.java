package eapli.base.jobRequirementsManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class RequirementClass implements ValueObject, Serializable {

    private final String className;

    protected RequirementClass(){
        this.className=null;
    }
    public RequirementClass(final String className){
        Preconditions.nonNull(className);
        Preconditions.nonEmpty(className);
        this.className=className;
    }

    @Override
    public String toString() {
        return className;
    }
}
