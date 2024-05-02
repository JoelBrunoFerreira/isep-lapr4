package eapli.base.infrastructure.bootstrapers;

import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.JobTitle;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.RegisterUserService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Calendar;
import java.util.Set;

public class JobsDataBootstrapService {

    private final AuthorizationService authz;
    private final CustomerRepository customerRepository;

    private final JobOpeningRepository jobOpeningRepository;
    private final TransactionalContext autoTx;

    public JobsDataBootstrapService() {
        authz = AuthzRegistry.authorizationService();
        autoTx = PersistenceContext.repositories().newTransactionalContext();
        customerRepository = PersistenceContext.repositories().customers(autoTx);
        jobOpeningRepository = PersistenceContext.repositories().jobOpenings(autoTx);
    }

    public Customer addCustomer(final String name, final String email, final String address) {

        Customer returnValue = null;
        try {
            autoTx.beginTransaction();
            RegisterUserService registerUserService = new RegisterUserService(autoTx);
            registerUserService.registerUser(email, name, name, email, Set.of(BaseRoles.CUSTOMER_USER));
            SystemUser user = registerUserService.getRegisteredSystemUser();
            customerRepository.save(new Customer(user, address));
            autoTx.commit();
        } catch (Exception e) {
            autoTx.rollback();
            throw e;
        }
        return returnValue;
    }

    public JobOpening addJobOpening(String description, int numberOfVacancies, String address, String mode, String contractType,
                                    String jobTitle, Customer customer, SystemUser customerManager){
        JobOpening returnValue = null;
        try {
            autoTx.beginTransaction();
            returnValue = jobOpeningRepository.save(new JobOpening(description, numberOfVacancies, address, mode, contractType,
                    jobTitle, customer, customerManager));
            autoTx.commit();
        } catch (Exception e) {
            autoTx.rollback();
            throw e;
        }
        return returnValue;
    }

}
