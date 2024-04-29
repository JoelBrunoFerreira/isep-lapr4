package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class Name implements ValueObject, Serializable {
    private final String name;

    public Name(final String name) {
        Preconditions.nonEmpty(name);
        this.name = name;
    }

    protected Name() {
        this.name = "";
    }

    @Override
    public String toString() {
        return name;
    }
}
