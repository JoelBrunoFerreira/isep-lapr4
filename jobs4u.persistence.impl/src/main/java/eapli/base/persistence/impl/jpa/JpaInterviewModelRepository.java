package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.InterviewModelManagement.domain.InterviewModel;
import eapli.base.InterviewModelManagement.dto.InterviewModelDTO;
import eapli.base.InterviewModelManagement.repository.InterviewModelRepository;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.JobReference;
import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JpaInterviewModelRepository extends JpaAutoTxRepository<InterviewModel, Long, Long>
        implements InterviewModelRepository {
    public JpaInterviewModelRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaInterviewModelRepository(final String puname) {
        super(puname, Application.settings().extendedPersistenceProperties(), "id");
    }


    @Override
    public Iterable<InterviewModelDTO> findAllDTOs() {
        List<InterviewModelDTO> result = new ArrayList<>();
        for (InterviewModel iM : findAll()){
            result.add(iM.toDTO());
        }
        return result;
    }
}
