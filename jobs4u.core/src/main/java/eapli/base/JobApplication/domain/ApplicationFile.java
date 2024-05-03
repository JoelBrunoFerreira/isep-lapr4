package eapli.base.JobApplication.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ApplicationFile implements ValueObject, Serializable {
    private final String path;

    public ApplicationFile(final String path) {
        Preconditions.nonEmpty(path);
        this.path = path;
    }

    protected ApplicationFile() {
        this.path = "";
    }

    public ApplicationFile valueOf(String path) {
        return new ApplicationFile(path);
    }

    @Override
    public String toString() {
        return path;
    }
}
