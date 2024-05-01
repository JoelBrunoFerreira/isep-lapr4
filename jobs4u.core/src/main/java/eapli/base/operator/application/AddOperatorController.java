package eapli.base.operator.application;

import eapli.base.customerManager.domain.CustomerManager;
import eapli.base.customerManager.repository.CustomerManagerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.operator.domain.Operator;
import eapli.base.operator.repository.OperatorRepository;
import eapli.base.usermanagement.application.RegisterUserService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.representations.dto.GeneralDTO;

import java.util.Set;

public class AddOperatorController {


    private final AuthorizationService authz;
    private final OperatorRepository operatorRepository;
    private final TransactionalContext autoTx;

    public AddOperatorController() {
        authz = AuthzRegistry.authorizationService();
        autoTx = PersistenceContext.repositories().newTransactionalContext();
        operatorRepository = PersistenceContext.repositories().operators(autoTx);
    }

    public GeneralDTO addOperator(final String fName, final String lName, final String email) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);

        GeneralDTO returnValue = null;
        try {
            autoTx.beginTransaction();
            RegisterUserService registerUserService = new RegisterUserService(autoTx);
            registerUserService.registerUser(email, fName, lName, email, Set.of(BaseRoles.OPERATOR));
            operatorRepository.save(new Operator(registerUserService.getRegisteredSystemUser(), fName,lName));
            autoTx.commit();
            returnValue = registerUserService.getRegisteredSystemUserDTO();
        } catch (Exception e) {
            autoTx.rollback();
            throw e;
        }
        return returnValue;
    }

}
