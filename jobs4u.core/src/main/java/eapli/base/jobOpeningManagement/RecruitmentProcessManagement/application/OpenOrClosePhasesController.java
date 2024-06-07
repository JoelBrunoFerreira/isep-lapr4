package eapli.base.jobOpeningManagement.RecruitmentProcessManagement.application;

import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.domain.RecruitmentProcessPhase;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobApplication.application.StatusChangeSvc;
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

import static eapli.base.jobOpeningManagement.RecruitmentProcessManagement.domain.Phase.*;
import static eapli.base.jobOpeningManagement.domain.Status.ACTIVE;

public class OpenOrClosePhasesController {

    private JobOpening jobOpening;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final SystemUser user;
    private final StatusChangeSvc statusChangeSvc;


    public OpenOrClosePhasesController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        user = authz.session().get().authenticatedUser();
        statusChangeSvc = new StatusChangeSvc();
    }

    public Iterable<JobOpeningDTO> listJobOpeningsDTO() {

        List<JobOpeningDTO> result = new ArrayList<>();

        for (JobOpeningDTO dto : jobOpeningSvc.listJobOpeningsByUser(user)) {
            if (!(dto.getStatus().equalsIgnoreCase(Status.PENDING.toString())
                    || dto.getStatus().equalsIgnoreCase(Status.COMPLETED.toString()))) {
                result.add(dto);
            }

        }
        return result;

    }


    public String jobOpeningStatus(String jobReference) {
        jobOpening = jobOpeningSvc.getJobOpeningByReference(jobReference).get(); //Gets jobOpening object
        return jobOpening.toDTO().getStatus().toUpperCase();
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


    public void returnToPreviousProcessPhase(String selectedPhase, LocalDate openDate) {

        String previousPhase = null;

        if (jobOpening.hasInterviewModel()) {
            for (RecruitmentProcessPhase processPhaseToChange : jobOpening.getRecruitmentProcess()) {

                if (selectedPhase.equalsIgnoreCase(APPLICATION.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    previousPhase = ACTIVE.getDescription();
                    setPreviousPhaseProcessStatus(openDate, processPhaseToChange, previousPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(SCREENING.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    previousPhase = APPLICATION.getDesignation();
                    setPreviousPhaseProcessStatus(openDate, processPhaseToChange, previousPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(INTERVIEWS.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    previousPhase = SCREENING.getDesignation();
                    setPreviousPhaseProcessStatus(openDate, processPhaseToChange, previousPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(ANALYSIS.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    previousPhase = INTERVIEWS.getDesignation();
                    setPreviousPhaseProcessStatus(openDate, processPhaseToChange, previousPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(RESULT.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    previousPhase = ANALYSIS.getDesignation();
                    setPreviousPhaseProcessStatus(openDate, processPhaseToChange, previousPhase);
                    break;
                }
            }
        } else {
            for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {

                if (selectedPhase.equalsIgnoreCase(APPLICATION.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    previousPhase = ACTIVE.getDescription();
                    setPreviousPhaseProcessStatus(openDate, p, previousPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(SCREENING.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    previousPhase = APPLICATION.getDesignation();
                    setPreviousPhaseProcessStatus(openDate, p, previousPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(ANALYSIS.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    previousPhase = SCREENING.getDesignation();
                    setPreviousPhaseProcessStatus(openDate, p, previousPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(RESULT.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    previousPhase = ANALYSIS.getDesignation();
                    setPreviousPhaseProcessStatus(openDate, p, previousPhase);
                    break;
                }
            }
        }
    }


    public void moveToNextProcessPhase(String selectedPhase, LocalDate closeDate) {
        boolean interviewPhase = false;
        String nextPhase = null;
        boolean completeStatus = false;
        boolean activeStatus = false;
        int counter = 0;

        for (RecruitmentProcessPhase processPhase : jobOpening.getRecruitmentProcess()) {

            if (processPhase.getPhase().toString().equalsIgnoreCase(INTERVIEWS.toString())) {
                interviewPhase = true;
                break;
            }
        }


        if (jobOpening.hasInterviewModel() && interviewPhase) {
            for (RecruitmentProcessPhase processPhaseToChange : jobOpening.getRecruitmentProcess()) {

                if (selectedPhase.equalsIgnoreCase(ACTIVE.toString())) {
                    nextPhase = APPLICATION.getDesignation();
                    startApplicationPhase(closeDate, nextPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(APPLICATION.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextPhase = SCREENING.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, processPhaseToChange, nextPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(SCREENING.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextPhase = INTERVIEWS.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, processPhaseToChange, nextPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(INTERVIEWS.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextPhase = ANALYSIS.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, processPhaseToChange, nextPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(ANALYSIS.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextPhase = RESULT.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, processPhaseToChange, nextPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(RESULT.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(RESULT.getDesignation())) {
                    nextPhase = Status.COMPLETED.toString();
                    setNextPhaseStartDateAndProcessStatus(closeDate, processPhaseToChange, nextPhase);
                    break;
                }
            }
        } else {
            for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {

                if (selectedPhase.equalsIgnoreCase(ACTIVE.toString())) {
                    nextPhase = APPLICATION.getDesignation();
                    startApplicationPhase(closeDate, nextPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(APPLICATION.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextPhase = SCREENING.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, p, nextPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(SCREENING.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextPhase = ANALYSIS.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, p, nextPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(ANALYSIS.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextPhase = RESULT.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, p, nextPhase);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(RESULT.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(RESULT.getDesignation())) {
                    nextPhase = Status.COMPLETED.toString();
                    setNextPhaseStartDateAndProcessStatus(closeDate, p, nextPhase);
                    break;
                }
            }
        }

    }


    private void setNextPhaseStartDateAndProcessStatus(LocalDate closeDate, RecruitmentProcessPhase processPhaseToChange, String nextPhase) {

        if (nextPhase.equalsIgnoreCase(Status.COMPLETED.toString())) {
            for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
                if (p.getPhase().toString().equalsIgnoreCase(processPhaseToChange.getPhase().toString())) {
                    processPhaseToChange.getPeriod().setEndDate(closeDate);
                    break;
                }
            }
        }else{
            for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
                if (p.getPhase().toString().equalsIgnoreCase(nextPhase)) {
                    processPhaseToChange.getPeriod().setEndDate(closeDate);
                    p.getPeriod().setStartDate(closeDate);
                    break;
                }
        }


        }
        jobOpening.setStatusByMovingForwardPhase(nextPhase);
        jobOpeningSvc.saveJobOpening(jobOpening);
    }


    private void setPreviousPhaseProcessStatus(LocalDate closeDate, RecruitmentProcessPhase processPhaseToChange, String previousPhase) {
        processPhaseToChange.getPeriod().setEndDate(closeDate);
        for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
            if (p.getPhase().toString().equalsIgnoreCase(previousPhase)) {
                p.getPeriod().setStartDate(closeDate);
                break;
            }
        }
        jobOpening.setStatusByMovingtoPreviousPhase(previousPhase);
        jobOpeningSvc.saveJobOpening(jobOpening);
    }


    private void startApplicationPhase(LocalDate startDate, String nextPhase) {

        for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
            if (p.getPhase().toString().equalsIgnoreCase(nextPhase)) {
                p.getPeriod().setStartDate(startDate);
                break;
            }
        }
        jobOpening.setStatusByMovingForwardPhase(nextPhase);
        statusChangeSvc.changeJobApplicationStatus(jobOpening.getJobReference().toString(),nextPhase);
        jobOpeningSvc.saveJobOpening(jobOpening);
    }


}


