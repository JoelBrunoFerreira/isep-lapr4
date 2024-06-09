package eapli.base.jobApplication.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;

public class RankJobApplicationController {

    private final AuthorizationService authz;
    private final JobApplicationRepository applicationRepository;
    private final GetApplicationService service = new GetApplicationService();
    public RankJobApplicationController() {
        authz = AuthzRegistry.authorizationService();
        applicationRepository= PersistenceContext.repositories().jobApplications();
    }

    public JobApplication rankCandidatesForJobApplication(String rank, String email, String jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.CUSTOMER_MANAGER);

        Optional<JobApplication> application = service.getJobApplicationByCandidateEmailAndJobReference(email, jobReference);
        if(!application.isPresent()){
            return null;
        }

        application.get().rankApplication(rank);
        return applicationRepository.save(application.get());
    }
}
