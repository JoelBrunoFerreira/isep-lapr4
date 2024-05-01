package eapli.base.JobOpeningManagement.domain;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class JobTitle {
    private String title;
    protected JobTitle() {
        this.title = "";
    }
    public JobTitle(final String title) {
        Preconditions.nonNull(title);
        Preconditions.nonEmpty(title);
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
