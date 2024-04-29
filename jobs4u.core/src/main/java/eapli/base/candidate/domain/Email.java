package eapli.base.candidate.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class Email implements ValueObject, Serializable {
    private final String email;

    public Email(final String email) {
        Preconditions.nonNull(email);
        Preconditions.nonEmpty(email);
        this.email = email;
    }

    protected Email() {
        this.email = "";
    }

    @Override
    public String toString() {
        return email;
    }
}
