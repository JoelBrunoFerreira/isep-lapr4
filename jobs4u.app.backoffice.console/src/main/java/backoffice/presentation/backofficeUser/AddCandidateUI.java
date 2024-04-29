package backoffice.presentation.backofficeUser;

import eapli.base.candidate.application.AddCandidateController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.representations.dto.GeneralDTO;
import org.hibernate.exception.ConstraintViolationException;

@SuppressWarnings("java:S106")
public class AddCandidateUI extends AbstractUI {
    private final AddCandidateController controller = new AddCandidateController();

    @Override
    public boolean doShow() {
        System.out.println("========================");
        System.out.println("Register New Candidate  ");
        System.out.println("========================");
        System.out.println();
        final String name = Console.readLine("Name");
        final String email = Console.readLine("Email");
        final String phoneNumber = Console.readLine("Phone Number");

        try {
            GeneralDTO registeredUser = controller.addCandidate(name, email, phoneNumber);
            System.out.println("Customer registered successfully");
            //System.out.println("Username: "+registeredUser.get("username"));
            System.out.println("Name: " + registeredUser.get("name"));
            System.out.println("Email: " + registeredUser.get("email"));
            System.out.println("PhoneNumber: " + registeredUser.get("phoneNumber"));
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
