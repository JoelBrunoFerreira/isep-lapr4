package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.customerManager.domain.CustomerManager;
import eapli.base.customerManager.repository.CustomerManagerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCustomerManagerRepository
        extends JpaAutoTxRepository<CustomerManager, Long, Long>
        implements CustomerManagerRepository {

    public JpaCustomerManagerRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaCustomerManagerRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
