package backoffice.presentation.CustomerManager;

import backoffice.Jobs4uBackofficeApp;
import backoffice.presentation.CustomerManager.JobOpeningManagement.*;
import backoffice.presentation.candidates.DisplayCandidateDataUI;
import backoffice.presentation.CustomerManager.customer.AddCustomerUI;
import eapli.base.Application;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;

import java.util.InputMismatchException;

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
        //TODO customersMenu.addItem(OPTION_1, "List Customers", new ListJobOpeningsUI()::show);
        customersMenu.addItem(OPTION_2, "Register Customer", new AddCustomerUI()::show);
        if (!Application.settings().isMenuLayoutHorizontal())
            customersMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        customersMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        final Menu jobOpeningMenu = new Menu("Job Opening Management >");
        jobOpeningMenu.addItem(OPTION_1, "List Job Openings", new ListJobOpeningsUI()::show);
        jobOpeningMenu.addItem(OPTION_2, "Register Job Openings", new RegisterJobOpeningUI()::show);
        jobOpeningMenu.addItem(OPTION_3, "Setup Recruitment Process Phases", new SetupRecruitmentPhasesUI()::show);
        jobOpeningMenu.addItem(OPTION_3, "Select Requirement Specifications", new SelectRequirementsSpecificationsUI()::show);
        jobOpeningMenu.addItem(OPTION_3, "Select Interview Model", new SelectInterviewModelUI()::show);
        if (!Application.settings().isMenuLayoutHorizontal())
            jobOpeningMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        jobOpeningMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        final Menu candidatesMenu = new Menu("Candidates >");
        candidatesMenu.addItem(OPTION_1, "Display Candidates", new DisplayCandidateDataUI()::show);
        //TODO candidatesMenu.addItem(OPTION_2, "Display Candidates Applications Customer", new RegisterJobOpeningUI()::show);
        if (!Application.settings().isMenuLayoutHorizontal())
            candidatesMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        candidatesMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        menu.addSubMenu(OPTION_1, customersMenu);
        menu.addSubMenu(OPTION_2, jobOpeningMenu);
        menu.addSubMenu(OPTION_3, candidatesMenu);

        if (!Application.settings().isMenuLayoutHorizontal())
            menu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}

