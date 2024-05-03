package eapli.base.candidate.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
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

    @Override
    public String toString() {
        return phoneNumber;
    }
}
