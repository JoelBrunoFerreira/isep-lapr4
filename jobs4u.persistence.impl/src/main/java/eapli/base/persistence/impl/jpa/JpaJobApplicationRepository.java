package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.JobApplication.domain.JobApplication;
import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.base.JobApplication.repository.JobApplicationRepository;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.JobReference;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Map;

public class JpaJobApplicationRepository extends JpaAutoTxRepository<JobApplication, Long, Long >
        implements JobApplicationRepository {
    public JpaJobApplicationRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaJobApplicationRepository(final String puname) {
        super(puname, Application.settings().extendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<JobApplicationDTO> findApplicationsByJobOpeningId(String jobOpeningId) {
        return null;
    }
}
