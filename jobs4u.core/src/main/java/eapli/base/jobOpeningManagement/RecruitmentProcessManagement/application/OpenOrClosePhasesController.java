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
import eapli.framework.presentation.console.SelectWidget;

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

        for (JobOpeningDTO dto : jobOpeningSvc.listJobOpeningsByUser(user)) {
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
//            System.out.println(toDTO.toString());
            result.add(toDTO.toDTO());
        }

        return result;
    }

    public void openProcessPhases(String phase, LocalDate openDate) {


//        List<RecruitmentProcessPhase> phaseList = jobOpening.getRecruitmentProcess();
//        Iterable<RecruitmentProcessPhase> recruitmentProcessPhases = jobOpening.getRecruitmentProcess();
//        if (!recruitmentProcessPhases.iterator().hasNext()) {
//            System.out.println("No job openings for this user.");
//
//        } else {
//
//        }

        String nextPhase = null;

        if (phase.equalsIgnoreCase("APPLICATION")) {
            nextPhase = "SCREENING";
        } else if (phase.equalsIgnoreCase("SCREENING")) {
            nextPhase = "SCREENING";
        }

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

        String nextPhase = null;

        if (jobOpening.hasInterviewModel()) {
            for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {

                if (p.getPhase().toString().equalsIgnoreCase("APPLICATION")) {
                    nextPhase = "SCREENING";
                    continue;
                }
                if (p.getPhase().toString().equalsIgnoreCase("SCREENING")) {
                    nextPhase = "INTERVIEWS";
                    continue;
                }
                if (p.getPhase().toString().equalsIgnoreCase("INTERVIEWS")) {
                    nextPhase = "ANALYSIS";
                    continue;
                }
                if (p.getPhase().toString().equalsIgnoreCase("ANALYSIS")) {
                    nextPhase = "RESULT";
                    continue;
                }
                if (p.getPhase().toString().equalsIgnoreCase("RESULT")) {
                    nextPhase = null;
                }
            }
        } else {
            for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {

                if (p.getPhase().toString().equalsIgnoreCase("APPLICATION")) {
                    nextPhase = "SCREENING";
                    continue;
                }
                if (p.getPhase().toString().equalsIgnoreCase("SCREENING")) {
                    nextPhase = "ANALYSIS";
                    continue;
                }
                if (p.getPhase().toString().equalsIgnoreCase("ANALYSIS")) {
                    nextPhase = "RESULT";
                    continue;
                }
                if (p.getPhase().toString().equalsIgnoreCase("RESULT")) {
                    nextPhase = null;
                }
            }
        }

        for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
            if (p.getPhase().toString().equalsIgnoreCase(phase)) {
                p.getPeriod().setEndDate(closeDate); //fecha fase atual na data definida

                for (RecruitmentProcessPhase p2 : jobOpening.getRecruitmentProcess()) {
                    if (p2.getPhase().toString().equalsIgnoreCase(nextPhase)) {
                        p2.getPeriod().setStartDate(closeDate); //abre fase seguinte na mesma data
                    }

                    break;
                }
            }
            jobOpening.setStatusByPhaseDates();
            jobOpeningSvc.saveJobOpening(jobOpening);
        }
    }


//    public void setApplicationPhase(String phase) {
//        for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
//            if (p.getPhase().toString().equalsIgnoreCase(phase)) {
//                openProcessPhases(phase, LocalDate.now());
////               p.getPeriod().setStartDate(openDate);
//                break;
//            }
//        }
//    }
//
//
//    public void setScreeningPhase(String phase) {
//        for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
//            if (p.getPhase().toString().equalsIgnoreCase(phase)) {
////               p.getPeriod().setStartDate(openDate);
//                break;
//            }
//        }
//    }
}


