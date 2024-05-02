package eapli.base.RecruitmentProcessManagement.application;

import eapli.base.JobOpeningManagement.application.JobOpeningSvc;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

@UseCaseController
public class SetupRecruitmentProcessController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    public SetupRecruitmentProcessController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
    }

    public Iterable<JobOpeningDTO> listJobOpeningsDTO() {
        return jobOpeningSvc.listJobOpeningsByStatus(Status.PENDING);
    }

    public JobOpening getJO(String jobReference){
        return jobOpeningRepository.findByJobReference(jobReference);
    }
    public List<RecruitmentProcessPhaseDTO> getRecruitmentProcessPhases(String jobReference, boolean withInterview){
        JobOpening jo = jobOpeningRepository.findByJobReference(jobReference);
        return jo.getRecruitmentProcessPhases(withInterview);
    }
}
