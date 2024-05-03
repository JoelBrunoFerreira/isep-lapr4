package eapli.base.JobOpeningManagement.application;

import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

@ApplicationService
public class JobOpeningSvc {

    private final JobOpeningRepository repository = PersistenceContext.repositories().jobOpenings();

    public Iterable<JobOpeningDTO> listJobOpeningsByStatus(Status status, SystemUser user) {
        return repository.findAllByStatus(status, user);
    }
    public Iterable<JobOpeningDTO> jobOpeningsDTOList(){
        return repository.findAllDTO();
    }
    public Iterable<JobOpeningDTO> listJobOpeningsByCustomers(String email, SystemUser user){
        return repository.findAllByCustomerID(email, user);
    }
    public Iterable<JobOpeningDTO> listJobOpeningsByUser(SystemUser user){
        return repository.findAllByUser(user);
    }
}
