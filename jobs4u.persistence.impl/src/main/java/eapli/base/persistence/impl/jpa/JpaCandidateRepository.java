package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class JpaCandidateRepository
        extends JpaAutoTxRepository<Candidate, Long, Long>
        implements CandidateRepository {


    public JpaCandidateRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaCandidateRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public Optional<Candidate> findByEmail(Email email) {
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return matchOne("e.email=:email", params);
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
