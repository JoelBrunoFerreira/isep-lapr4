package eapli.base.persistence.impl.inmemory;

import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCandidateRepository extends InMemoryDomainRepository<Candidate, Long> implements CandidateRepository {

}
