package eapli.base.JobOpeningManagement.repositories;

import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.JobReference;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.domain.repositories.DomainRepository;

public interface JobOpeningRepository extends DomainRepository<JobReference, JobOpening> {

    public Iterable<JobOpeningDTO> findAllDTO();
}