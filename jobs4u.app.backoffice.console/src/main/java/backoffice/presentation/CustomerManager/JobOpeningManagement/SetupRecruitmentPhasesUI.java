package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.RecruitmentProcessManagement.application.SetupRecruitmentProcessController;
import eapli.base.RecruitmentProcessManagement.domain.Phase;
import eapli.base.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static eapli.framework.io.util.Console.readLine;

public class SetupRecruitmentPhasesUI extends AbstractUI {

    SetupRecruitmentProcessController controller = new SetupRecruitmentProcessController();

    @Override
    protected boolean doShow() {
        mainMenu();
        //TODO 1- get job openings that are pending, use list job openings filter for pending
        // in selectWidget mode to get job opening, and filter by phases empty list

        //Todo 2- Choose 4 or 5 "size list"

        //TODO 3- Make phases, list of RecruitmentProcessPhases, that has Period and Phase Enum, hard code ?
        //p.e.: option 1 -> Phase.Application ... resto de código(datas)

        return false;
    }

    private JobOpeningDTO getJobOpening() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsDTO();
        SelectWidget<JobOpeningDTO> selectJobOpeningDTO = new SelectWidget<>("Job Openings:", jobOpeningDTOS, new JobOpeningPrinter());
        selectJobOpeningDTO.show();
        return selectJobOpeningDTO.selectedElement();
    }

    private void mainMenu() {
        JobOpeningDTO dto = getJobOpening();
        System.out.println(dto);
        System.out.println(dto.jobReference);
        //TODO, ERRO a partir daqui:
        System.out.println(controller.getJO(dto.jobReference));

        boolean withInterview = false;
        System.out.println();

        String answerInterviewPhase;

        boolean validInput = false;


        while (!validInput) {

            try {
                answerInterviewPhase = readLine("Do you want to setup the interview phase? (y/n):").trim();

                if (answerInterviewPhase.equals("y")) {
                    withInterview = true;
                    validInput = true;
                } else if (answerInterviewPhase.equals("n")) {
                    validInput = true;
                } else {
                    System.out.println("Invalid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println();
                readLine("Invalid input.");
            }
        }

        List<RecruitmentProcessPhaseDTO> list = controller.getRecruitmentProcessPhases(dto.jobReference, withInterview);
        System.out.println(list);

        controller.setRecruitmentProcessPhases(setRecruitmentProcessPhasesData(list));
        String sucessfull = "";
        System.out.println("Phases sucessfully created!" + sucessfull);
    }

    public List<RecruitmentProcessPhaseDTO> setRecruitmentProcessPhasesData(List<RecruitmentProcessPhaseDTO> list) {

        LocalDate maxDate = LocalDate.now();

        LocalDate applicationStartDate = null;
        LocalDate applicationEndDate = null;

        LocalDate screeningStartDate = null;
        LocalDate screeningEndDate = null;

        LocalDate interviewStartDate = null;
        LocalDate interviewEndDate = null;

        LocalDate analysisStartDate = null;
        LocalDate analysisEndDate = null;

        LocalDate resultStartDate = null;
        LocalDate resultEndDate = null;

        boolean validInput;
        boolean dateControl;


        for (RecruitmentProcessPhaseDTO phase : list) {
            System.out.println();
            System.out.println("+=" + phase + "=+");
            validInput = false;

            if (phase.getPhase().equals(Phase.APPLICATION.getDesignation())) {

                while (!validInput) {

                    try {
                        applicationStartDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        applicationEndDate = LocalDate.parse(readLine("End Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please try again.");
                        continue;
                    }

                    dateControl = phaseDateVerification(applicationStartDate, applicationEndDate, maxDate);
                    if (dateControl) {
                        phase.setRecruitmentProcessPhaseDates(applicationStartDate, applicationEndDate);
                        maxDate = applicationEndDate;
                        validInput = true;
                    }
//                    try {
//                        applicationStartDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//                        applicationEndDate = LocalDate.parse(readLine("End Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//
//
//                        dateControl = phaseDateVerification(applicationStartDate, applicationEndDate, maxDate);
//                        if (dateControl) {
//                            phase.setRecruitmentProcessPhaseDates(applicationStartDate, applicationEndDate);
//                            maxDate = applicationEndDate;
//                            validInput = true;
//                        }
//                    } catch (InputMismatchException e) {
//                        System.out.println("Invalid date format.");
//                    }
                }


            } else if (phase.getPhase().equals(Phase.SCREENING.getDesignation())) {

                while (!validInput) {

                    try {
                        screeningStartDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        screeningEndDate = LocalDate.parse(readLine("End Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please try again.");
                        continue;
                    }
                    dateControl = phaseDateVerification(screeningStartDate, screeningEndDate, maxDate);
                    if (dateControl) {
                        phase.setRecruitmentProcessPhaseDates(screeningStartDate, screeningEndDate);
                        maxDate = screeningEndDate;
                        validInput = true;
                    }

                }
            } else if (phase.getPhase().equals(Phase.INTERVIEWS.getDesignation())) {
                while (!validInput) {

                    try {
                        interviewStartDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        interviewEndDate = LocalDate.parse(readLine("End Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please try again.");
                        continue;
                    }
                    dateControl = phaseDateVerification(interviewStartDate, interviewEndDate, maxDate);
                    if (dateControl) {
                        phase.setRecruitmentProcessPhaseDates(interviewStartDate, interviewEndDate);
                        maxDate = interviewEndDate;
                        validInput = true;
                    }
                }
            } else if (phase.getPhase().equals(Phase.ANALYSIS.getDesignation())) {
                while (!validInput) {

                    try {
                        analysisStartDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        analysisEndDate = LocalDate.parse(readLine("End Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please try again.");
                        continue;
                    }
                    dateControl = phaseDateVerification(analysisStartDate, analysisEndDate, maxDate);
                    if (dateControl) {
                        phase.setRecruitmentProcessPhaseDates(analysisStartDate, analysisEndDate);
                        maxDate = analysisEndDate;
                        validInput = true;
                    }
                }
            } else if (phase.getPhase().equals(Phase.RESULT.getDesignation())) {
                while (!validInput) {

                    try {
                        resultStartDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        resultEndDate = LocalDate.parse(readLine("End Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please try again.");
                        continue;
                    }
                    dateControl = phaseDateVerification(resultStartDate, resultEndDate, maxDate);
                    if (dateControl) {
                        phase.setRecruitmentProcessPhaseDates(resultStartDate, resultEndDate);
                        maxDate = resultEndDate;
                        validInput = true;
                    }
                }
            }
        }
        return list;
    }


    @Override
    public String headline() {
        return "Setup Recruitment Process Phases";
    }

    public boolean phaseDateVerification(LocalDate startDate, LocalDate endDate, LocalDate maxDate) {

        if (startDate.isBefore(LocalDate.now())) {
            System.out.println("The start date is in the past. Please try again.");
            return false;
        }

        if (startDate.isAfter(endDate)) {
            System.out.println("The start date is after the end date. Please try again.");
            return false;
        }

        if (endDate.isBefore(maxDate) || endDate.isEqual(maxDate)) {
            System.out.println("The end date of this phase can't be in the same period as the previous phase. Please try again.");
            return false;
        }

        if (startDate.isBefore(maxDate)) {
            System.out.println("The start date of this phase can't be before the current date or in the same period as the previous phase. Please try again.");
            return false;
        }

        if (startDate.isEqual(endDate)) {
            System.out.println("The start and end date of this phase can't be the same. Please try again.");
            return false;
        }

        return true;
    }

}

