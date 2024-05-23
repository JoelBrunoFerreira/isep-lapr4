package eapli.base.persistence.impl.inmemory;

import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryJobApplicationRepository extends InMemoryDomainRepository<JobApplication, Long> implements JobApplicationRepository {
    static {
        InMemoryInitializer.init();
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
        return null;
    }
}
