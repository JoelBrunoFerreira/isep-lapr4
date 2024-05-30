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
            String emailBody = buildEmailHTML(fName, lName, username, userPassword);
            emailService.sendEmail(username, emailBody);
            reRunMenu();
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

    public String buildEmailHTML(String firstName, String lastName, String username, String password) {

        String HTML =
                """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Email</title>
                </head>
                <body>
                    <h1>Welcome to Jobs4u</h1>
                    <p>Mr./Mrs. %s %s thank you for registering on our app.</p>
                    <p>Your username is: %s</p>
                    <p>Your password is: %s</p>
                    <p>Best of luck!</p>
                    <br>
                    <footer>
                        <p>Made with ❤ by Code Warriors - All rights reserved</p>
                    </footer>
                </body>
                </html>
                """;

        return String.format(HTML, firstName, lastName, username, password);
    }
}
