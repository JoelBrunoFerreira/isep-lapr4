package eapli.base.customer.repository;

import eapli.base.customer.domain.Customer;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

public interface CustomerRepository extends DomainRepository<Long, Customer> {


    Optional<Customer> findByUsername(Username name);
    /**
     *
     * @return
     */
    Iterable<Customer> findAllActive();
}
