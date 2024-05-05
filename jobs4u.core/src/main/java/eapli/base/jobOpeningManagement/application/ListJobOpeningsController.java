package eapli.base.jobOpeningManagement.application;

import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.customer.application.CustomerService;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

@UseCaseController
public class ListJobOpeningsController {
    private final CustomerService customerService = new CustomerService();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final SystemUser user;
    public ListJobOpeningsController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN,BaseRoles.CUSTOMER_MANAGER);
        user = authz.session().get().authenticatedUser();
    }

    public Iterable<CustomerDTO> getCustomersDTO(){
        return customerService.findAllDTO();
    }

    public Iterable<JobOpeningDTO> listJobOpeningsByUSer() {
        return jobOpeningSvc.listJobOpeningsByUser(user);
    }

    public Iterable<JobOpeningDTO> listJobOpeningsByCustomers(String email) {
        return jobOpeningSvc.listJobOpeningsByCustomers(email, user);
    }

    public Iterable<JobOpeningDTO> listJobOpeningsByStatus(Status status) {
        return jobOpeningSvc.listJobOpeningsByStatus(status, user );
    }
}
