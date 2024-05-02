/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package backoffice.presentation.authz;

import backoffice.presentation.customermanager.customerManagement.CustomerManagerDataWidget;
import eapli.base.app.common.console.presentation.customer.CustomerDataWidget;
import eapli.base.customerManager.application.AddCustomerManagerController;
import eapli.base.operator.application.AddOperatorController;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.HashSet;
import java.util.Set;

/**
 * UI for adding a user to the application.
 * <p>
 * Created by nuno on 22/03/16.
 */
@SuppressWarnings("java:S106")
public class AddUserUI extends AbstractUI {

    private final AddUserController theController = new AddUserController();
    private final AddCustomerManagerController customerManagerController = new AddCustomerManagerController();
    private final AddOperatorController operatorController = new AddOperatorController();



    @Override
    protected boolean doShow() {

        final Set<Role> roleTypes = new HashSet<>();
        boolean show;
        do {
            show = showRoles(roleTypes);
        } while (!show);

        try {
            for (Role role : roleTypes) {
                if (role.equals(BaseRoles.CUSTOMER_MANAGER)) {
                    final CustomerManagerDataWidget userData = new CustomerManagerDataWidget();
                    userData.show();
                    customerManagerController.addCustomerManager(userData.firstName(),
                            userData.lastName(), userData.email());

                } else if (role.equals(BaseRoles.OPERATOR)) {
                    final OperatorDataWidget userData = new OperatorDataWidget();
                    userData.show();
                    operatorController.addOperator(userData.firstName(),
                            userData.lastName(), userData.email());

                } else if (role.equals(BaseRoles.CUSTOMER_USER)) {
                    final CustomerDataWidget userData = new CustomerDataWidget();
                    userData.show();
                    theController.addCustomer(userData.username(), userData.password(), userData.firstName(),
                            userData.lastName(), userData.email(), userData.address(),
                            userData.acronym());
                }
            }
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("That username is already in use.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating the account: " + e.getMessage() + ". Please try again.\n");
            return true;
        }

        return false;
//        // FIXME avoid duplication with SignUpUI. reuse UserDataWidget from
//        // UtenteApp
//        final String email = Console.readLine("E-Mail");
//        final String username = email;
//        final String password = Console.readLine("Password");
//        final String firstName = Console.readLine("First Name");
//        final String lastName = Console.readLine("Last Name");
//
//
//        final Set<Role> roleTypes = new HashSet<>();
//        boolean show;
//        do {
//            show = showRoles(roleTypes);
//        } while (!show);
//
//        try {
//            this.theController.addUser(username, password, firstName, lastName, email, roleTypes);
//        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
//            System.out.println("That username is already in use.");
//        }
//
//        return false;
    }

    private boolean showRoles(final Set<Role> roleTypes) {
        // TODO we could also use the "widget" classes from the framework...
        final Menu rolesMenu = buildRolesMenu(roleTypes);
        final MenuRenderer renderer = new VerticalMenuRenderer(rolesMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildRolesMenu(final Set<Role> roleTypes) {
        final Menu rolesMenu = new Menu();
        int counter = 1;
//        rolesMenu.addItem(MenuItem.of(counter++, "No Role", Actions.SUCCESS));
        for (final Role roleType : theController.getBackofficeRoleTypes()) {
            rolesMenu.addItem(
                    MenuItem.of(counter++, roleType.toString(), () -> roleTypes.add(roleType)));
        }
        return rolesMenu;
    }

    @Override
    public String headline() {
        return "Add User";
    }
}
