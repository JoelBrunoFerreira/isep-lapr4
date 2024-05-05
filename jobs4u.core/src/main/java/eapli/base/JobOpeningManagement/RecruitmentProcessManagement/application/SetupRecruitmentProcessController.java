package eapli.base.JobOpeningManagement.RecruitmentProcessManagement.application;

import eapli.base.JobOpeningManagement.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.base.JobOpeningManagement.application.JobOpeningSvc;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.JobReference;
import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

@UseCaseController
public class SetupRecruitmentProcessController {

    private JobOpening jobOpening;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final SystemUser user;

    public SetupRecruitmentProcessController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        user = authz.session().get().authenticatedUser();
    }

    public Iterable<JobOpeningDTO> listJobOpeningsDTO() {
        return jobOpeningSvc.listJobOpeningsByStatus(Status.PENDING, user);
    }

    public JobOpeningDTO getJO(String jobReference) {
        return jobOpeningRepository.findByJobReference(jobReference);
    }

    public List<RecruitmentProcessPhaseDTO> getRecruitmentProcessPhases(String jobReference, boolean withInterview){
        jobOpening = jobOpeningRepository.ofIdentity(new JobReference(jobReference)).get(); //Gets object
        return jobOpening.getRecruitmentProcessPhases(withInterview);
    }

    public void setRecruitmentProcessPhases(List<RecruitmentProcessPhaseDTO> recruitmentProcessPhasesDTO){

        jobOpening.setupRecruitmentProcessPhases(recruitmentProcessPhasesDTO);
        jobOpeningRepository.save(jobOpening);

    }
}