package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.domain.Customer;
import eapli.base.languageEngineer.domain.LanguageEngineer;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryLanguageEngineerRepository extends InMemoryDomainRepository<LanguageEngineer, Long>
        implements DomainRepository<Long, LanguageEngineer> {
    static {
        InMemoryInitializer.init();
    }
}