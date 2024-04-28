package eapli.base.JobOpeningManagement.domain;

import eapli.framework.domain.model.ValueObject;
import java.io.Serializable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import lombok.Value;

@Embeddable
@Value
public class JobReference implements ValueObject, Serializable, Comparable<JobReference> {
    //TODO: o JobReference tem que ser um composto do code do cliente mais um número sequencial
    private String id;

    public JobReference(final String id) {
        Preconditions.nonNull(id);
        Preconditions.nonEmpty(id);
        this.id = id;
    }

    protected JobReference() {
        this.id = "";
    }

    @Override
    public int compareTo(JobReference o) {
        return id.compareTo(o.getId());
    }

    public boolean equals(JobReference o) {
        return id.equals(o.getId());
    }
}
