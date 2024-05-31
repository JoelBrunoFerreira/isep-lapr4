package candidate.presentation;

import candidate.application.CandidateLoginController;
import customer.application.CustomerLoginController;
import eapli.base.candidate.domain.Candidate;
import eapli.framework.io.util.Console;

public class LoginUI {
    private final CandidateLoginController controller;

    public LoginUI() {
        controller = new CandidateLoginController();
    }

    public boolean login(){
        while (true){
            String username = Console.readNonEmptyLine("Email: ", "Enter a valid email.");
            String password = Console.readNonEmptyLine("Password: ", "Enter a valid password.");

            try {
                if (controller.login(username, password)){
                    System.out.println("Login successful.");
                    return true;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
}
