package eapli.base.customer.domain;

import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"code"})})
public class Customer implements AggregateRoot<Long>, DTOable<CustomerDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private CustomerName name;

    //TODO: este código deve ser "curto" e único
    private Acronym acronym;

    @OneToOne
    private SystemUser systemUser;

    public Customer(final String name, final String address, final String acronym, final SystemUser systemUser) {
        this(name, address, acronym);
        Preconditions.nonNull(systemUser);
        this.systemUser = systemUser;
    }

    public Customer(final String name, final String address, final String acronym) {
        Preconditions.nonEmpty(name);
        Preconditions.nonEmpty(address);
        Preconditions.nonEmpty(acronym);
        this.name = new CustomerName(name);
        this.acronym = new Acronym(acronym);
    }

    protected Customer() {
    }

    @Override
    public boolean sameAs(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Customer)) {
            return false;
        }
        return id == ((Customer) other).id;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public CustomerDTO toDTO() {
        return new CustomerDTO(id, name.toString(), acronym.toString(), systemUser.username().toString());
    }
}
