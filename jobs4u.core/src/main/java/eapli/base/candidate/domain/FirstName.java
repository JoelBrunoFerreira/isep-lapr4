package eapli.base.candidate.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
public class FirstName implements ValueObject, Serializable {
    private final String firstName;

    public FirstName(final String firstName) {
        Preconditions.nonNull(firstName);
        Preconditions.nonEmpty(firstName);
        this.firstName = firstName;
    }

    protected FirstName() {
        this.firstName = "";
    }

    @Override
    public String toString() {
        return firstName;
    }
}
