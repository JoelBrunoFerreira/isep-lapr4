package backoffice.presentation;

import backoffice.presentation.CustomerManager.CustomerManagerMainMenu;
import backoffice.presentation.users.UsersMenu;
import eapli.base.Application;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

public class MainMenu extends AbstractUI {

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int USERS_OPTION = 1;

    private static final int MY_USER_OPTION = 2;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;

        if (Application.settings().isMenuLayoutHorizontal())
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        else
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);

        return renderer.render();
    }

    @Override
    public String headline() {
        return authz.session().map(s -> "jobs4u [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("jobs4u App [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {

            final Menu usersMenu = new UsersMenu().buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);

            final Menu myUserMenu = new MyUserMenu();
            mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);
        }
        else if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CUSTOMER_MANAGER)){
            final Menu customerManagerMenu = new CustomerManagerMainMenu().buildCustomerManagerMenu();
            mainMenu.addSubMenu(USERS_OPTION, customerManagerMenu);
            final Menu myUserMenu = new MyUserMenu();
            mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);
        }
        else if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.OPERATOR)){
            new OperatorMainMenu().displayOperatorMenu();
        }
        else if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CANDIDATE_USER)){
            new BackofficeFrontMenu().show();
        }
        if (!Application.settings().isMenuLayoutHorizontal())
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

}

