package eapli.base.interviewModelManagement.repository;

import eapli.base.interviewModelManagement.domain.InterviewModel;
import eapli.base.interviewModelManagement.dto.InterviewModelDTO;
import eapli.framework.domain.repositories.DomainRepository;

public interface InterviewModelRepository extends DomainRepository<Long, InterviewModel> {
    Iterable<InterviewModelDTO> findAllDTOs();
}
