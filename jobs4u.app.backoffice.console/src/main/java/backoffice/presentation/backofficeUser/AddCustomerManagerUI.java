package backoffice.presentation.backofficeUser;

import eapli.base.candidate.application.AddCandidateController;
import eapli.base.customerManager.application.AddCustomerManagerController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.representations.dto.GeneralDTO;
import org.hibernate.exception.ConstraintViolationException;

public class AddCustomerManagerUI extends AbstractUI {
    private final AddCustomerManagerController controller = new AddCustomerManagerController();

    @Override
    public boolean doShow() {
        System.out.println("========================");
        System.out.println("Register New Customer Manager  ");
        System.out.println("========================");
        System.out.println();
        final String fName = Console.readLine("First Name: \n");
        final String lName = Console.readLine("Last Name: \n");
        final String email = Console.readLine("Email: \n");

        try {
            GeneralDTO registeredUser = controller.addCustomerManager(fName, lName, email);
            System.out.println("Customer Manager registered successfully");
            //System.out.println("Username: "+registeredUser.get("username"));
            System.out.println("Name: " + registeredUser.get("name"));
            System.out.println("Email: " + registeredUser.get("email"));
            System.out.println("Password: " + registeredUser.get("password"));
            System.out.println("Role(s): " + registeredUser.get("roles").toString());
        } catch (IntegrityViolationException | ConstraintViolationException e) { //PersistenceException
            System.out.println("Error registering candidate.\nCode already in use.\n");
        } catch (Exception e) {
            System.out.println("Error registering candidate." + "\n" + e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Register New Candidate";
    }
}

