package eapli.base.customer.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
@Embeddable
public class Address implements ValueObject, Serializable {
    private String address;

    protected Address(){}

    public Address(String address) {
        Preconditions.nonEmpty(address);
        this.address = address;
    }
}
