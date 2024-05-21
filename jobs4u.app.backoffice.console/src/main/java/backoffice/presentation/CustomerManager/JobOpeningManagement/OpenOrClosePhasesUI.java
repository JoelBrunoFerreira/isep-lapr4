package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.application.OpenOrClosePhasesController;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.domain.RecruitmentProcessPhase;
import eapli.base.jobOpeningManagement.RecruitmentProcessManagement.dto.RecruitmentProcessPhaseDTO;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.SelectWidget;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static eapli.framework.io.util.Console.readLine;

public class OpenOrClosePhasesUI extends AbstractUI {
    private final OpenOrClosePhasesController controller = new OpenOrClosePhasesController();


    private static final int EXIT_OPTION = 0;
//    private static final int FILTER_ACTIVE = 2;
//    private static final int ACTIVE = 1;
//    private static final int ACTIVE_APPLICATION = 2;
//    private static final int ACTIVE_SCREENING = 3;
//    private static final int ACTIVE_INTERVIEW = 4;
//    private static final int ACTIVE_ANALYSIS = 5;
//    private static final int ACTIVE_RESULT = 6;

    private static final int APPLICATION = 1;
    private static final int SCREENING = 2;
    private static final int INTERVIEW = 3;
    private static final int ANALYSIS = 4;
    private static final int RESULT = 5;



    @Override
    protected boolean doShow() {


        JobOpeningDTO dto = getJobOpening();
//        controller.setRecruitmentProcessPhases(setRecruitmentProcessPhasesData(list));

        if (dto == null) {
            System.out.println("Returning to main menu...");
        } else {


            String selectPhase = getRecruitmentProcessPhaseDates(dto.jobReference).getPhase();

            String option = Console.readLine("Open/Close phase?");
            if (option.equalsIgnoreCase("open")) {

                LocalDate openDate = LocalDate.parse(readLine("Open Date (DD-MM-YYYY): "), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                controller.openProcessPhases(selectPhase,openDate);
            }


//            int counter = 1;
//            List<RecruitmentProcessPhaseDTO> list = controller.getRecruitmentProcessDefinedPhases(dto.jobReference);
//            System.out.println();
//            for (RecruitmentProcessPhaseDTO phase : list){
//                System.out.println(counter + " - " + phase.getPhase());
//                counter++;
//            }
//            System.out.println("0 - Exit");
//            int phaseOption = Console.readOption(1,counter,EXIT_OPTION);
//            boolean changeProcessPhase= Console.readBoolean("Do you want to open or close process phases? (y/n)");
//
////            System.out.println(list);
//            if (changeProcessPhase) {
//                switch (phaseOption) {
//                    case APPLICATION:
////                        filterByCustomer();
//                        break;
//                    case SCREENING:
////                        filterByActive();
//                        break;
//                    case INTERVIEW:
////                        filterByPending();
//                        break;
//                    case ANALYSIS:
////                        filterByCompleted();
//                        break;
//                    case RESULT:
////                        filterByJobRefernece();
//                        break;
////                    case FILTER_ALL:
////                        showAllJobOpenings();
////                        break;
//                    case EXIT_OPTION:
//                        new ExitWithMessageAction("Goodbye");
//                        break;
//                }
//            }else {
//                System.out.println("Returning to main menu...");
//            }
//            if (validToEditUntilPhases(jobOpeningDTO)) {
//                do {
//                    editBasicInfo(jobOpeningDTO);
//                    keepEditing = Console.readBoolean("Keep editing? y/n");
//                }
//                while (keepEditing);
//                System.out.println(controller.updateJobOpening(jobOpeningDTO));
//            }


//           JobOpening phaseStatus = new JobOpening();
//           setStatusByPhaseDates();
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
