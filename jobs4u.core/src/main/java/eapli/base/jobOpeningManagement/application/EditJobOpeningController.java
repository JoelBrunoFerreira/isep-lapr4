package eapli.base.jobOpeningManagement.application;

import eapli.base.customer.application.CustomerService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.jobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

@UseCaseController
public class EditJobOpeningController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final SystemUser user;

    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    public EditJobOpeningController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        user = authz.session().get().authenticatedUser();
    }

    public Iterable<JobOpeningDTO> listJobOpeningsByUSer() {
        return jobOpeningSvc.listJobOpeningsByUser(user);
    }
    public JobOpeningDTO getJobOpeningByReference(String jobReference){
        return jobOpeningSvc.getJobOpeningDTOByReference(jobReference);
    }
}
