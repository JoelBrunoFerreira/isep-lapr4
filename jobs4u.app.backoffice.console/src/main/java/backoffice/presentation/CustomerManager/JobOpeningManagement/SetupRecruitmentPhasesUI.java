package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.RecruitmentProcessManagement.application.SetupRecruitmentProcessController;
import eapli.base.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        String answerInterviewPhase = Console.readLine("Do you want to setup the interview phase? (y/n):");

        if (answerInterviewPhase == "y"){
            withInterview = true;
        } else if (answerInterviewPhase == "n"){
        }else {
            System.out.println("Please enter a valid interview phase (y/n)");
        }

        List<RecruitmentProcessPhaseDTO> list = controller.getRecruitmentProcessPhases(dto.jobReference, withInterview);
        System.out.println(list);
        setRecruitmentProcessPhasesData(list);
    }

    public void setRecruitmentProcessPhasesData(List<RecruitmentProcessPhaseDTO> list) {
        for (RecruitmentProcessPhaseDTO phase : list) {
            System.out.println(phase);
            LocalDate startDate = LocalDate.parse(Console.readLine("Start Date: "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate endDate = LocalDate.parse(Console.readLine("End Date: "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            ;
            phase.setRecruitmentProcessPhaseDates(startDate, endDate);
        }
    }

    @Override
    public String headline() {
        return "Setup Recruitment Process Phases";
    }
}

