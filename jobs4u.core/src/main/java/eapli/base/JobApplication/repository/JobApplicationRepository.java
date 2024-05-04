package eapli.base.JobApplication.repository;


import eapli.base.JobApplication.domain.JobApplication;
import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.framework.domain.repositories.DomainRepository;

public interface JobApplicationRepository extends DomainRepository<Long, JobApplication> {

    public Iterable<JobApplicationDTO> findApplicationsByJobOpeningReference(String jobReference);
    public Iterable<JobApplicationDTO> findApplicationsByJCandidateEmail(String candidateEmail);
}
