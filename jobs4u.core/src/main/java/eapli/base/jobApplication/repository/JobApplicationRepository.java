package eapli.base.jobApplication.repository;


import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface JobApplicationRepository extends DomainRepository<Long, JobApplication> {

    public Iterable<JobApplicationDTO> findApplicationsByJobOpeningReference(String jobReference);
    public Iterable<JobApplication> findApplicationsByJobOpeningApplicationRank(String jobReference);
    public Iterable<JobApplicationDTO> findApplicationsDTOByCandidateEmail(String candidateEmail);
    public Iterable<JobApplicationDTO> getRankedApplicationsByJobReference(String jobReference);
    public Optional<JobApplication> findApplicationByCandidateEmailAndJobReference(String email, String JobReference);
    public Iterable<JobApplication> findApplicationsByCandidate(String email);
    public Iterable<JobApplication> findAllApplicationsByJobReference(String jobReference);
}
