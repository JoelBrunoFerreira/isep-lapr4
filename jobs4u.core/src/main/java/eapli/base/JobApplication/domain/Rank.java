package eapli.base.JobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Rank implements ValueObject, Serializable {
    private final int rank;

    public Rank(final int rank) {
        Preconditions.nonNegative(rank);
        this.rank = rank;
    }

    public int valueOf() {
        return rank;
    }

    protected Rank() {
        this.rank = 0;
    }

    @Override
    public String toString() {
        return String.valueOf(rank);
    }
}
