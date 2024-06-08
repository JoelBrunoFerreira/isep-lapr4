package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.application.OpenOrClosePhasesController;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static eapli.framework.io.util.Console.readLine;

public class OpenOrClosePhasesUI extends AbstractUI {
    private final OpenOrClosePhasesController controller = new OpenOrClosePhasesController();


    private static final String EXIT_OPTION = "0";
    private static final String APPLICATION = "APPLICATION";
    private static final String SCREENING = "SCREENING";
    private static final String INTERVIEW = "INTERVIEW";
    private static final String ANALYSIS = "ANALYSIS";
    private static final String RESULT = "RESULT";

    @Override
    protected boolean doShow() {


        JobOpeningDTO dto = getJobOpening();


        if (dto == null) {
            System.out.println("Returning to main menu...");
        } else {

            String jobRefStatus = controller.jobOpeningStatus(dto.jobReference);
            System.out.println("THE SELECTED JOB OPENING IS IN THE PHASE: " + jobRefStatus + "\n");

            String option = readLine("CHOOSE WHAT MOVE TO DO TO CURRENT PHASE (next/previous):");
            if (option.equalsIgnoreCase("previous")) {

                LocalDate openDate = LocalDate.parse(readLine("INSERT THE START DATE OF THE PREVIOUS PHASE (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                controller.returnToPreviousProcessPhase(jobRefStatus, openDate);

            } else if (option.equalsIgnoreCase("next")) {

                LocalDate closeDate = LocalDate.parse(readLine("INSERT THE CLOSE DATE OF THE CURRENT PHASE (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                controller.moveToNextProcessPhase(closeDate);
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
            SelectWidget<RecruitmentProcessPhaseDTO> selectRecruitmentProcessPhaseDTO = new SelectWidget<>("", recruitmentProcessPhaseDTO, visitee -> System.out.println(visitee.toStringComplete()));
            selectRecruitmentProcessPhaseDTO.show();
            return selectRecruitmentProcessPhaseDTO.selectedElement();
        }
    }


    @Override
    public String headline() {
        return "";
    }
}
