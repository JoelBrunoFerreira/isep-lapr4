package eapli.base.jobRequirementsManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.interviewModelManagement.dto.InterviewModelDTO;
import eapli.base.interviewModelManagement.repository.InterviewModelRepository;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.jobRequirementsManagement.dto.JobRequirementDTO;
import eapli.base.jobRequirementsManagement.repository.JobRequirementRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class SelectJobRequirementController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobRequirementRepository repository = PersistenceContext.repositories().jobRequirements();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();

    public SelectJobRequirementController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
    }
    public Iterable<JobOpeningDTO> getJobOpeningPendingJobRequirements(){
        List<JobOpeningDTO> result = new ArrayList<>();
        for (JobOpeningDTO jO : jobOpeningSvc.listJobOpeningsByManager(authz.session().get().authenticatedUser())){
            if (jO.getJobRequirement().isEmpty() ){
                result.add(jO);
            }
        }
        return result;
    }

    public Iterable<JobRequirementDTO> getAllJobRequirementDTOs(){
        return repository.findAllDTOs();
    }

    public JobOpeningDTO updateJobOpeningJobRequirement(String jobReference, JobRequirementDTO jobRequirementDTO) {
        JobOpening result = jobOpeningSvc.getJobOpeningByReference(jobReference).get();
        result.updateJobRequirement(jobRequirementDTO);
        return jobOpeningSvc.saveJobOpening(result);
    }
}
