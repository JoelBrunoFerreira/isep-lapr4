package backoffice.presentation.operator;

import eapli.base.candidate.application.AddCandidateController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.representations.dto.GeneralDTO;
import mailClient.EmailService;
import org.hibernate.exception.ConstraintViolationException;

@SuppressWarnings("java:S106")
public class AddCandidateUI extends AbstractUI {
    private final AddCandidateController controller = new AddCandidateController();
    private final EmailService emailService = new EmailService();

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
            System.out.println("Candidate registered successfully");
            System.out.println("First Name: " + registeredUser.getOrDefault("firstName", firstName));
            String fName = registeredUser.getOrDefault("firstName", firstName).toString();
            System.out.println("Last Name: " + registeredUser.getOrDefault("lastName", lastName));
            String lName = registeredUser.getOrDefault("lastName", lastName).toString();
            System.out.println("Email: " + registeredUser.getOrDefault("email", email));
            String username = registeredUser.getOrDefault("email", email).toString();
            System.out.println("Phone Number: " + registeredUser.getOrDefault("phoneNumber", phoneNumber));
            System.out.println("Password: " + registeredUser.get("password"));
            String userPassword = registeredUser.get("password").toString();
            System.out.println("Role(s): " + registeredUser.get("roles").toString());
            System.out.println("================================");
            String emailBody = String.valueOf(buildEmail(fName, lName, username, userPassword));
            emailService.sendEmail(username, emailBody);
            System.out.println();
            reRunMenu();
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

    public void reRunMenu() {
        System.out.println("========================================");
        System.out.println("Do you want to register a new Candidate?");
        System.out.println("========================================");
        System.out.println();
        String anwser = Console.readLine("Enter an option: (y/n)");

        while(anwser.trim().isEmpty()) {
            anwser = Console.readLine("Enter an option: (y/n)");
        }
        if (anwser.equalsIgnoreCase("y")) {
            doShow();
        } else if (anwser.equalsIgnoreCase("n")) {
            new OperatorMainMenu();
        } else {
            System.out.println("Please choose a valid option! (y/n)");
            reRunMenu();
        }

    }

    public StringBuilder buildEmail(String firstName, String lastName, String username, String password) {
        StringBuilder message = new StringBuilder();
        message.append("==============================");
        message.append(System.getProperty("line.separator"));
        message.append("      Welcome to Jobs4u       ");
        message.append(System.getProperty("line.separator"));
        message.append("==============================");
        message.append(System.getProperty("line.separator"));
        message.append("Mr/Mrs " + firstName + " " + lastName + " thank you for registering our application.");
        message.append(System.getProperty("line.separator"));
        message.append("Your username is: " + username);
        message.append(System.getProperty("line.separator"));
        message.append("Your password is: " + password);
        message.append(System.getProperty("line.separator"));
        message.append("==============================");
        message.append(System.getProperty("line.separator"));

        return message;
    }
}
