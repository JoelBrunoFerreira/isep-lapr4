package eapli.base.JobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class State implements ValueObject, Serializable {
    //TODO: enum?
    private final String state;

    public State(final String state) {
        Preconditions.nonNull(state);
        Preconditions.nonEmpty(state);
        this.state = state;
    }

    protected State() {
        this.state = "";
    }
}
