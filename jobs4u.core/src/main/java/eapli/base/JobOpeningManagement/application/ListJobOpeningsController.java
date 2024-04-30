package eapli.base.JobOpeningManagement.application;

import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.application.CustomerService;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;

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

    public Iterable<JobOpeningDTO> listJobOpeningsByStatus(Status status) {
        return repository.findAllByStatus(status);
    }
}
