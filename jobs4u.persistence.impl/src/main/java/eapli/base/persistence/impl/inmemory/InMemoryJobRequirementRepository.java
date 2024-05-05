package eapli.base.persistence.impl.inmemory;

import eapli.base.jobRequirementsManagement.domain.JobRequirement;
import eapli.base.jobRequirementsManagement.dto.JobRequirementDTO;
import eapli.base.jobRequirementsManagement.repository.JobRequirementRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryJobRequirementRepository extends InMemoryDomainRepository<JobRequirement, Long> implements JobRequirementRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<JobRequirementDTO> findAllDTOs() {
        return null;
    }
}
