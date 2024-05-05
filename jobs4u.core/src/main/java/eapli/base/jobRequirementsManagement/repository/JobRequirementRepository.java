package eapli.base.jobRequirementsManagement.repository;


import eapli.base.interviewModelManagement.dto.InterviewModelDTO;
import eapli.base.jobRequirementsManagement.domain.JobRequirement;
import eapli.base.jobRequirementsManagement.dto.JobRequirementDTO;
import eapli.framework.domain.repositories.DomainRepository;

public interface JobRequirementRepository extends DomainRepository<Long, JobRequirement> {
    Iterable<JobRequirementDTO> findAllDTOs();
}
