package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.jobOpeningManagement.application.EditJobOpeningController;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class EditJobOpeningsUI extends AbstractUI {
    private static final int EXIT_OPTION = 0;
    private static final int FILTER_CUSTOMER = 1;
    private static final int FILTER_ACTIVE = 2;
    private static final int FILTER_PENDING = 3;
    private static final int FILTER_COMPLETED = 4;
    private static final int FILTER_JOB_REFERENCE = 5;

    private static final int FILTER_ALL = 6;

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
        if (jobOpeningDTO != null) {
            if (validToEditEverything(jobOpeningDTO)){
                System.out.println("Valid!");
            }
        }
        return false;
    }

    private boolean validToEditEverything(JobOpeningDTO jobOpeningDTO) {
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


    private String filterMenu() {
        return String.format("%d - By customer;\n" +
                        "%d - Active;\n%d - Pending;\n" +
                        "%d - Completed;\n" +
                        "%d - Job Reference;\n" +
                        "%d - All.\n",
                FILTER_CUSTOMER, FILTER_ACTIVE, FILTER_PENDING, FILTER_COMPLETED, FILTER_JOB_REFERENCE, FILTER_ALL);
    }


    @Override
    public String headline() {
        return "List Job Openings";
    }
}
