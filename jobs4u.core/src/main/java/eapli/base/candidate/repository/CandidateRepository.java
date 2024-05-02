package eapli.base.candidate.repository;

import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface CandidateRepository extends DomainRepository<Long, Candidate> {
    public Optional<Candidate> findByEmail(Email email);
}
