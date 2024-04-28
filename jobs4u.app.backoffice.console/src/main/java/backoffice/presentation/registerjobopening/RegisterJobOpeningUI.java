package backoffice.presentation.registerjobopening;

import backoffice.presentation.AdminMainMenu;
import backoffice.presentation.CustomerManagerMainMenu;
import backoffice.presentation.OperatorMainMenu;
import backoffice.presentation.backofficeUser.SignupRequestAction;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.customermanagement.domain.Customer;
import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.ChainedAction;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.Scanner;


public class RegisterJobOpeningUI extends AbstractUI {

    private static final int EXIT_OPTION = 0;
    private static final int LOGIN_OPTION_1 = 1;
    private static final int LOGIN_OPTION_2 = 2;
    private static final int LOGIN_OPTION_3 = 3;
    private static final int SIGNUP_OPTION = 4;

    private Scanner scanner;

    @Override
    public boolean show() {
        //drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        scanner = new Scanner(System.in);

        System.out.println("Register a new job opening:");

        System.out.print("Job Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Company Address: ");
        String companyAddress = scanner.nextLine();

        System.out.print("Number of Vacancies: ");
        int numberVacancies = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Working Mode: ");
        String mode = scanner.nextLine();

        System.out.print("Contract Type: ");
        String contractType = scanner.nextLine();

        // Create the JobOpening object with the collected details
        JobOpening jobOpening = new JobOpening(title, description, company, companyAddress,
                numberVacancies, mode, contractType, customer);

        // You can perform further actions with the jobOpening object here

        // Return false to indicate that the user did not select the exit option
        return false;
    }

    @Override
    public String headline() {
        return "Jobs4u - Backoffice App";
    }
}
