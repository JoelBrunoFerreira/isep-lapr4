package eapli.base.customer.domain;

import eapli.base.usermanagement.application.RegisterUserService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Disabled("This test was disabled by your System Administrator")
    @Test
    public void ensureCustomerUserHasName(){

        RegisterUserService registerUserService = new RegisterUserService();
        registerUserService.registerUser("USERNAME", "FIRSTNAME", "LASTNAME",
                "EMAIL", Set.of(BaseRoles.CUSTOMER_USER));
        SystemUser user = registerUserService.getRegisteredSystemUser();

        Customer customer = new Customer(user, "ADDRESS");

        assertEquals(customer.getName().toString(), "FIRSTNAME");

    }

    @Disabled("This test was disabled by your System Administrator")
    @Test
    public void ensureCustomerUserHasEmail(){

        RegisterUserService registerUserService = new RegisterUserService();
        registerUserService.registerUser("USERNAME", "FIRSTNAME", "LASTNAME",
                "EMAIL", Set.of(BaseRoles.CUSTOMER_USER));
        SystemUser user = registerUserService.getRegisteredSystemUser();

        Customer customer = new Customer(user, "ADDRESS");

        assertEquals(customer.getName().toString(), "EMAIL");

    }

    @Disabled("This test was disabled by your System Administrator")
    @Test
        public void ensureSystemUserIsCreated(){
            RegisterUserService registerUserService = new RegisterUserService();
            registerUserService.registerUser("USERNAME", "FIRSTNAME", "LASTNAME",
                    "EMAIL", Set.of(BaseRoles.CUSTOMER_USER));
            SystemUser user = registerUserService.getRegisteredSystemUser();

            assertNotNull(user);
        }

}