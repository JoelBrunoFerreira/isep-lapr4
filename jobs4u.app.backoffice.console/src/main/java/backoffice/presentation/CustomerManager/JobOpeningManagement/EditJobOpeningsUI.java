package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.jobOpeningManagement.application.EditJobOpeningController;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.springframework.boot.Banner;

public class EditJobOpeningsUI extends AbstractUI {
    private static final int EXIT_OPTION = 0;
    private static final int EDIT_TITLE = 1;
    private static final int EDIT_DESCRIPTION = 2;
    private static final int EDIT_ADDRESS = 3;
    private static final int EDIT_N_VACANCIES = 4;
    private static final int EDIT_MODE = 5;
    private static final int EDIT_CONTRACT = 6;
    private static final int EDIT_ALL = 7;


    private final EditJobOpeningController controller = new EditJobOpeningController();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    @Override
    protected boolean doShow() {
        JobOpeningDTO jobOpeningDTO = null;
        boolean filtered = Console.readBoolean("Edit Job Opening by Job Reference? y/n");
        if (filtered) {
            String jobReference = Console.readLine("Job Reference: ");
            try {
                jobOpeningDTO = getJobOpeningByJobReference(jobReference);
            } catch (Exception e) {
                System.out.println("Job opening with job reference \"" + jobReference + "\" doesn't exists.");
            }
        } else {
            jobOpeningDTO = showAllJobOpenings();
        }
        boolean keepEditing;
        if (jobOpeningDTO != null) {
            if (validToEditUntilPhases(jobOpeningDTO)) {
                do {
                    editBasicInfo(jobOpeningDTO);
                    keepEditing = Console.readBoolean("Keep editing? y/n");
                }
                while (keepEditing);
                System.out.println(controller.updateJobOpening(jobOpeningDTO));
            }
        }
        return false;
    }

    private void editBasicInfo(JobOpeningDTO jobOpeningDTO) {
        System.out.println("Edit Job Opening: " + jobOpeningDTO.jobReference);
        System.out.println("\t1 - Title: " + jobOpeningDTO.jobTitle);
        System.out.println("\t2 - Description: " + jobOpeningDTO.description);
        System.out.println("\t3 - Address: " + jobOpeningDTO.jobOpeningAddress);
        System.out.println("\t4 - Number of vacancies: " + jobOpeningDTO.numberVacancies);
        System.out.println("\t5 - Working mode: " + jobOpeningDTO.mode);
        System.out.println("\t6 - Contract type: " + jobOpeningDTO.contractType);
        String title, description, address, mode, contractType;
        int numberVacancies;

        int option = Console.readInteger("What to edit?");
        switch (option) {
            case EDIT_TITLE:
                title = Console.readLine("New Title:");
                jobOpeningDTO.setJobTitle(title);
                break;
            case EDIT_DESCRIPTION:
                description = Console.readLine("New Description:");
                jobOpeningDTO.setDescription(description);
                break;
            case EDIT_ADDRESS:
                address = Console.readLine("New Company address:");
                jobOpeningDTO.setJobOpeningAddress(address);
                break;
            case EDIT_N_VACANCIES:
                numberVacancies = Console.readInteger("New Number of vacancies:");
                jobOpeningDTO.setNumberVacancies(String.valueOf(numberVacancies));
                break;
            case EDIT_MODE:
                SelectWidget<String> modeSelector = new SelectWidget<>("New Mode:", controller.getModeList(), visitee -> System.out.print(visitee));
                modeSelector.show();
                mode = modeSelector.selectedElement();
                jobOpeningDTO.setMode(mode);
                break;
            case EDIT_CONTRACT:
                SelectWidget<String> contractTypeSelector = new SelectWidget<>("New Contract type:", controller.getContractTypeList(), visitee -> System.out.print(visitee));
                contractTypeSelector.show();
                contractType = contractTypeSelector.selectedElement();
                jobOpeningDTO.setContractType(contractType);
                break;
            default:
                System.out.println("Choose a valid option please.");
        }
        System.out.println("Edit Job Opening: " + jobOpeningDTO.jobReference);
        System.out.println("\t1 - Title: " + jobOpeningDTO.jobTitle);
        System.out.println("\t2 - Description: " + jobOpeningDTO.description);
        System.out.println("\t3 - Address: " + jobOpeningDTO.jobOpeningAddress);
        System.out.println("\t4 - Number of vacancies: " + jobOpeningDTO.numberVacancies);
        System.out.println("\t5 - Working mode: " + jobOpeningDTO.mode);
        System.out.println("\t6 - Contract type: " + jobOpeningDTO.contractType);
    }


    private JobOpeningDTO getJobOpeningByJobReference(String jobReference) {
        return controller.getJobOpeningByReference(jobReference);
    }

    private JobOpeningDTO showAllJobOpenings() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByUSer();
        if (jobOpeningDTOS.iterator().hasNext()) {
            SelectWidget<JobOpeningDTO> selectJobOpeningDTO = new SelectWidget<>("Job Openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
            return selectJobOpeningDTO.selectedElement();
        } else {
            System.out.println("No job openings to list.");
            return null;
        }
    }

    private boolean validToEditUntilPhases(JobOpeningDTO jobOpeningDTO) {
        return jobOpeningDTO.getStatus().equals(Status.PENDING.toString());
    }

    private boolean validToEditPhaseDates(JobOpeningDTO jobOpeningDTO) {
        return jobOpeningDTO.getStatus().equals(Status.ACTIVE.toString());
    }

    private boolean validToEditJobRequirement(JobOpeningDTO jobOpeningDTO) {
        return jobOpeningDTO.getStatus().equals(Status.ACTIVE.toString());
    }

    private boolean validToEditInterviewModel(JobOpeningDTO jobOpeningDTO) {
        return jobOpeningDTO.getStatus().equals(Status.ACTIVE.toString());
    }


    @Override
    public String headline() {
        return "Edit Job Opening";
    }
}
