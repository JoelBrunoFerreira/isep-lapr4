package backoffice.presentation.CustomerManager.customerManagement;

import eapli.base.customer.application.AddCustomerController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.representations.dto.GeneralDTO;
import org.hibernate.exception.ConstraintViolationException;

@SuppressWarnings("java:S106")
public class AddCustomerUI extends AbstractUI {
    private final AddCustomerController controller = new AddCustomerController();

    @Override
    public boolean doShow() {
        System.out.println("========================");
        System.out.println("Register New Customer  ");
        System.out.println("========================");
        System.out.println();
        final String name = Console.readLine("Name");
        final String email = Console.readLine("Email");
        final String address = Console.readLine("Address");
        final String acronym = Console.readLine("Acronym");

        try {
            GeneralDTO registeredUser = controller.addCustomer(name, email, address, acronym);
            System.out.println("Customer registered successfully");
            System.out.println("Acronym: " + registeredUser.get("acronym"));
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
        return "Register New Customer";
    }
}
