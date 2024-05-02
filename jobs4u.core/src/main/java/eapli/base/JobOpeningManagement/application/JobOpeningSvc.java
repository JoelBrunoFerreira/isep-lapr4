package eapli.base.JobOpeningManagement.application;

import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class JobOpeningSvc {

    private final JobOpeningRepository repository = PersistenceContext.repositories().jobOpenings();

    public Iterable<JobOpeningDTO> listJobOpeningsByStatus(Status status) {
        return repository.findAllByStatus(status);
    }
    public Iterable<JobOpeningDTO> listJobOpeningsByCustomers(String email){
        return repository.findAllByCustomerID(email);
    }
    public Iterable<JobOpeningDTO> listJobOpenings(){
        return repository.findAllDTO();
    }
}
