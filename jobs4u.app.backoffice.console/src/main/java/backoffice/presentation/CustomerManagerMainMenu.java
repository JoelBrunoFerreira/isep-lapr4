package backoffice.presentation;

import backoffice.Jobs4uBackofficeApp;
import backoffice.presentation.JobOpeningManagement.ListJobOpeningsUI;
import backoffice.presentation.JobOpeningManagement.RegisterJobOpeningUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerManagerMainMenu {
    static Scanner read = new Scanner(System.in);
    private static final int EXIT_OPTION = 0;
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int OPTION_4 = 4;
    private static final int OPTION_5 = 5;
    private static final int OPTION_6 = 6;
    private static final int OPTION_7 = 7;
    private static final int PREVIOUS_MENU = 8;
    public void displayCustomerManagerMenu() {

        System.out.println("""
                =====================================
                |  Jobs4u - Customer Manager Menu   |
                =====================================
                1. Register a Customer
                2. Register a Job Opening
                3. Customer Manager Option 3
                4. Back
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
                System.out.println("Not implemented yet");
                break;
            case OPTION_2:
                new RegisterJobOpeningUI().show();
                break;
            case OPTION_3:
                new ListJobOpeningsUI().show();
                System.out.println("Not implemented yet");
                break;
            case OPTION_4:
                //new SetupJobOpeningPhasesUI();
                System.out.println("Not implemented yet");
                break;
            case OPTION_5:
                //new SelectJobOpeningRequirementsUI();
                System.out.println("Not implemented yet");
                break;
            case OPTION_6:
                //new SelectJobOpeningInterviewModelUI();
                System.out.println("Not implemented yet");
                break;
            case OPTION_7:
                //new DisplayCandidatesUI();
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
