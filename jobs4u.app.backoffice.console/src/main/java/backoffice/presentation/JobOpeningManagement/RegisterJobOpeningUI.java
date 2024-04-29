package backoffice.presentation.JobOpeningManagement;

import eapli.base.JobOpeningManagement.application.RegisterJobOpeningController;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.customer.application.GetCustomerListController;
import eapli.base.customer.domain.Customer;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class RegisterJobOpeningUI extends AbstractUI {
    private final RegisterJobOpeningController registerJobOpeningController = new RegisterJobOpeningController();
    private final GetCustomerListController customerController = new GetCustomerListController();

    @Override
    protected boolean doShow() {
        try {
            Iterable<Customer> customers = customerController.getCustomerList();
            SelectWidget<Customer> customerSelector = new SelectWidget<>("Select the customer corresponding to the job opening:", customers);
            customerSelector.show();
            Customer customer = customerSelector.selectedElement();

            if (customer != null) {
                final String title = Console.readLine("Title:");
                final String description = Console.readLine("Description:");
                final String address = Console.readLine("Company address:");
                final int numberVacancies = Console.readInteger("Number of vacancies:");

                SelectWidget<String> modeSelector = new SelectWidget<>("Mode:", registerJobOpeningController.getModeList());
                modeSelector.show();
                final String mode = modeSelector.selectedElement();

                SelectWidget<String> contractTypeSelector = new SelectWidget<>("Contract type:", registerJobOpeningController.getContractTypeList());
                contractTypeSelector.show();
                final String contractType = contractTypeSelector.selectedElement();

                JobOpeningDTO resultDTO = registerJobOpeningController.registerJobOpening(title, description,
                        address, numberVacancies, mode, contractType, customer);

                System.out.println("Registered Job Opening:");
                System.out.println("\tJob reference: " + resultDTO.jobReference);
                System.out.println("\tTitle: " + resultDTO.jobTitle);
                System.out.println("\tDescription: " + resultDTO.description);
                System.out.println("\tAddress: " + resultDTO.jobOpeningAddress);
                System.out.println("\tNumber of vacancies: " + resultDTO.numberVacancies);
                System.out.println("\tWorking mode: " + resultDTO.mode);
                System.out.println("\tContract type: " + resultDTO.contractType);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Register job opening";
    }
}
