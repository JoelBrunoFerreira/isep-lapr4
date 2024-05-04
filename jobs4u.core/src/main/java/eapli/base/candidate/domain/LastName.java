package eapli.base.candidate.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
public class LastName implements ValueObject, Serializable {
    private final String lastName;

    public LastName(final String lastName) {
        Preconditions.nonNull(lastName);
        Preconditions.nonEmpty(lastName);
        this.lastName = lastName;
    }

    protected LastName() {
        this.lastName = "";
    }

    @Override
    public String toString() {
        return lastName;
    }
}
