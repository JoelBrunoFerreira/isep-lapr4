package customer.presentation;

import customer.presentation.customerUser.SignupRequestAction;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.ChainedAction;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

public class CustomerFrontMenu extends AbstractUI {
    private static final int EXIT_OPTION = 0;
    private static final int LOGIN_OPTION = 1;
    private static final int SIGNUP_OPTION = 2;

    @Override
    public boolean show() {
        //drawFormTitle();
        return doShow();
    }
    @Override
    public boolean doShow() {
        final var menu = new Menu();
        menu.addItem(LOGIN_OPTION, "Login", new ChainedAction(
                new LoginUI(new AuthenticationCredentialHandler(), BaseRoles.CUSTOMER_USER)::show, () -> {
            new CustomerMainMenu().displayCustomerMenu();
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
        return "Jobs4u - Customer App";
    }
}
