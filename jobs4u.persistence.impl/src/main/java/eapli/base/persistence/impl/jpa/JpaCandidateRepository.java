package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JpaCandidateRepository extends JpaAutoTxRepository<Candidate, Long, Long>
        implements CandidateRepository {

    public JpaCandidateRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaCandidateRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

}
