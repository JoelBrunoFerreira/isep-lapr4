package eapli.base.customer.application;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.RegisterUserService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.GeneralDTO;

import java.util.Set;

public class AddCustomerController {

    private final AuthorizationService authz;
    private final CustomerRepository customerRepository;
    private final TransactionalContext autoTx;

    public AddCustomerController() {
        authz = AuthzRegistry.authorizationService();
        autoTx = PersistenceContext.repositories().newTransactionalContext();
        customerRepository = PersistenceContext.repositories().customers(autoTx);
    }

    public GeneralDTO addCustomer(final String name, final String email, final String address, final String acronym) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);

        GeneralDTO returnValue = null;
        try {
            autoTx.beginTransaction();
            RegisterUserService registerUserService = new RegisterUserService(autoTx);
            registerUserService.registerUser(email, name, acronym, email, Set.of(BaseRoles.CUSTOMER_USER));
            SystemUser user = registerUserService.getRegisteredSystemUser();
            customerRepository.save(new Customer(user, address));
            autoTx.commit();
            returnValue = registerUserService.getRegisteredSystemUserDTO();
        } catch (Exception e) {
            autoTx.rollback();
            throw e;
        }
        return returnValue;
    }

}
