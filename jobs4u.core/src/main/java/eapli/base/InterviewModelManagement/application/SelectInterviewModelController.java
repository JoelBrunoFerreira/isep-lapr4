package eapli.base.InterviewModelManagement.application;

import eapli.base.InterviewModelManagement.domain.InterviewModel;
import eapli.base.InterviewModelManagement.dto.InterviewModelDTO;
import eapli.base.InterviewModelManagement.repository.InterviewModelRepository;
import eapli.base.JobOpeningManagement.application.JobOpeningSvc;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class SelectInterviewModelController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final InterviewModelRepository interviewModelRepository = PersistenceContext.repositories().interviewModelRepository();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();

    public SelectInterviewModelController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
    }

    public Iterable<JobOpeningDTO> getJobOpeningPendingInterviewModel(){
        List<JobOpeningDTO> result = new ArrayList<>();
        for (JobOpeningDTO jO : jobOpeningSvc.listJobOpeningsByManager(authz.session().get().authenticatedUser())){
            if (jO.getInterviewModel().isEmpty()){
                result.add(jO);
            }
        }
        return result;
    }

    public Iterable<InterviewModelDTO> getAllInterviewModelDTOs(){
        return interviewModelRepository.findAllDTOs();
    }

    public JobOpeningDTO updateJobOpeningInterviewModel(String jobReference, InterviewModelDTO interviewModelDTO) {
        JobOpening result = jobOpeningSvc.getJobOpeningByReference(jobReference).get();
        result.updateInterviewModel(interviewModelDTO);
        return jobOpeningSvc.saveJobOpening(result);
    }
}
