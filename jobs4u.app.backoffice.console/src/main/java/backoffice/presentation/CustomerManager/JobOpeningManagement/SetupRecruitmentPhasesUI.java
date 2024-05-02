package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.RecruitmentProcessManagement.application.SetupRecruitmentProcessController;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.time.LocalDate;

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
    private void mainMenu(){
        JobOpeningDTO dto = getJobOpening();
        System.out.println(dto);
        System.out.println(dto.jobReference);
        //TODO, ERRO a partir daqui:
        System.out.println(controller.getJO(dto.jobReference));
      // List<RecruitmentProcessPhaseDTO> list = controller.getRecruitmentProcessPhases(showAllJobOpenings().jobReference,true);
        //System.out.println(list);
    }
    @Override
    public String headline() {
        return "Setup Recruitment Process Phases";
    }
}
