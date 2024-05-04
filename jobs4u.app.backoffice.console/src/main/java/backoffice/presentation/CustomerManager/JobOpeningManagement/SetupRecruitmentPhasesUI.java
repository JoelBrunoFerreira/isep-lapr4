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
import java.util.InputMismatchException;
import java.util.List;

import static eapli.framework.io.util.Console.readLine;

public class SetupRecruitmentPhasesUI extends AbstractUI {

    private LocalDate startDate;
    private LocalDate endDate;
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
                answerInterviewPhase = Console.readLine("Do you want to setup the interview phase? (y/n):").trim();

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
                Console.readLine("Invalid input.");
            }
        }

        List<RecruitmentProcessPhaseDTO> list = controller.getRecruitmentProcessPhases(dto.jobReference, withInterview);
        System.out.println(list);
        setRecruitmentProcessPhasesData(list);
    }

    public void setRecruitmentProcessPhasesData(List<RecruitmentProcessPhaseDTO> list) {

        LocalDate maxDate = LocalDate.now();
        boolean validInput;
        boolean dateControl;


        for (RecruitmentProcessPhaseDTO phase : list) {
            System.out.println(phase);
            validInput = false;

            if (phase.getPhase().equals(Phase.APPLICATION.getDesignation())) {

                while (!validInput){

                    try {
                        LocalDate applicationStartDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        LocalDate applicationEndDate = LocalDate.parse(readLine("End Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        dateControl = phaseDateVerification(applicationStartDate, applicationEndDate, maxDate);
                        if (dateControl) {
                            phase.setRecruitmentProcessPhaseDates(applicationStartDate, applicationEndDate);
                            maxDate = applicationEndDate;
                            validInput = true;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Invalid date format.");
                    }
                }

            } else if (phase.getPhase().equals(Phase.SCREENING.getDesignation())) {

                while (!validInput){

                    try {
                        LocalDate screeningStartDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        LocalDate screeningEndDate = LocalDate.parse(readLine("End Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        dateControl = phaseDateVerification(screeningStartDate, screeningEndDate, maxDate);
                        if (dateControl) {
                            phase.setRecruitmentProcessPhaseDates(screeningStartDate, screeningEndDate);
                            maxDate = screeningEndDate;
                            validInput = true;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Invalid date format.");
                    }
                }
            } else if (phase.getPhase().equals(Phase.INTERVIEWS.getDesignation())) {
                while (!validInput){

                    try {
                        LocalDate interviewStartDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        LocalDate interviewEndDate = LocalDate.parse(readLine("End Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        dateControl = phaseDateVerification(interviewStartDate, interviewEndDate, maxDate);
                        if (dateControl) {
                            phase.setRecruitmentProcessPhaseDates(interviewEndDate, interviewEndDate);
                            maxDate = interviewEndDate;
                            validInput = true;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Invalid date format.");
                    }
                }

            } else if (phase.getPhase().equals(Phase.ANALYSIS.getDesignation())) {
                while (!validInput){

                    try {
                        LocalDate analysisStartDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        LocalDate analysisEndDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        dateControl = phaseDateVerification(analysisStartDate, analysisEndDate, maxDate);
                        if (dateControl) {
                            phase.setRecruitmentProcessPhaseDates(analysisStartDate, analysisEndDate);
                            maxDate = analysisEndDate;
                            validInput = true;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Invalid date format.");
                    }
                }

            }else if (phase.getPhase().equals(Phase.RESULT.getDesignation())) {
                while (!validInput){

                    try {
                        LocalDate resultStartDate= LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        LocalDate resultEndDate = LocalDate.parse(readLine("Start Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        dateControl = phaseDateVerification(resultStartDate, resultEndDate, maxDate);
                        if (dateControl) {
                            phase.setRecruitmentProcessPhaseDates(resultStartDate, resultEndDate);
                            maxDate = resultEndDate;
                            validInput = true;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Invalid date format.");
                    }
                }
            }
        }
    }

    @Override
    public String headline() {
        return "Setup Recruitment Process Phases";
    }

    public boolean phaseDateVerification (LocalDate startDate, LocalDate endDate, LocalDate maxDate) {

        if (startDate.isAfter(endDate)) {
            System.out.println("The end date is after the start date. Please try again.");
            return false;
        }

        if (startDate.isBefore(endDate) || startDate.equals(maxDate)) {
            return true;
        }




        return false;
    }

}

