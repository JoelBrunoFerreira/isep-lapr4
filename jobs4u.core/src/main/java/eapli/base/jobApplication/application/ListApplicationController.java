package eapli.base.jobApplication.application;

import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.jobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;


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
        return applicationRepository.findApplicationsByJobOpeningReference(jobOpeningId);
    }

    public Iterable<JobApplicationDTO> listApplicationsByCandidate(String candidateEmail) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        return applicationRepository.findApplicationsDTOByCandidateEmail(candidateEmail);
    }

    public Optional<JobApplicationDTO> getJobApplicationByCandidateEmailAndJobReference(String email, String jobReference) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        return Optional.of(applicationRepository.findApplicationByCandidateEmailAndJobReference(email, jobReference).get().toDTO());
    }


}
