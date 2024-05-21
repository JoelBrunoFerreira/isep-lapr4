package eapli.base.jobOpeningManagement.RecruitmentProcessManagement.application;

import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.domain.RecruitmentProcessPhase;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OpenOrClosePhasesController {

    private JobOpening jobOpening;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final SystemUser user;

    public OpenOrClosePhasesController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        user = authz.session().get().authenticatedUser();
    }

    public Iterable<JobOpeningDTO> listJobOpeningsDTO() {

        List<JobOpeningDTO> result = new ArrayList<>();

        for (JobOpeningDTO dto : jobOpeningSvc.listJobOpeningsByManager(user)) {
            if (!(dto.getStatus().equalsIgnoreCase(Status.PENDING.toString()) || dto.getStatus().equalsIgnoreCase(Status.COMPLETED.toString()))) {
                result.add(dto);
            }

        }
        return result;

    }

    public List<RecruitmentProcessPhaseDTO> getRecruitmentProcessDefinedPhases(String jobReference) {
        jobOpening = jobOpeningSvc.getJobOpeningByReference(jobReference).get(); //Gets jobOpening object

        List<RecruitmentProcessPhaseDTO> result = new ArrayList<>();
        for (RecruitmentProcessPhase toDTO : jobOpening.getRecruitmentProcess()) {
            System.out.println(toDTO.toString());
            result.add(toDTO.toDTO());
        }

        return result;
    }

    public void openProcessPhases(String phase, LocalDate openDate) {

        for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
            if (p.getPhase().toString().equalsIgnoreCase(phase)) {
                p.getPeriod().setStartDate(openDate);
                break;
            }
        }
        jobOpening.setStatusByPhaseDates();
        jobOpeningSvc.saveJobOpening(jobOpening);

    }

    public void closeProcessPhases(String phase, LocalDate closeDate) {

        for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
            if (p.equals(phase)) {
                p.getPeriod().setStartDate(closeDate);
                break;
            }
        }
        jobOpening.setStatusByPhaseDates();
        jobOpeningSvc.saveJobOpening(jobOpening);

    }


}
