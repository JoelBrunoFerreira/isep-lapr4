package eapli.base.customer.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class CustomerName {
    private final String name;

    public CustomerName(final String name) {
        Preconditions.nonEmpty(name);
        this.name = name;
    }

    protected CustomerName() {
        this.name = "";
    }

    @Override
    public String toString() {
        return name;
    }
}
