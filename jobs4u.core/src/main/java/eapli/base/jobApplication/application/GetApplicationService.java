package eapli.base.jobApplication.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.jobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;


@UseCaseController
public class GetApplicationService {

    private final AuthorizationService authz;

    private final JobApplicationRepository applicationRepository;
    public GetApplicationService() {
        authz = AuthzRegistry.authorizationService();
        applicationRepository= PersistenceContext.repositories().jobApplications();
    }


    public Optional<JobApplication> getJobApplicationByCandidateEmailAndJobReference(String email, String jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        return applicationRepository.findApplicationByCandidateEmailAndJobReference(email, jobReference);
    }


}
