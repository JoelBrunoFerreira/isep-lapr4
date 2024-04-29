package eapli.base.JobOpeningManagement.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class NumberVacancies {
    private int numberVacancies;

    protected NumberVacancies() {
        this.numberVacancies = 0;
    }
    public NumberVacancies(final int numberVacancies) {
        Preconditions.isPositive(numberVacancies);
        this.numberVacancies = numberVacancies;
    }

}
