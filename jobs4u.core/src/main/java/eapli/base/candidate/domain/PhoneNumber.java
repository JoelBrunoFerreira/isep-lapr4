package eapli.base.candidate.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PhoneNumber implements ValueObject, Serializable {
    private final String phoneNumber;

    public PhoneNumber(final String phoneNumber) {
        Preconditions.nonNull(phoneNumber);
        Preconditions.nonEmpty(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    protected PhoneNumber() {
        this.phoneNumber = "";
    }
}
