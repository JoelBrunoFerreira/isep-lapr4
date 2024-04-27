package eapli.base.JobOpeningManagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class JobOpeningAddress implements ValueObject, Serializable {
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public JobOpeningAddress(String streetAddress, String city, String state, String postalCode, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    // toString method to print address details
    @Override
    public String toString() {
        return streetAddress + ", " + city + ", " + state + " " + postalCode + ", " + country;
    }
}
