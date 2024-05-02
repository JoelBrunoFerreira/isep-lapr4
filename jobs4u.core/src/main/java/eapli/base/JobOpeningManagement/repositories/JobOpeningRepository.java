package eapli.base.JobOpeningManagement.repositories;

import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.JobReference;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.domain.repositories.DomainRepository;

import java.time.LocalDate;

public interface JobOpeningRepository extends DomainRepository<JobReference, JobOpening> {
    Iterable<JobOpeningDTO> findAllDTO();

    Iterable<JobOpening> findAllActive(LocalDate startDate, LocalDate endDate);

    Iterable<JobOpeningDTO> findAllByCustomerIDAndDate(long customerID, LocalDate startDate, LocalDate endDate);

    Iterable<JobOpeningDTO> findAllByCustomerID(String email);

    Iterable<JobOpeningDTO> findAllByStatus(Status status);

    JobOpening findByJobReference(String jobReference);
}