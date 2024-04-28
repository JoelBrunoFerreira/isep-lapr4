package eapli.base.customer.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Acronym implements ValueObject, Serializable {
    private final String acronym;

    public Acronym(final String acronym) {
        Preconditions.nonEmpty(acronym);
        Preconditions.nonNull(acronym);
        this.acronym = acronym;
    }

    protected Acronym() {
        this.acronym = "";
    }

    @Override
    public String toString() {
        return acronym;
    }
}
