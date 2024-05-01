package eapli.base.customerManager.application;

import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.base.customerManager.domain.CustomerManager;
import eapli.base.customerManager.repository.CustomerManagerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.RegisterUserService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.representations.dto.GeneralDTO;

import java.util.Set;

public class AddCustomerManagerController {
    private final AuthorizationService authz;
    private final CustomerManagerRepository customerManagerRepository;
    private final TransactionalContext autoTx;

    public AddCustomerManagerController() {
        authz = AuthzRegistry.authorizationService();
        autoTx = PersistenceContext.repositories().newTransactionalContext();
        customerManagerRepository = PersistenceContext.repositories().customerManagers(autoTx);
    }

    public GeneralDTO addCustomerManager(final String fName, final String lName, final String email) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);

        GeneralDTO returnValue = null;
        try {
            autoTx.beginTransaction();
            RegisterUserService registerUserService = new RegisterUserService(autoTx);
            registerUserService.registerUser(email, fName, lName, email, Set.of(BaseRoles.CUSTOMER_MANAGER));
            customerManagerRepository.save(new CustomerManager(registerUserService.getRegisteredSystemUser(), fName,lName));
            autoTx.commit();
            returnValue = registerUserService.getRegisteredSystemUserDTO();
        } catch (Exception e) {
            autoTx.rollback();
            throw e;
        }
        return returnValue;
    }

}
