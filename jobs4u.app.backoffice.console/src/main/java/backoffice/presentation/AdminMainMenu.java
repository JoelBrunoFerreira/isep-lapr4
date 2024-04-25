package backoffice.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMainMenu {

    static Scanner read = new Scanner(System.in);
    private static final int EXIT_OPTION = 0;
    private static final int ADD_USER = 1;
    private static final int ENABLE_DISABLE = 2;
    private static final int LIST_USERS = 3;
    private static final int PREVIOUS_MENU = 4;

    public void displayAdminMenu() {


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
            case ADD_USER:
                //addUser()
                break;
            case ENABLE_DISABLE:
                //enableDisableUser()
                break;
            case LIST_USERS:
                //listUsers()
                break;
            case PREVIOUS_MENU:
                //previousMenu()
                break;
            case EXIT_OPTION:
                System.exit(0);
                break;
            default:
                System.out.printf("Invalid input. Please enter a number between %d and %d.\n", EXIT_OPTION, PREVIOUS_MENU);
        }
    }
}

