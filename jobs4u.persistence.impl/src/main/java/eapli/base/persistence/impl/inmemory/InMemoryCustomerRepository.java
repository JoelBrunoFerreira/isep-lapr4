package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.domain.Customer;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCustomerRepository extends InMemoryDomainRepository<Customer, Long> implements DomainRepository<Long, Customer> {
    static {
        InMemoryInitializer.init();
    }
}
