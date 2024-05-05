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
                case FILTER_ALL:
                    showAllJobOpenings();
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
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByUSer();
        if (jobOpeningDTOS.iterator().hasNext()){
            ListWidget<JobOpeningDTO> selectJobOpeningDTO = new ListWidget<>("Job Openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
        }else{
            System.out.println("No job openings to list.");
        }
    }

    private String filterMenu() {
        return String.format("%d - By customer;\n" +
                        "%d - Active;\n%d - Pending;\n" +
                        "%d - Completed;\n" +
                        "%d - All.\n",
                FILTER_CUSTOMER, FILTER_ACTIVE,FILTER_PENDING,FILTER_COMPLETED, FILTER_ALL);
    }

    private void filterByCustomer() {
        Iterable<CustomerDTO> customer = controller.getCustomersDTO();
        SelectWidget<CustomerDTO> selectCustomer = new SelectWidget<>("Select Customer:", customer, new CustomerPrinter());
        selectCustomer.show();
        if (selectCustomer.selectedElement() != null){
            Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByCustomers(selectCustomer.selectedElement().getEmail());
            ListWidget<JobOpeningDTO> selectJobOpeningDTO = new ListWidget<>("Job Openings From Customer: "+selectCustomer.selectedElement().getAcronym(), jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
        }
    }
    private void filterByActive() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByStatus(Status.ACTIVE);
        if (jobOpeningDTOS.iterator().hasNext()){
            ListWidget<JobOpeningDTO> selectJobOpeningDTO = new ListWidget<>("Active job openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
        }else {
            System.out.println("No active job openings found!\n");
        }

    }
    private void filterByPending() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByStatus(Status.PENDING);
        if (jobOpeningDTOS.iterator().hasNext()){
            ListWidget<JobOpeningDTO> selectJobOpeningDTO = new ListWidget<>("Pending Job Openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
        }else{
            System.out.println("No pending job openings found!\n");
        }
    }

    private void filterByCompleted() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsByStatus(Status.COMPLETED);
        if (jobOpeningDTOS.iterator().hasNext()){
            ListWidget<JobOpeningDTO> selectJobOpeningDTO = new ListWidget<>("Completed job openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
        }else {
            System.out.println("No completed job openings found!\n");
        }
    }

    @Override
    public String headline() {
        return "List Job Openings";
    }
}