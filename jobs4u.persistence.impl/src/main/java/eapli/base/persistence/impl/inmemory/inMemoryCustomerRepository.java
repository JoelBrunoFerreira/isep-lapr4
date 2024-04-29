package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.repository.CustomerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class inMemoryCustomerRepository extends InMemoryDomainRepository<Customer, Long> implements CustomerRepository {
    static {
        InMemoryInitializer.init();
    }
}
