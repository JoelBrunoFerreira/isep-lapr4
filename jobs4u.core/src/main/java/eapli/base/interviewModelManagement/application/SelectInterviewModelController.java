package eapli.base.interviewModelManagement.application;

import eapli.base.interviewModelManagement.dto.InterviewModelDTO;
import eapli.base.interviewModelManagement.repository.InterviewModelRepository;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

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
        for (JobOpeningDTO jO : jobOpeningSvc.listJobOpeningsByUser(authz.session().get().authenticatedUser())){
            if ((jO.getStatus().equalsIgnoreCase(Status.ACTIVE.toString()) || jO.getStatus().equalsIgnoreCase(Status.PENDING.toString()) || jO.getStatus().equalsIgnoreCase(Status.ACTIVE_APPLICATION.toString())||jO.getStatus().equalsIgnoreCase(Status.ACTIVE_SCREENING.toString())))
            {
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
