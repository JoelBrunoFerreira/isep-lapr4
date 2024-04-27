package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.operator.domain.Operator;
import eapli.base.operator.repository.OperatorRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaOperatorRepository extends JpaAutoTxRepository<Operator, Long, Long>
        implements OperatorRepository {

    public JpaOperatorRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaOperatorRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
