package backoffice.presentation;

import backoffice.presentation.backofficeUser.SignupRequestAction;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.ChainedAction;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

public class BackofficeFrontMenu extends AbstractUI {
    private static final int EXIT_OPTION = 0;
    private static final int LOGIN_OPTION_1 = 1;
    private static final int LOGIN_OPTION_2 = 2;
    private static final int LOGIN_OPTION_3 = 3;
    private static final int SIGNUP_OPTION = 4;

    @Override
    public boolean show() {
        //drawFormTitle();
        return doShow();
    }
    /**
     * @return true if the user selected the exit option
     */
    @Override
    protected boolean doShow() {
        final var menu = new Menu();
        menu.addItem(LOGIN_OPTION_1, "Login as Admin", new ChainedAction(
                new LoginUI(new AuthenticationCredentialHandler(), BaseRoles.ADMIN)::show, () -> {
//            new AdminMainMenu().displayAdminMenu();
            return true;
        }));
        menu.addItem(LOGIN_OPTION_2, "Login as Customer Manager", new ChainedAction(
                new LoginUI(new AuthenticationCredentialHandler(), BaseRoles.CUSTOMER_MANAGER)::show, () -> {
            new CustomerManagerMainMenu().displayCustomerManagerMenu();
            return true;
        }));
        menu.addItem(LOGIN_OPTION_3, "Login as Operator", new ChainedAction(
                new LoginUI(new AuthenticationCredentialHandler(), BaseRoles.OPERATOR)::show, () -> {
            new OperatorMainMenu().displayOperatorMenu();
            return true;
        }));
        // TODO: instead of leaving the app, return to the main menu again
        menu.addItem(SIGNUP_OPTION, "Sign up", new SignupRequestAction());
        menu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        final var renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    @Override
    public String headline() {
        return "Jobs4u - Backoffice App";
    }
}
