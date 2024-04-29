package eapli.base.customer.domain;

import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
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

    public Customer(final CustomerName name, final Address address, final Acronym acronym, final SystemUser systemUser) {
        Preconditions.nonNull(name);
        Preconditions.nonNull(address);
        Preconditions.nonNull(acronym);
        Preconditions.nonNull(systemUser);
        this.systemUser = systemUser;
    }

    public Customer() {
        // Empty constructor
    }

    @Override
        public boolean sameAs (Object other){
            if (other == null) {
                return false;
            }
            if (!(other instanceof Customer)) {
                return false;
            }
            return id == ((Customer) other).id;
        }

        @Override
        public Long identity () {
            return id;
        }

        @Override
        public CustomerDTO toDTO () {
            return new CustomerDTO(id, name.toString(), acronym.toString(), systemUser.username().toString());
        }

    }

