package eapli.base.InterviewModelManagement.repository;

import eapli.base.InterviewModelManagement.domain.InterviewModel;
import eapli.base.InterviewModelManagement.dto.InterviewModelDTO;
import eapli.framework.domain.repositories.DomainRepository;

public interface InterviewModelRepository extends DomainRepository<Long, InterviewModel> {
    Iterable<InterviewModelDTO> findAllDTOs();
}
