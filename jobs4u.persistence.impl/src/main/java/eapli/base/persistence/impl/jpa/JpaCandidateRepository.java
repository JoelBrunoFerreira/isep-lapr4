package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;

public class JpaCandidateRepository
        extends JpaAutoTxRepository<Candidate, Long, Long>
        implements CandidateRepository {

    public JpaCandidateRepository(final TransactionalContext autoTx) {
        super("jobs4uPU", "id");
    }

    public JpaCandidateRepository(final String puname) {
        super(Application.settings().getRepositoryFactory(), "id");
    }

    @Override
    public Optional<Candidate> findByEmail(Email email) {
        return Optional.empty();
    }

    @Override
    public Iterable<Candidate> findAll() {
        return null;
    }
}
