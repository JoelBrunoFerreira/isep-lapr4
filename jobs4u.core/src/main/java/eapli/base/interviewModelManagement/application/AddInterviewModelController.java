package eapli.base.interviewModelManagement.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.interviewModelManagement.domain.InterviewModel;
import eapli.base.interviewModelManagement.domain.InterviewModelClass;
import eapli.base.interviewModelManagement.domain.InterviewModelTemplate;
import eapli.base.interviewModelManagement.domain.InterviewModelTitle;
import eapli.base.interviewModelManagement.repository.InterviewModelRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;

public class AddInterviewModelController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final InterviewModelRepository interviewModelRepository = PersistenceContext.repositories().interviewModelRepository();




    public Optional<InterviewModel> addInterviewModel(final String name, final String className, final String model) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.LANGUAGE_ENGINEER);

        InterviewModel interviewModel = new InterviewModel(new InterviewModelClass(className), new InterviewModelTitle(name), new InterviewModelTemplate(model));

        return Optional.of(interviewModelRepository.save(interviewModel));
    }


}
