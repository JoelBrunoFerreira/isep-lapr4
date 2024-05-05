package eapli.base.InterviewModelManagement.application;

import eapli.base.InterviewModelManagement.domain.InterviewModel;
import eapli.base.InterviewModelManagement.domain.InterviewModelClass;
import eapli.base.InterviewModelManagement.domain.InterviewModelTitle;
import eapli.base.InterviewModelManagement.repository.InterviewModelRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.interviewModelManagement.domain.InterviewModel;
import eapli.base.interviewModelManagement.domain.InterviewModelClass;
import eapli.base.interviewModelManagement.domain.InterviewModelTitle;
import eapli.base.interviewModelManagement.repository.InterviewModelRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AddInterviewModelController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final InterviewModelRepository interviewModelRepository = PersistenceContext.repositories().interviewModelRepository();




    public Optional<InterviewModel> addInterviewModel(final String name, final String className) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.LANGUAGE_ENGINEER);

        InterviewModel interviewModel = new InterviewModel(new InterviewModelTitle(name), new InterviewModelClass(className));

        return Optional.of(interviewModelRepository.save(interviewModel));
    }


}
