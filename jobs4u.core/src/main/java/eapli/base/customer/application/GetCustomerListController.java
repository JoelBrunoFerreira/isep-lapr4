package eapli.base.customer.application;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class GetCustomerListController {
    AuthorizationService authz;
    CustomerRepository customerRepository;
    UserRepository us;


    public GetCustomerListController() {
        this.authz = AuthzRegistry.authorizationService();
        this.customerRepository =  PersistenceContext.repositories().customers();
    }

    public Iterable<Customer> getCustomerList() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        return customerRepository.findAll();
    }
}
