package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class Address implements ValueObject, Serializable {
    private final String address;

    public Address(final String address) {
        Preconditions.nonEmpty(address);
        this.address = address;
    }

    protected Address() {
        this.address="";
    }

    @Override
    public String toString() {
        return address;
    }
}

