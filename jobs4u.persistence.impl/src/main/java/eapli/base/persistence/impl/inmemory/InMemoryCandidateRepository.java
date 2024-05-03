package eapli.base.persistence.impl.inmemory;

import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCandidateRepository extends InMemoryDomainRepository<Candidate, Long> implements CandidateRepository {

    @Override
    public Optional<Candidate> findByEmail(Email email) {
        return Optional.empty();
    }

    @Override
    public Iterable<CandidateDTO> findAllDTO() {
        List<CandidateDTO> result = new ArrayList<>();
        for (Candidate candidate : findAll()){
            result.add(candidate.toDTO());
        }
        return result;
    }
}
