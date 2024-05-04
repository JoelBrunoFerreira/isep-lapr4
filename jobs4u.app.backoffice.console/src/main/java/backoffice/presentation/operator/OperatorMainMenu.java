package backoffice.presentation.operator;

import backoffice.Jobs4uBackofficeApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OperatorMainMenu {
    static Scanner read = new Scanner(System.in);
    ListCandidateUI listCandidateUI = new ListCandidateUI();
    AddCandidateUI addCandidateUI = new AddCandidateUI();
    RegisterJobApplicationUI registerJobApplicationUI = new RegisterJobApplicationUI();
    private static final int EXIT_OPTION = 0;
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int LOGOUT = 4;
    public void displayOperatorMenu() {

        System.out.println("""
                =====================================
                |      Jobs4u - Operator Menu       |
                =====================================
                1. Register new Candidate
                2. List all Candidates
                3. Register Job Application
                3. Logout
                0. Exit
                =====================================
                
                """);
        System.out.println();


        int option = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter option number: ");

            try {
                option = read.nextInt();

                if (option >= EXIT_OPTION && option <= LOGOUT) {
                    validInput = true;
                } else {
                    System.out.printf("Invalid option. Please enter a number between %d and %d \n", EXIT_OPTION, LOGOUT);
                }
            } catch (InputMismatchException e) {
                System.out.printf("Invalid input. Please enter a number between %d and %d \n", EXIT_OPTION, LOGOUT);
                read.nextLine();
            }
        }
        switch (option) {
            case OPTION_1:
                addCandidateUI.doShow();
                break;
            case OPTION_2:
                listCandidateUI.doShow();
                break;
            case OPTION_3:
                registerJobApplicationUI.doShow();
                break;
            case LOGOUT:
                Jobs4uBackofficeApp.main(null);
                break;
            case EXIT_OPTION:
                System.out.println("Bye, Bye");
                System.exit(0);
                break;
            default:
                System.out.printf("Invalid input. Please enter a number between %d and %d.\n", EXIT_OPTION, LOGOUT);
        }
    }
}
