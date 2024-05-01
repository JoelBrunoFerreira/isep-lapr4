package eapli.base.customer.domain;

import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"acronym"})})
public class Customer implements AggregateRoot<Long>, DTOable<CustomerDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private CustomerName name;

    private Acronym acronym;

    private Address address;

    @OneToOne
    private SystemUser systemUser;

    protected Customer() {
        // Empty constructor
    }

    public Customer(SystemUser systemUser, String address) {
        Preconditions.nonNull(systemUser);
        Preconditions.nonEmpty(address);
        this.systemUser = systemUser;
        this.name = new CustomerName(systemUser.name().firstName());
        this.acronym = new Acronym(systemUser.name().lastName().toString());
        this.address = new Address(address);
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
        return new CustomerDTO(name.toString(), acronym.toString(), systemUser.email().toString(), address.toString());
    }

}

