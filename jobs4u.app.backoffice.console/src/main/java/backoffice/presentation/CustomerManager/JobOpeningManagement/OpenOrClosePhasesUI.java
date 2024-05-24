package backoffice.presentation.CustomerManager.JobOpeningManagement;

import backoffice.presentation.CustomerManager.CustomerManagerMainMenu;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.application.OpenOrClosePhasesController;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static eapli.framework.io.util.Console.readLine;

public class OpenOrClosePhasesUI extends AbstractUI {
    private final OpenOrClosePhasesController controller = new OpenOrClosePhasesController();


    private static final String EXIT_OPTION = "0";
//    private static final int FILTER_ACTIVE = 2;
//    private static final int ACTIVE = 1;
//    private static final int ACTIVE_APPLICATION = 2;
//    private static final int ACTIVE_SCREENING = 3;
//    private static final int ACTIVE_INTERVIEW = 4;
//    private static final int ACTIVE_ANALYSIS = 5;
//    private static final int ACTIVE_RESULT = 6;

    private static final String APPLICATION = "APPLICATION";
    private static final String SCREENING = "SCREENING";
    private static final String INTERVIEW = "INTERVIEW";
    private static final String ANALYSIS = "ANALYSIS";
    private static final String RESULT = "RESULT";



    @Override
    protected boolean doShow() {


        JobOpeningDTO dto = getJobOpening();
//        controller.setRecruitmentProcessPhases(setRecruitmentProcessPhasesData(list));

        if (dto == null) {
            System.out.println("Returning to main menu...");
        } else {

            String selectPhase = getRecruitmentProcessPhaseDates(dto.jobReference).getPhase();
//            boolean validPhaseToUpdate = validPhaseToUpdate(selectPhase);
            String option = readLine("Open/Close phase?");
            if (option.equalsIgnoreCase("open")) {

                LocalDate openDate = LocalDate.parse(readLine("Open Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                controller.openProcessPhases(selectPhase,openDate);

            }else if (option.equalsIgnoreCase("close")) {

                LocalDate closeDate = LocalDate.parse(readLine("Close Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                controller.closeProcessPhases(selectPhase,closeDate);
            }

        }
        return false;
    }



    private JobOpeningDTO getJobOpening() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsDTO();
        if (!jobOpeningDTOS.iterator().hasNext()) {
            System.out.println("No job openings for this user.");
            return null;
        } else {
            System.out.println("Select the job opening you wish to change the process phase.\n");
            SelectWidget<JobOpeningDTO> selectJobOpeningDTO = new SelectWidget<>("Job Openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
            return selectJobOpeningDTO.selectedElement();
        }

    }

    private RecruitmentProcessPhaseDTO getRecruitmentProcessPhaseDates(String jobReference) {
        Iterable<RecruitmentProcessPhaseDTO> recruitmentProcessPhaseDTO = controller.getRecruitmentProcessDefinedPhases(jobReference);

        if (!recruitmentProcessPhaseDTO.iterator().hasNext()) {
            System.out.println("No active phases for this job opening.");
            return null;
        } else {
            System.out.println("Select the phase you wish to change:\n");
            SelectWidget<RecruitmentProcessPhaseDTO> selectRecruitmentProcessPhaseDTO = new SelectWidget<>("", recruitmentProcessPhaseDTO, visitee -> System.out.println(visitee.toStringComplete())/*, new JobOpeningPrinter()*/);
            selectRecruitmentProcessPhaseDTO.show();
            return selectRecruitmentProcessPhaseDTO.selectedElement();
        }
    }




    private String changeProcessPhaseMenuOptions() {

            return String.format("""
                        Select the phase you want to change:
                        %d - APPLICATION
                        %d - SCREENING
                        %d - INTERVIEW
                        %d - ANALYSIS
                        %d - RESULT
                        """,
                APPLICATION, SCREENING, INTERVIEW, ANALYSIS, RESULT);
    }


    @Override
    public String headline() {
        return "";
    }
}
