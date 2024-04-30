package backoffice.presentation.customermanager.JobOpeningManagement;

import eapli.base.JobOpeningManagement.application.ListJobOpeningsController;
import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.SelectWidget;

public class ListJobOpeningsUI extends AbstractUI {
    private static final int EXIT_OPTION = 0;
    private static final int FILTER_CUSTOMER = 1;
    private static final int FILTER_ACTIVE = 2;
    private static final int FILTER_PENDING = 3;
    private static final int FILTER_COMPLETED = 4;

    private static final int FILTER_ALL = 5;

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
            int option = Console.readInteger(filterMenu());
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
                case EXIT_OPTION:
                    new ExitWithMessageAction("Goodbye");
                    break;
            }

        }
        else {
            showAllJobOpenings();
        }
        return false;
    }



    private void showAllJobOpenings() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpenings();
        SelectWidget<JobOpeningDTO> selectJobOpeningDTO = new SelectWidget<>("Select Customer:", jobOpeningDTOS);
        selectJobOpeningDTO.show();
    }

    private String filterMenu() {
        return String.format("%d - By customer;\n%d - Active;\n%d - Pending;\n%d - Completed;\n%d - All.\n", FILTER_CUSTOMER, FILTER_ACTIVE,FILTER_PENDING,FILTER_COMPLETED, FILTER_ALL);
    }

    private void filterByCustomer() {
        Iterable<CustomerDTO> customer = controller.getCustomersDTO();
        SelectWidget<CustomerDTO> selectCustomer = new SelectWidget<>("Select Customer:", customer);
        selectCustomer.show();
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByCustomers(selectCustomer.selectedElement().getEmail());
        SelectWidget<JobOpeningDTO> selectJobOpeningDTO = new SelectWidget<>("Select Customer:", jobOpeningDTOS);
        selectJobOpeningDTO.show();
    }
    private void filterByActive() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByStatus(Status.ACTIVE);
        SelectWidget<JobOpeningDTO> selectJobOpeningDTO = new SelectWidget<>("Select Customer:", jobOpeningDTOS);
        selectJobOpeningDTO.show();
    }
    private void filterByPending() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByStatus(Status.PENDING);
        SelectWidget<JobOpeningDTO> selectJobOpeningDTO = new SelectWidget<>("Select Customer:", jobOpeningDTOS);
        selectJobOpeningDTO.show();
    }

    private void filterByCompleted() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByStatus(Status.COMPLETED);
        SelectWidget<JobOpeningDTO> selectJobOpeningDTO = new SelectWidget<>("Select Customer:", jobOpeningDTOS);
        selectJobOpeningDTO.show();
    }

    @Override
    public String headline() {
        return "List Job Openings";
    }
}