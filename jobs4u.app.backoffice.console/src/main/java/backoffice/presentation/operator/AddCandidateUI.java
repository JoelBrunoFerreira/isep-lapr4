package backoffice.presentation.operator;

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
        final String firstName = Console.readLine("First Name");
        final String lastName = Console.readLine("Last Name");
        final String email = Console.readLine("Email");
        final String phoneNumber = Console.readLine("Phone Number");

        try {
            GeneralDTO registeredUser = controller.addCandidate(firstName, lastName, email, phoneNumber);
            System.out.println();
            System.out.println("================================");
            System.out.println("Customer registered successfully");
            System.out.println("First Name: " + registeredUser.getOrDefault("firstName", firstName));
            System.out.println("Last Name: " + registeredUser.getOrDefault("lastName", lastName));
            System.out.println("Email: " + registeredUser.getOrDefault("email", email));
            System.out.println("Phone Number: " + registeredUser.getOrDefault("phoneNumber", phoneNumber));
            System.out.println("Password: " + registeredUser.get("password"));
            System.out.println("Role(s): " + registeredUser.get("roles").toString());
            System.out.println("================================");
            System.out.println();
        } catch (IntegrityViolationException | ConstraintViolationException e) {
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
