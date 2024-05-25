package eapli.base.jobOpeningManagement.repositories;

import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.JobReference;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public interface JobOpeningRepository extends DomainRepository<JobReference, JobOpening> {
    Iterable<JobOpeningDTO> findAllDTO();
    Iterable<JobOpeningDTO> findAllByCustomerID(String email, SystemUser user);

    Iterable<JobOpeningDTO> findAllByStatus(Status status, SystemUser user);

    JobOpeningDTO findByJobReference(String jobReference);

    Iterable<JobOpeningDTO> findAllByUser(SystemUser user);
    JobOpeningDTO updateJobOpening(JobOpeningDTO dto);
}