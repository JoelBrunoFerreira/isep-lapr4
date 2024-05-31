package eapli.base.jobApplication.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class SaveInterviewAnswersController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobApplicationRepository repository = PersistenceContext.repositories().jobApplications();

    public SaveInterviewAnswersController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
    }

    public boolean saveInterviewAnswersToJobApplication(String candidateEmail, String jobReference, String interviewAnswers) {
        JobApplication jobApplication = repository.findApplicationByCandidateEmailAndJobReference(candidateEmail, jobReference).get();
        jobApplication.saveInterviewModelAnswers(interviewAnswers);
        return repository.save(jobApplication) != null;
    }
}
