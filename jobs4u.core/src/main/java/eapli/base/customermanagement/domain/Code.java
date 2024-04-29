package eapli.base.customermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class Code implements ValueObject, Serializable {
    private final String code;

    public Code(final String code) {
        Preconditions.nonEmpty(code);
        this.code = code;
    }

    protected Code() {
        this.code = "";
    }

    public static Code valueOf(String code) {
        return new Code(code);
    }

    @Override
    public String toString() {
        return code;
    }
}
