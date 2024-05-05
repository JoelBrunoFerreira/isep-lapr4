package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.interviewModelManagement.domain.InterviewModel;
import eapli.base.interviewModelManagement.dto.InterviewModelDTO;
import eapli.base.interviewModelManagement.repository.InterviewModelRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

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
