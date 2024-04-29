package backoffice.presentation.JobOpeningManagement;

import eapli.base.JobOpeningManagement.application.ListJobOpeningsController;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.customer.application.GetCustomerListController;
import eapli.base.customer.domain.Customer;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.SelectWidget;

import java.time.LocalDate;
import java.time.ZoneId;

public class ListJobOpeningsUI extends AbstractUI {
    private static final int EXIT_OPTION = 0;
    private static final int FILTER_CUSTOMER = 1;
    private static final int FILTER_ACTIVE = 2;
    private static final int FILTER_ALL = 3;

    private final ListJobOpeningsController controller = new ListJobOpeningsController();
    private final GetCustomerListController customerListController = new GetCustomerListController();

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
        for (JobOpeningDTO jobDTO : jobOpeningDTOS) {
            System.out.println(jobDTO.toString());
        }
    }

    private String filterMenu() {
        return String.format("%d - By customer;\n%d - Active;\n%d - All.\n", FILTER_CUSTOMER, FILTER_ACTIVE, FILTER_ALL);
    }

    private void filterByCustomer() {
        Iterable<Customer> customer = customerListController.getCustomerList();
        SelectWidget<Customer> selectCustomer = new SelectWidget<>("Select Customer:", customer);
        selectCustomer.show();
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByCustomers(selectCustomer.selectedElement().getAcronym().getAcronym());
        for (JobOpeningDTO jobDTO : jobOpeningDTOS) {
            System.out.println(jobDTO.toString());
        }
    }

    @Override
    public String headline() {
        return "List Job Openings";
    }
}