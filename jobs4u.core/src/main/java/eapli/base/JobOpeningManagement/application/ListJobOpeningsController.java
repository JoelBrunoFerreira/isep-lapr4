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
    private final CustomerService customerService = new CustomerService();

    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();


    public Iterable<CustomerDTO> getCustomersDTO(){
        return customerService.findAllDTO();
    }

    public Iterable<JobOpeningDTO> listJobOpenings() {
        return jobOpeningSvc.listJobOpenings();
    }

    public Iterable<JobOpeningDTO> listJobOpeningsByCustomers(String email) {
        return jobOpeningSvc.listJobOpeningsByCustomers(email);
    }

    public Iterable<JobOpeningDTO> listJobOpeningsByStatus(Status status) {
        return jobOpeningSvc.listJobOpeningsByStatus(status);
    }
}
