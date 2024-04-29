package eapli.base.persistence.impl.inmemory;

import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCandidateRepository extends InMemoryDomainRepository<Candidate, Long> implements CandidateRepository {

    static{
        InMemoryInitializer.init();
    }
    @Override
    public Iterable<Candidate> findAll() {
        return match(e -> e.user().roleTypes().contains(BaseRoles.CANDIDATE_USER));
    }

    @Override
    public Optional<Candidate> findByEmail(Email email) {
        return matchOne(e -> e.user().email().equals(email) && e.user().roleTypes().contains(BaseRoles.CANDIDATE_USER));
    }
}
