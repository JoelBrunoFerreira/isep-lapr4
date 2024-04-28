package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.framework.domain.repositories.TransactionalContext;

public class JpaCandidateRepository extends eapli.framework.infrastructure.repositories.impl.jpa.JpaTransactionalRepository<Candidate, Long, Long>
        implements CandidateRepository {

    public JpaCandidateRepository(final TransactionalContext autoTx) {
        super("jobs4uPU", "id");
    }

    public JpaCandidateRepository(final String puname) {
        super(Application.settings().getRepositoryFactory(), "id");
    }
}
