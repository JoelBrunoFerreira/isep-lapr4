package eapli.base.persistence.impl.inmemory;

import eapli.base.JobApplication.domain.JobApplication;
import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.base.JobApplication.repository.JobApplicationRepository;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.JobReference;
import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.lang.reflect.Method;
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
}
