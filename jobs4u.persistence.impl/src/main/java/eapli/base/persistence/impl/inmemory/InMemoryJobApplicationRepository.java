package eapli.base.persistence.impl.inmemory;

import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Iterable<JobApplication> findApplicationsByJobOpeningApplicationRank(String jobReference) {
        return null;
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
        return null;
    }

    @Override
    public Optional<JobApplication> findApplicationByCandidateEmailAndJobReference(String email, String JobReference) {
        return Optional.empty();
    }

    @Override
    public Iterable<JobApplication> findApplicationsByCandidate(String email) {
        return null;
    }

    @Override
    public Iterable<JobApplication> findAllApplicationsByJobReference(String jobReference) {
        return null;
    }
}
