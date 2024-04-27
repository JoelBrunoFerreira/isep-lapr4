package backoffice.presentation;

import backoffice.presentation.authz.AddUserUI;
import backoffice.presentation.authz.DeactivateUserAction;
import backoffice.presentation.authz.ListUsersAction;
import eapli.base.Application;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
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

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int PREVIOUS_MENU = 4;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 1;
    private static final int JOB_OPENING_OPTION = 6;

    // JOB OPENING
    private static final int CREATE_JOB_OPENING_OPTION = 1;
    private static final int LIST_JOB_OPENING_OPTION = 2;

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
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "jobs4u [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("jobs4u [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

//        final Menu myUserMenu = new MyUserMenu();
//        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.ADMIN,
                BaseRoles.POWER_USER)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);

        }
//        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER,
//                BaseRoles.CUSTOMER_MANAGER)) {
//            final Menu jobOpeningMenu = buildJobOpeningMenu();
//            mainMenu.addSubMenu(JOB_OPENING_OPTION, jobOpeningMenu);
//        }
//        if (authz.isAuthenticatedUserAuthorizedTo(CafeteriaRoles.POWER_USER,
//                CafeteriaRoles.MENU_MANAGER)) {
//            final Menu dishTypeMenu = buildDishMenu();
//            mainMenu.addSubMenu(DISH_OPTION, dishTypeMenu);
//            final Menu menusMenu = buildMealsMenu();
//            mainMenu.addSubMenu(MEALS_OPTION, menusMenu);
//            // reporting
//            final Menu reportingDishesMenu = buildReportingDishesMenu();
//            mainMenu.addSubMenu(REPORTING_DISHES_OPTION, reportingDishesMenu);
//        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
//        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
//                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }


//    private Menu buildJobOpeningMenu() {
//        final Menu menu = new Menu("Job Opening >");
//
//        menu.addItem(CREATE_JOB_OPENING_OPTION, "Create Job Opening",
//                new RegisterMaterialAction());
//        menu.addItem(LIST_JOB_OPENING_OPTION, "List all Job Openings", new ListMaterialAction());
//
//        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
//
//        return menu;
//    }



}

