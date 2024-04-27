package eapli.base.customerManager.domain;

import eapli.base.customerManager.dto.CustomerManagerDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.DTOable;
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
