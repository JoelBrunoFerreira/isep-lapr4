package backoffice.presentation.customermanager;

import backoffice.Jobs4uBackofficeApp;
import backoffice.presentation.candidates.DisplayCandidateDataUI;
import backoffice.presentation.customermanager.JobOpeningManagement.ListJobOpeningsUI;
import backoffice.presentation.customermanager.JobOpeningManagement.RegisterJobOpeningUI;
import backoffice.presentation.customermanager.JobOpeningManagement.SetupRecruitmentPhasesUI;
import eapli.base.Application;
import eapli.base.JobOpeningManagement.application.RegisterJobOpeningController;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerManagerMainMenu {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN_LABEL = "Return ";
    private static final int EXIT_OPTION = 0;
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int OPTION_4 = 4;
    private static final int OPTION_5 = 5;
    private static final int OPTION_6 = 6;
    private static final int OPTION_7 = 7;
    private static final int OPTION_8 = 8;
    private static final int OPTION_9 = 9;
    private static final int PREVIOUS_MENU = 10;


    public void displayCustomerManagerMenu() {
        while (true) {
            System.out.println("""
                    =====================================
                    |  Jobs4u - Customer Manager Menu   |
                    =====================================
                    1. Register Customer
                    2. List Customers
                    3. Register Job Opening
                    4. List Job Openings
                    5. Setup Recruitment Process Phases
                    6. Select Job Requirements
                    7. Select Interview Model
                    8. Display candidate's personal data
                    9. Display candidate's personal data and applications
                    0. Exit
                    =====================================
                    """);
            System.out.println();


            int option = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Enter option number: ");

                try {
                    option = Console.readInteger("");

                    if (option >= EXIT_OPTION && option <= PREVIOUS_MENU) {
                        validInput = true;
                    } else {
                        System.out.printf("Invalid option. Please enter a number between %d and %d \n", EXIT_OPTION, PREVIOUS_MENU);
                    }
                } catch (InputMismatchException e) {
                    System.out.printf("Invalid input. Please enter a number between %d and %d \n", EXIT_OPTION, PREVIOUS_MENU);
                    Console.readLine("");
                }
            }
            switch (option) {
                case OPTION_1:
                    System.out.println("Not implemented yet");
                    break;
                case OPTION_2:
                    System.out.println("Not implemented yet");
                    break;
                case OPTION_3:
                    new RegisterJobOpeningUI().show();
                    break;
                case OPTION_4:
                    new ListJobOpeningsUI().show();
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
                case OPTION_8:
                    new DisplayCandidateDataUI().show();
                    break;
                case OPTION_9:
                    //new DisplayCandidateDataAndJobApplicationsUI();
                    System.out.println("Not implemented yet");
                    break;
                case PREVIOUS_MENU:
                    Jobs4uBackofficeApp.main(null);
                    break;
                case EXIT_OPTION:
                    System.out.println("Bye, Bye");
                    System.exit(0);
                    return;
                default:
                    System.out.printf("Invalid input. Please enter a number between %d and %d.\n", EXIT_OPTION, PREVIOUS_MENU);
            }
        }
    }
    public Menu buildCustomerManagerMenu() {
        final Menu menu = new Menu("Actions >");
        final Menu customersMenu = new Menu("Customers >");
        customersMenu.addItem(OPTION_1, "List Customers", new ListJobOpeningsUI()::show);
        customersMenu.addItem(OPTION_2, "Register Customer", new RegisterJobOpeningUI()::show);
        if (!Application.settings().isMenuLayoutHorizontal())
            customersMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        customersMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        final Menu jobOpeningMenu = new Menu("Job Opening Management >");
        jobOpeningMenu.addItem(OPTION_1, "List Job Openings", new ListJobOpeningsUI()::show);
        jobOpeningMenu.addItem(OPTION_2, "Register Job Openings", new RegisterJobOpeningUI()::show);
        jobOpeningMenu.addItem(OPTION_3, "Setup Recruitment Process Phases", new SetupRecruitmentPhasesUI()::show);
        if (!Application.settings().isMenuLayoutHorizontal())
            jobOpeningMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        jobOpeningMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        menu.addSubMenu(OPTION_1, customersMenu);
        menu.addSubMenu(OPTION_2, jobOpeningMenu);

        if (!Application.settings().isMenuLayoutHorizontal())
            menu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
