package backoffice.presentation.users;

import backoffice.presentation.authz.ActivateUserAction;
import backoffice.presentation.authz.AddUserUI;
import backoffice.presentation.authz.DeactivateUserAction;
import backoffice.presentation.authz.ListUsersAction;
import eapli.base.Application;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;

public class UsersMenu {
  private static final String SEPARATOR_LABEL = "--------------";

  private static final int ADD_USER_OPTION = 1;
  private static final int LIST_USERS_OPTION = 2;
  private static final int DEACTIVATE_USER_OPTION = 3;
  private static final int ACTIVATE_USER_OPTION = 4;
  private static final int EXIT_OPTION = 0;

  // LIST USERS SUBMENU
//  private static final int LIST_CUSTOMER_MANAGER_OPTION = 1;
//  private static final int LIST_OPERATORS_OPTION = 2;
//  private static final int LIST_CUSTOMERS_OPTION = 3;
//  private static final int LIST_CANDIDATES_OPTION = 4;
//  private static final int LIST_ALL_OPTION = 5;

  private static final String RETURN_LABEL = "Return ";


  public Menu buildUsersMenu() {
    final Menu menu = new Menu("Users >");

    final Menu listUsersMenu = new Menu("List Users >");

    if (!Application.settings().isMenuLayoutHorizontal())
      listUsersMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));

    listUsersMenu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

    menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
    menu.addItem(LIST_USERS_OPTION, "List Users",new ListUsersAction());
    menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
    menu.addItem(ACTIVATE_USER_OPTION, "Activate User", new ActivateUserAction());

    if (!Application.settings().isMenuLayoutHorizontal())
      menu.addItem(MenuItem.separator(SEPARATOR_LABEL));

    menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

    return menu;
  }
}
