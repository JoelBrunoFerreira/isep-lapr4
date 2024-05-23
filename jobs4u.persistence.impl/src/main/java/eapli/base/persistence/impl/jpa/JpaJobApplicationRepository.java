package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JpaJobApplicationRepository extends JpaAutoTxRepository<JobApplication, Long, Long >
        implements JobApplicationRepository{
    public JpaJobApplicationRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaJobApplicationRepository(final String puname) {
        super(puname, Application.settings().extendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<JobApplicationDTO> findApplicationsByJobOpeningReference(String jobReference) {
        List<JobApplicationDTO> result = new ArrayList<>();
        for (JobApplication jobApplication : findAll()){
            if (jobApplication.hasJobOpeningReference(jobReference)){
                result.add(jobApplication.toDTO());
            }
        }
        return result;
    }

    @Override
    public Iterable<JobApplicationDTO> findApplicationsByJCandidateEmail(String candidateEmail) {
        List<JobApplicationDTO> result = new ArrayList<>();
        for (JobApplication jobApplication : findAll()){
            if (jobApplication.hasCandidateEmail(candidateEmail)){
                result.add(jobApplication.toDTO());
            }
        }
        return result;
    }

    @Override
    public Iterable<JobApplicationDTO> getRankedApplicationsByJobReference(String jobReference) {
        List<JobApplicationDTO> result = new ArrayList<>();
        for (JobApplicationDTO dto : this.findApplicationsByJobOpeningReference(jobReference)){
            if (dto.isApproved()){
                result.add(dto);
            }
        }
        Collections.sort(result.reversed());
        return result;
    }

    @Override
    public <S extends JobApplication> S save(S entity) {
        return super.save(entity);
    }

}
