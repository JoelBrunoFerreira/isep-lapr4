package eapli.base.jobOpeningManagement.domain;

import eapli.framework.domain.model.ValueObject;
import java.io.Serializable;
import java.util.Objects;

import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;
import lombok.Value;

@Embeddable
@Value
public class JobReference implements ValueObject, Serializable, Comparable<JobReference> {


    private String id;

    protected JobReference() {
        this.id = "";
    }
    public JobReference(final String id) {
        Preconditions.nonNull(id);
        Preconditions.nonEmpty(id);
        this.id = id;
    }

    public static JobReference valueOf(String jobReference) {
        return new JobReference(jobReference);
    }

    @Override
    public int compareTo(JobReference o) {
        return id.compareTo(o.getId());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobReference that = (JobReference) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
