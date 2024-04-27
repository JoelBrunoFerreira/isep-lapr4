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
package eapli.base.infrastructure.bootstrapers;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    private static final String PASSWORD1 = "Pa$$word1";

    @Override
    public boolean execute() {
        registerAdmin("admin", "AdminBoss1", "Joel", "Ferreira", "joel@email.com");
        registerCandidate("candidate1", PASSWORD1, "John", "Smith","john@email.com");
        registerCandidate("candidate2", PASSWORD1, "Mary", "Smith","mary@email.com");
        registerCustomer("customer1", "Password1", "Billy", "Bob","billy@email.com");
        registerCustomer("customer2", "Password1", "Sponge", "Bob","sponge@email.com");
        registerCustomerManager("manager1", PASSWORD1, "Johnny", "Cash", "johnny@email.com");
        registerCustomerManager("manager2", PASSWORD1, "Rachel", "Walsh", "rachek@email.com");
        registerOperator("operator1", PASSWORD1, "Luís", "Figo", "figo@email.com");
        registerOperator("operator2", PASSWORD1, "Paolo", "Maldini", "maldini@email.com");
        return true;
    }

    /**
        Register Jobs4u Users
     */
    private void registerAdmin(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCandidate(final String username, final String password,
                                  final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CANDIDATE_USER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCustomer(final String username, final String password,
                                  final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CUSTOMER_USER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerOperator(final String username, final String password,
                                  final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.OPERATOR);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCustomerManager(final String username, final String password,
                                         final String firstName, final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.CUSTOMER_MANAGER);

        registerUser(username, password, firstName, lastName, email, roles);
    }
}
