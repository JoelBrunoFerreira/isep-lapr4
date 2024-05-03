package eapli.base.JobOpeningManagement.repositories;

import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.JobReference;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDate;

public interface JobOpeningRepository extends DomainRepository<JobReference, JobOpening> {
    Iterable<JobOpeningDTO> findAllByUser(SystemUser user);
    Iterable<JobOpeningDTO> findAllDTO();
    Iterable<JobOpeningDTO> findAllByCustomerID(String email, SystemUser user);

    Iterable<JobOpeningDTO> findAllByStatus(Status status, SystemUser user);

    JobOpeningDTO findByJobReference(String jobReference);
}