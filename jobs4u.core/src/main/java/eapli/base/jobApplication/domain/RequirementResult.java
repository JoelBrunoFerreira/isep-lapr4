package eapli.base.jobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
public class RequirementResult implements ValueObject, Serializable {
    @Getter
    private boolean approved;
    private Description justification;
    protected RequirementResult() {
        this.approved = false;
    }
    public RequirementResult(boolean approved, String justification) {
        this.approved = approved;
        this.justification = Description.valueOf(justification);
    }

}
