package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.languageEngineer.domain.LanguageEngineer;
import eapli.base.languageEngineer.repository.LanguageEngineerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaLanguageEngineerRepository
        extends JpaAutoTxRepository<LanguageEngineer, Long, Long>
        implements LanguageEngineerRepository {

    public JpaLanguageEngineerRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaLanguageEngineerRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}