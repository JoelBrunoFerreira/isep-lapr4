package eapli.base.jobApplication.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SaveJobRequirementAnswersController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobApplicationRepository repository = PersistenceContext.repositories().jobApplications();

    public SaveJobRequirementAnswersController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.OPERATOR);
    }

    public boolean saveJobRequirementAnswersToJobApplication(String candidateEmail, String jobReference, String jobRequirements) {
        JobApplication jobApplication = repository.findApplicationByCandidateEmailAndJobReference(candidateEmail, jobReference).get();
        jobApplication.saveJobRequirementAnswers(jobRequirements);
        return repository.save(jobApplication) != null;
    }
}
