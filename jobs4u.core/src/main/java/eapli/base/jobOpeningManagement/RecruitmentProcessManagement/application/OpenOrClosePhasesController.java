package eapli.base.jobOpeningManagement.RecruitmentProcessManagement.application;

import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.domain.Phase;
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
import static eapli.base.jobOpeningManagement.domain.Status.*;

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
            if (!(dto.getStatus().equalsIgnoreCase(PENDING.toString())
                    || dto.getStatus().equalsIgnoreCase(COMPLETED.toString()))) {
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


    public void moveToNextProcessPhase(LocalDate closeDate) {
        boolean interviewPhase = jobOpening.getRecruitmentProcess().size() == 5;
        String nextState = null;
        String nextPhase = null;
        Status currentStatus = jobOpening.getStatus();
        String currentPhase;

        if (jobOpening.hasInterviewModel() && interviewPhase) {

            switch (currentStatus) {
                case ACTIVE:
                    nextState = ACTIVE_APPLICATION.toString();
                    nextPhase = APPLICATION.toString();
                    startApplicationPhase(closeDate, nextPhase, nextState); //porque não existe data anterior para fechar
                    break;
                case ACTIVE_APPLICATION:
                    currentPhase = APPLICATION.toString();
                    nextState = ACTIVE_SCREENING.toString();
                    nextPhase = SCREENING.toString();
                    setNextPhaseStartDateAndProcessStatus2(closeDate, currentPhase, nextPhase, nextState);
                    break;
                case ACTIVE_SCREENING:
                    currentPhase = SCREENING.toString();
                    nextState = ACTIVE_INTERVIEWS.toString();
                    nextPhase = INTERVIEWS.toString();
                    setNextPhaseStartDateAndProcessStatus2(closeDate, currentPhase, nextPhase, nextState);
                    break;
                case ACTIVE_INTERVIEWS:
                    currentPhase = INTERVIEWS.toString();
                    nextState = ACTIVE_ANALYSIS.toString();
                    nextPhase = ANALYSIS.toString();
                    setNextPhaseStartDateAndProcessStatus2(closeDate, currentPhase, nextPhase, nextState);
                    break;
                case ACTIVE_ANALYSIS:
                    currentPhase = ACTIVE.toString();
                    nextState = ACTIVE_RESULT.toString();
                    nextPhase = RESULT.toString();
                    setNextPhaseStartDateAndProcessStatus2(closeDate, currentPhase, nextPhase, nextState);
                    break;
                case ACTIVE_RESULT:
                    currentPhase = RESULT.toString();
                    nextState = COMPLETED.toString();
                    nextPhase = "";
                    setNextPhaseStartDateAndProcessStatus2(closeDate, currentPhase, nextPhase, nextState);
                    break;
            }
        } else {

            switch (currentStatus) {
                case ACTIVE:
                    nextState = ACTIVE_APPLICATION.toString();
                    nextPhase = APPLICATION.toString();
                    startApplicationPhase(closeDate, nextPhase, nextState); //porque não existe data anterior para fechar
                    break;
                case ACTIVE_APPLICATION:
                    currentPhase = APPLICATION.toString();
                    nextState = ACTIVE_SCREENING.toString();
                    nextPhase = SCREENING.toString();
                    setNextPhaseStartDateAndProcessStatus2(closeDate, currentPhase, nextPhase, nextState);
                    break;
                case ACTIVE_SCREENING:
                    currentPhase = SCREENING.toString();
                    nextState = ACTIVE_ANALYSIS.toString();
                    nextPhase = ANALYSIS.toString();
                    setNextPhaseStartDateAndProcessStatus2(closeDate, currentPhase, nextPhase, nextState);
                    break;
                case ACTIVE_ANALYSIS:
                    currentPhase = ACTIVE.toString();
                    nextState = ACTIVE_RESULT.toString();
                    nextPhase = RESULT.toString();
                    setNextPhaseStartDateAndProcessStatus2(closeDate, currentPhase, nextPhase, nextState);
                    break;
                case ACTIVE_RESULT:
                    currentPhase = RESULT.toString();
                    nextState = COMPLETED.toString();
                    nextPhase = "";
                    setNextPhaseStartDateAndProcessStatus2(closeDate, currentPhase, nextPhase, nextState);
                    break;
            }

            /*for (RecruitmentProcessPhase processPhaseToChange : jobOpening.getRecruitmentProcess()) {

                if (selectedPhase.equalsIgnoreCase(ACTIVE.toString())) {
                    nextState = APPLICATION.getDesignation();
                    startApplicationPhase(closeDate, nextState);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(APPLICATION.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextState = SCREENING.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, processPhaseToChange, nextState);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(SCREENING.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextState = INTERVIEWS.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, processPhaseToChange, nextState);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(INTERVIEWS.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextState = ANALYSIS.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, processPhaseToChange, nextState);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(ANALYSIS.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextState = RESULT.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, processPhaseToChange, nextState);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(RESULT.getDesignation())
                        && processPhaseToChange.getPhase().toString().equalsIgnoreCase(RESULT.getDesignation())) {
                    nextState = Status.COMPLETED.toString();
                    setNextPhaseStartDateAndProcessStatus(closeDate, processPhaseToChange, nextState);
                    break;
                }
            }
        } else{
            for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {

                if (selectedPhase.equalsIgnoreCase(ACTIVE.toString())) {
                    nextState = APPLICATION.getDesignation();
                    startApplicationPhase(closeDate, nextState);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(APPLICATION.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextState = SCREENING.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, p, nextState);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(SCREENING.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextState = ANALYSIS.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, p, nextState);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(ANALYSIS.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(selectedPhase)) {
                    nextState = RESULT.getDesignation();
                    setNextPhaseStartDateAndProcessStatus(closeDate, p, nextState);
                    break;
                }
                if (selectedPhase.equalsIgnoreCase(RESULT.getDesignation())
                        && p.getPhase().toString().equalsIgnoreCase(RESULT.getDesignation())) {
                    nextState = Status.COMPLETED.toString();
                    setNextPhaseStartDateAndProcessStatus(closeDate, p, nextState);
                    break;
                }
            }*/
        }


    }


    private void setNextPhaseStartDateAndProcessStatus(LocalDate closeDate, RecruitmentProcessPhase processPhaseToChange, String nextPhase) {


        if (nextPhase.equalsIgnoreCase(COMPLETED.toString())) {
            for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
                if (p.getPhase().toString().equalsIgnoreCase(processPhaseToChange.getPhase().toString())) {
                    processPhaseToChange.getPeriod().setEndDate(closeDate);
                    break;
                }
            }
        } else {
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


    private void setNextPhaseStartDateAndProcessStatus2(LocalDate closeDate, String processPhaseToChange, String nextPhase, String nextState) {


        for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
            if (nextPhase.equalsIgnoreCase(COMPLETED.toString()) && p.getPhase().toString().equalsIgnoreCase(processPhaseToChange)) {
                p.getPeriod().setEndDate(closeDate); // definir data de fim da fase que foi fechada, neste caso foi completada, logo não há seguinte de inicio
                break;
            }
            if (p.getPhase().toString().equalsIgnoreCase(processPhaseToChange)) {
                p.getPeriod().setEndDate(closeDate); // definir data de fim da fase que foi fechada
            } else if (p.getPhase().toString().equalsIgnoreCase(nextPhase)) {
                p.getPeriod().setStartDate(closeDate); // definir data de inicio da fase seguinte
                break;
            }
        }


        jobOpening.setStatusByMovingForwardPhase(nextPhase);
        statusChangeSvc.changeJobApplicationStatus(jobOpening.getJobReference().toString(), nextState.toUpperCase());
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


    private void startApplicationPhase(LocalDate startDate, String nextPhase, String nextState) {

        for (RecruitmentProcessPhase p : jobOpening.getRecruitmentProcess()) {
            if (p.getPhase().toString().equalsIgnoreCase(nextPhase)) {
                p.getPeriod().setStartDate(startDate);
                break;
            }
        }
        jobOpening.setStatusByMovingForwardPhase(nextPhase);
        statusChangeSvc.changeJobApplicationStatus(jobOpening.getJobReference().toString(), nextState.toUpperCase());
        jobOpeningSvc.saveJobOpening(jobOpening);
    }


}


