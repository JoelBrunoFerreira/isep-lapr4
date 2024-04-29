package eapli.base.candidate.application;

import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.Optional;

public class GetCandidateController {

    private final CandidateRepository repo = PersistenceContext.repositories().candidates();

    public Optional<Candidate> findByEmail(Email email) {
        Optional<Candidate> candidate = repo.findByEmail(email);
        if(!candidate.isPresent()){
            return Optional.empty();
        }else{
            return Optional.of(candidate.get());
        }
    }

    public Iterable<Candidate> allCandidates(){
        return repo.findAll();
    }
}
