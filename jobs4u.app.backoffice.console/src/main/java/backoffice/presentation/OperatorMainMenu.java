package backoffice.presentation;

import backoffice.Jobs4uBackofficeApp;
import backoffice.presentation.backofficeUser.AddCandidateUI;
import eapli.base.usermanagement.application.ListUsersController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OperatorMainMenu {
    static Scanner read = new Scanner(System.in);
    ListUsersController listUsersController = new ListUsersController();
    AddCandidateUI addCandidateUI = new AddCandidateUI();
    private static final int EXIT_OPTION = 0;
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int PREVIOUS_MENU = 4;
    public void displayOperatorMenu() {

        System.out.println("""
                =====================================
                |      Jobs4u - Operator Menu       |
                =====================================
                1. Register new Candidate
                2. List all Candidates
                3. Operator Option 3
                4. Back
                0. Exit
                =====================================
                
                """);

        int option = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter option number: ");

            try {
                option = read.nextInt();

                if (option >= EXIT_OPTION && option <= PREVIOUS_MENU) {
                    validInput = true;
                } else {
                    System.out.printf("Invalid option. Please enter a number between %d and %d \n", EXIT_OPTION, PREVIOUS_MENU);
                }
            } catch (InputMismatchException e) {
                System.out.printf("Invalid input. Please enter a number between %d and %d \n", EXIT_OPTION, PREVIOUS_MENU);
                read.nextLine();
            }
        }
        switch (option) {
            case OPTION_1:
                addCandidateUI.doShow();
                break;
            case OPTION_2:
                System.out.println(listUsersController.listAllCandidates());
                break;
            case OPTION_3:
                System.out.println("Not implemented yet");
                break;
            case PREVIOUS_MENU:
                Jobs4uBackofficeApp.main(null);
                break;
            case EXIT_OPTION:
                System.out.println("Bye, Bye");
                System.exit(0);
                break;
            default:
                System.out.printf("Invalid input. Please enter a number between %d and %d.\n", EXIT_OPTION, PREVIOUS_MENU);
        }
    }
}
