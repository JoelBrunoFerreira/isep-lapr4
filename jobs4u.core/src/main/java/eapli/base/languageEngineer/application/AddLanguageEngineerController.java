package eapli.base.languageEngineer.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.languageEngineer.domain.LanguageEngineer;
import eapli.base.languageEngineer.repository.LanguageEngineerRepository;
import eapli.base.usermanagement.application.RegisterUserService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.representations.dto.GeneralDTO;

import java.util.Set;

public class AddLanguageEngineerController{
        private final AuthorizationService authz;
        private final LanguageEngineerRepository repo;
        private final TransactionalContext autoTx;

        public AddLanguageEngineerController() {
            authz = AuthzRegistry.authorizationService();
            autoTx = PersistenceContext.repositories().newTransactionalContext();
            repo = PersistenceContext.repositories().languageEngineers(autoTx);
        }

        public GeneralDTO addLanguageEngineer(final String fName, final String lName, final String email) {
            authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);

            GeneralDTO returnValue = null;
            try {
                autoTx.beginTransaction();
                RegisterUserService registerUserService = new RegisterUserService(autoTx);
                registerUserService.registerUser(email, fName, lName, email, Set.of(BaseRoles.LANGUAGE_ENGINEER));
                repo.save(new LanguageEngineer(registerUserService.getRegisteredSystemUser(), fName, lName));
                autoTx.commit();
                returnValue = registerUserService.getRegisteredSystemUserDTO();
            } catch (Exception e) {
                autoTx.rollback();
                throw e;
            }
            return returnValue;
        }
}