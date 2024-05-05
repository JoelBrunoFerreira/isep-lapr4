package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.jobRequirementsManagement.domain.JobRequirement;
import eapli.base.jobRequirementsManagement.dto.JobRequirementDTO;
import eapli.base.jobRequirementsManagement.repository.JobRequirementRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.ArrayList;
import java.util.List;


public class JpaJobRequirementRepository extends JpaAutoTxRepository<JobRequirement, Long, Long>
        implements JobRequirementRepository {
    public JpaJobRequirementRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaJobRequirementRepository(final String puname) {
        super(puname, Application.settings().extendedPersistenceProperties(), "id");
    }

    @Override
    public Iterable<JobRequirementDTO> findAllDTOs() {
        List<JobRequirementDTO> result = new ArrayList<>();
        for (JobRequirement jR : findAll()){
            result.add(jR.toDTO());
        }
        return result;
    }
}

