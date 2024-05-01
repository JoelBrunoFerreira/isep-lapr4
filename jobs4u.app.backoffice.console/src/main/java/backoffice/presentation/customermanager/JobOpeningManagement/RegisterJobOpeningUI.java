package backoffice.presentation.customermanager.JobOpeningManagement;

import eapli.base.JobOpeningManagement.application.RegisterJobOpeningController;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.visitor.Visitor;

public class RegisterJobOpeningUI extends AbstractUI {
    RegisterJobOpeningController registerJobOpeningController = new RegisterJobOpeningController();

    @Override
    protected boolean doShow() {
        try {
            Iterable<CustomerDTO> customers = registerJobOpeningController.getCustomersDTO();
            SelectWidget<CustomerDTO> customerSelector = new SelectWidget<>("Select the customer corresponding to the job opening:", customers);
            customerSelector.show();
            CustomerDTO customer = customerSelector.selectedElement();

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
                        address, numberVacancies, mode, contractType, customer.getEmail());

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
