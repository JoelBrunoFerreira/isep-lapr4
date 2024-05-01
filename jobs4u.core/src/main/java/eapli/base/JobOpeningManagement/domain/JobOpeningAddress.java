package eapli.base.JobOpeningManagement.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class JobOpeningAddress implements ValueObject, Serializable {
    private String address;

    protected JobOpeningAddress(){}
    public JobOpeningAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.address;
    }
}
