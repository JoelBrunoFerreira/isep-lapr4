package eapli.base.jobApplication.repository;


import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface JobApplicationRepository extends DomainRepository<Long, JobApplication> {

    public Iterable<JobApplicationDTO> findApplicationsByJobOpeningReference(String jobReference);
    public Iterable<JobApplicationDTO> findApplicationsByJCandidateEmail(String candidateEmail);
    public Optional<JobApplicationDTO> findApplicationByEmailAndJobReference(String candidateEmail, String JobReference);
}
