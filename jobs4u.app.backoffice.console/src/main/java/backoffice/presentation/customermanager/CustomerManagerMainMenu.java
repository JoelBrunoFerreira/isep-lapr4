package backoffice.presentation.customermanager;

import backoffice.Jobs4uBackofficeApp;
import backoffice.presentation.customermanager.JobOpeningManagement.ListJobOpeningsUI;
import backoffice.presentation.customermanager.JobOpeningManagement.RegisterJobOpeningUI;
import eapli.base.Application;
import eapli.base.JobOpeningManagement.application.RegisterJobOpeningController;
import eapli.base.JobOpeningManagement.domain.WorkingMode;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerManagerMainMenu {
    RegisterJobOpeningController tester = new RegisterJobOpeningController();

    private JobOpeningRepository jobOpeningRepository;
    ListUsersController listUsersController = new ListUsersController();
    private static final String SEPARATOR_LABEL = "--------------";

    private static final int CUSTOMER_MENU = 1;
    private static final int JOB_OPENING_MENU = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int EXIT_OPTION = 0;

    // LIST USERS SUBMENU
    private static final int LIST_CUSTOMER_MANAGER_OPTION = 1;
    private static final int LIST_OPERATORS_OPTION = 2;
    private static final int LIST_CUSTOMERS_OPTION = 3;
    private static final int LIST_CANDIDATES_OPTION = 4;
    private static final int LIST_ALL_OPTION = 5;

    private static final String RETURN_LABEL = "Return ";
    static Scanner read = new Scanner(System.in);
    private static final int OPTION_1 = 1;
    private static final int OPTION_2 = 2;
    private static final int OPTION_3 = 3;
    private static final int OPTION_4 = 4;
    private static final int OPTION_5 = 5;
    private static final int OPTION_6 = 6;
    private static final int OPTION_7 = 7;
    private static final int PREVIOUS_MENU = 8;

    public CustomerManagerMainMenu() {
        //this.jobOpeningRepository = PersistenceContext.repositories().jobOpenings();;
    }

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
                    5. Select Recruitment Process
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
    public Menu buildUsersMenu() {
        final Menu menu = new Menu("Actions >");
        final Menu customersMenu = new Menu("Customers >");
        customersMenu.addItem(LIST_CUSTOMER_MANAGER_OPTION, "List Customers", new ListJobOpeningsUI()::show);
        customersMenu.addItem(LIST_OPERATORS_OPTION, "Register Customer", new RegisterJobOpeningUI()::show);
        if (!Application.settings().isMenuLayoutHorizontal())
            customersMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        customersMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        final Menu jobOpeningMenu = new Menu("Job Openings >");
        jobOpeningMenu.addItem(LIST_CUSTOMER_MANAGER_OPTION, "List Job Openings", new ListJobOpeningsUI()::show);
        jobOpeningMenu.addItem(LIST_OPERATORS_OPTION, "Register Job Openings", new RegisterJobOpeningUI()::show);
        if (!Application.settings().isMenuLayoutHorizontal())
            jobOpeningMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        jobOpeningMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        menu.addSubMenu(CUSTOMER_MENU, customersMenu);
        menu.addSubMenu(JOB_OPENING_MENU, jobOpeningMenu);

        if (!Application.settings().isMenuLayoutHorizontal())
            menu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
