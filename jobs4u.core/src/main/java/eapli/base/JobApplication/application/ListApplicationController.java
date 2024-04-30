package eapli.base.JobApplication.application;

import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.base.JobApplication.repository.JobApplicationRepository;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


@UseCaseController
public class ListApplicationController {

    private final AuthorizationService authz;
    private final JobOpeningRepository jobOpeningRepository;

    private final JobApplicationRepository applicationRepository;
    public ListApplicationController() {
        authz = AuthzRegistry.authorizationService();
        jobOpeningRepository= PersistenceContext.repositories().jobOpenings();
        applicationRepository= PersistenceContext.repositories().jobApplications();
    }

    public Iterable<JobOpeningDTO> listAllJobOpening() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        return jobOpeningRepository.findAllDTO();
    }
    public Iterable<JobApplicationDTO> listApplicationsByJobOpeningId(String jobOpeningId) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        return applicationRepository.findApplicationsByJobOpeningId(jobOpeningId);
    }

}
