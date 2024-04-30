package eapli.base.JobOpeningManagement.application;

import eapli.base.JobOpeningManagement.domain.Active;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.application.CustomerService;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.time.LocalDate;

@UseCaseController
public class ListJobOpeningsController {
    private final JobOpeningRepository repository = PersistenceContext.repositories().jobOpenings();
    private final CustomerService customerService = new CustomerService();



    public Iterable<JobOpeningDTO> listJobOpeningsByCustomers(String email){
        return repository.findAllByCustomerID(email);
    }
    public Iterable<JobOpeningDTO> listJobOpenings(){
        return repository.findAllDTO();
    }
    public Iterable<CustomerDTO> getCustomersDTO(){
        return customerService.findAllDTO();
    }

    public Iterable<JobOpeningDTO> listJobOpeningsByStatus(Active active) {
        return repository.findAllByStatus(active);
    }
}
