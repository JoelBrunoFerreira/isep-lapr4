package eapli.base.operator.domain;

import eapli.base.operator.dto.OperatorDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Operator implements AggregateRoot<Long>, DTOable<OperatorDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Name name;
    @OneToOne
    private SystemUser systemUser;

    protected Operator() {
        // Empty constructor
    }

    public Operator(SystemUser systemUser, String fName, String lName) {
        Preconditions.nonNull(systemUser);
        Preconditions.nonEmpty(fName);
        Preconditions.nonEmpty(lName);
        this.systemUser = systemUser;
        this.name = new Name(systemUser.name().firstName()+ " " + systemUser.name().lastName());
    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Operator)) {
            return false;
        }
        return id == ((Operator) other).id;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public OperatorDTO toDTO() {
        return new OperatorDTO(id, name.toString());
    }
}
