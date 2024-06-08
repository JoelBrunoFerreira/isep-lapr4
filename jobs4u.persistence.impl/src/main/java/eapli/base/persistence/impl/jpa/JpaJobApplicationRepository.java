package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.candidate.domain.Email;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.jobOpeningManagement.domain.JobReference;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.*;

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
    public Iterable<JobApplication> findApplicationsByJobOpeningApplicationRank(String jobReference) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication jobApplication : findAll()){
            if (jobApplication.hasJobOpeningReference(jobReference)){
                result.add(jobApplication);
            }
        }
        return result;
    }

    @Override
    public Iterable<JobApplicationDTO> findApplicationsDTOByCandidateEmail(String candidateEmail) {
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
        Collections.sort(result);
        return result.reversed();
    }

    @Override
    public Optional<JobApplication> findApplicationByCandidateEmailAndJobReference(String email, String jobReference) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", new Email(email));
        params.put("jobReference", new JobReference(jobReference));
        return matchOne("e.candidate.email = :email AND e.jobOpening.jobReference = :jobReference", params);
    }

    @Override
    public Iterable<JobApplication> findApplicationsByCandidate(String email) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication jobApplication : repo.findAll()){
            if (jobApplication.hasCandidateEmail(email)){
                result.add(jobApplication);
            }
        }
        return result;
    }

    @Override
    public Iterable<JobApplication> findAllApplicationsByJobReference(String jobReference) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication jobApplication : repo.findAll()){
            if (jobApplication.hasJobOpeningReference(jobReference)){
                result.add(jobApplication);
            }
        }
        return result;
    }

    @Override
    public <S extends JobApplication> S save(S entity) {
        return super.save(entity);
    }

}
