package eapli.base.customerManager.application;

import eapli.base.customerManager.domain.CustomerManager;
import eapli.base.customerManager.dto.CustomerManagerDTO;
import eapli.base.customerManager.repository.CustomerManagerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class ListCustomerManagerController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final CustomerManagerRepository repo = PersistenceContext.repositories().customerManagers();
    private final CustomerManagerService customerManagerService = new CustomerManagerService(repo);

    public Iterable<CustomerManagerDTO> allTeachers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);

        return this.customerManagerService.allCustomerManagers();
    }

    public Iterable<CustomerManager> allCustomerManagers() {
        return null;
    }
}
