package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.jobOpeningManagement.application.ListJobOpeningsController;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.app.common.console.presentation.customer.CustomerPrinter;
import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

public class ListJobOpeningsUI extends AbstractUI {
    private static final int EXIT_OPTION = 0;
    private static final int FILTER_CUSTOMER = 1;
    private static final int FILTER_ACTIVE = 2;
    private static final int ACTIVE = 1;
    private static final int ACTIVE_APPLICATION = 2;
    private static final int ACTIVE_SCREENING = 3;
    private static final int FILTER_PENDING = 3;
    private static final int ACTIVE_INTERVIEW = 4;
    private static final int FILTER_COMPLETED = 4;
    private static final int ACTIVE_ANALYSIS = 5;
    private static final int FILTER_JOB_REFERENCE = 5;
    private static final int ACTIVE_RESULT = 6;

    private static final int FILTER_ALL = 6;
    private static final int ACTIVE_ALL = 7;

    private final ListJobOpeningsController controller = new ListJobOpeningsController();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    @Override
    protected boolean doShow() {
        boolean filtered = Console.readBoolean("Filter Job Openings? y/n");
        if (filtered) {
            int option = Console.readInteger(filterMenuOptions());
            switch (option) {
                case FILTER_CUSTOMER:
                    filterByCustomer();
                    break;
                case FILTER_ACTIVE:
                    filterByActive();
                    break;
                case FILTER_PENDING:
                    filterByPending();
                    break;
                case FILTER_COMPLETED:
                    filterByCompleted();
                    break;
                case FILTER_JOB_REFERENCE:
                    filterByJobRefernece();
                    break;
                case FILTER_ALL:
                    showAllJobOpenings();
                    break;
                case EXIT_OPTION:
                    new ExitWithMessageAction("Goodbye");
                    break;
            }
        } else {
            showAllJobOpenings();
        }
        return false;
    }

    private void showAllJobOpenings() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByUSer();
        if (jobOpeningDTOS.iterator().hasNext()) {
            ListWidget<JobOpeningDTO> selectJobOpeningDTO = new ListWidget<>("Job Openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
        } else {
            System.out.println("No job openings to list.");
        }
    }

    private String filterMenuOptions() {
        return String.format("%d - By customer;\n" +
                        "%d - Active;\n%d - Pending;\n" +
                        "%d - Completed;\n" +
                        "%d - Job Reference;\n" +
                        "%d - All.\n",
                FILTER_CUSTOMER, FILTER_ACTIVE, FILTER_PENDING, FILTER_COMPLETED, FILTER_JOB_REFERENCE, FILTER_ALL);
    }

    private void filterByCustomer() {
        Iterable<CustomerDTO> customer = controller.getCustomersDTO();
        SelectWidget<CustomerDTO> selectCustomer = new SelectWidget<>("Select Customer:", customer, new CustomerPrinter());
        selectCustomer.show();
        if (selectCustomer.selectedElement() != null) {
            Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByCustomers(selectCustomer.selectedElement().getEmail());
            ListWidget<JobOpeningDTO> selectJobOpeningDTO = new ListWidget<>("Job Openings From Customer: " + selectCustomer.selectedElement().getAcronym(), jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
        }
    }

    private String activeSubMenuOptions() {
        return String.format("""
                        %d - Impending;
                        %d - Application;
                        %d - Screening;
                        %d - Interview;
                        %d - Analysis;
                        %d - Result;
                        %d - All.
                        """,
                ACTIVE, ACTIVE_APPLICATION, ACTIVE_SCREENING, ACTIVE_INTERVIEW, ACTIVE_ANALYSIS, ACTIVE_RESULT, ACTIVE_ALL);
    }

    private Status filterByActiveSubMenu() {
        Status result = Status.ACTIVE;
        int option = Console.readInteger(activeSubMenuOptions());

        switch (option) {
            case ACTIVE:
                result = Status.ACTIVE_IMPENDING;
                break;
            case ACTIVE_APPLICATION:
                result = Status.ACTIVE_APPLICATION;
                break;
            case ACTIVE_SCREENING:
                result = Status.ACTIVE_SCREENING;
                break;
            case ACTIVE_INTERVIEW:
                result = Status.ACTIVE_INTERVIEW;
                break;
            case ACTIVE_ANALYSIS:
                result = Status.ACTIVE_ANALYSIS;
                break;
            case ACTIVE_RESULT:
                result = Status.ACTIVE_RESULT;
                break;
            case ACTIVE_ALL:
                break;
            default:
                System.out.println("Choose a valid option please.");
        }

        return result;
    }

    private void filterByActive() {
        Status status = filterByActiveSubMenu();
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByStatus(status);
        if (jobOpeningDTOS.iterator().hasNext()) {
            ListWidget<JobOpeningDTO> selectJobOpeningDTO = new ListWidget<>("Active job openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
        } else {
            System.out.println("No active job openings found!\n");
        }

    }


    private void filterByPending() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByStatus(Status.PENDING);
        if (jobOpeningDTOS.iterator().hasNext()) {
            ListWidget<JobOpeningDTO> selectJobOpeningDTO = new ListWidget<>("Pending Job Openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
        } else {
            System.out.println("No pending job openings found!\n");
        }
    }

    private void filterByCompleted() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByStatus(Status.COMPLETED);
        if (jobOpeningDTOS.iterator().hasNext()) {
            ListWidget<JobOpeningDTO> selectJobOpeningDTO = new ListWidget<>("Completed job openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
        } else {
            System.out.println("No completed job openings found!\n");
        }
    }

    private void filterByJobRefernece() {
        String jobReference = Console.readLine("Job reference: ");
        try {
            JobOpeningDTO jobOpeningDTO = controller.getJobOpeningByReference(jobReference);
        } catch (Exception e) {
            System.out.println("Job opening with job reference: \"" + jobReference + "\" does not exist!\n");
        }
    }

    @Override
    public String headline() {
        return "List Job Openings";
    }
}