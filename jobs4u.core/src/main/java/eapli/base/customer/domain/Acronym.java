package eapli.base.customer.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
public class Acronym implements ValueObject, Serializable {
    private final String acronym;

    public Acronym(final String acronym) {
        Preconditions.nonEmpty(acronym);
        Preconditions.nonNull(acronym);
        this.acronym = acronym;
    }

    protected Acronym() {
        this.acronym = "";
    }

    @Override
    public String toString() {
        return acronym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acronym acronym1 = (Acronym) o;
        return Objects.equals(acronym, acronym1.acronym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acronym);
    }
}
