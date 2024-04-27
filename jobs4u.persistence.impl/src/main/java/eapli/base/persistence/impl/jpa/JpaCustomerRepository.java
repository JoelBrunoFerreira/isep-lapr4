package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.repository.CustomerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCustomerRepository extends JpaAutoTxRepository<Customer, Long, Long>
        implements CustomerRepository {

    public JpaCustomerRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaCustomerRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
