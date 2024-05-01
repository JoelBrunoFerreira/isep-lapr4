package eapli.base.customerManager.domain;

import eapli.base.customer.domain.Acronym;
import eapli.base.customer.domain.Address;
import eapli.base.customer.domain.CustomerName;
import eapli.base.customerManager.dto.CustomerManagerDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class CustomerManager implements AggregateRoot<Long>, DTOable<CustomerManagerDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Name name;
    @OneToOne
    private SystemUser systemUser;

    protected CustomerManager() {
        // Empty constructor
    }

    public CustomerManager(SystemUser systemUser, String fName, String lName) {
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
        if (!(other instanceof CustomerManager)) {
            return false;
        }
        return id == ((CustomerManager) other).id;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public CustomerManagerDTO toDTO() {
        return new CustomerManagerDTO(id, name.toString());
    }

}
