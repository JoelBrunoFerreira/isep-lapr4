package eapli.base.candidate.application;

import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.RegisterUserService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.representations.dto.GeneralDTO;

import java.util.Set;

@UseCaseController
public class AddCandidateController {
    private final AuthorizationService authz;
    private final CandidateRepository candidateRepository;
    private final TransactionalContext autoTx;

    public AddCandidateController() {
        authz = AuthzRegistry.authorizationService();
        autoTx = PersistenceContext.repositories().newTransactionalContext();
        candidateRepository = PersistenceContext.repositories().candidates(autoTx);
    }

    public GeneralDTO addCandidate(final String firstName, final String lastName, final String email, final String phoneNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.OPERATOR);

        GeneralDTO returnValue = null;
        try {
            autoTx.beginTransaction();
            RegisterUserService registerUserService = new RegisterUserService(autoTx);
            registerUserService.registerUser(email, firstName, lastName, email, Set.of(BaseRoles.CANDIDATE_USER));
            candidateRepository.save(new Candidate(firstName, lastName, email, phoneNumber, registerUserService.getRegisteredSystemUser()));
            autoTx.commit();
            returnValue = registerUserService.getRegisteredSystemUserDTO();
        } catch (Exception e) {
            autoTx.rollback();
            throw e;
        }
        return returnValue;
    }
}
