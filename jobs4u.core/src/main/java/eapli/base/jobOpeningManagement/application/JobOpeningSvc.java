package eapli.base.jobOpeningManagement.application;

import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.JobReference;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.jobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.Optional;

@ApplicationService
public class JobOpeningSvc {

    private final JobOpeningRepository repository = PersistenceContext.repositories().jobOpenings();

    public Iterable<JobOpeningDTO> listJobOpeningsByStatus(Status status, SystemUser user) {
        return repository.findAllByStatus(status, user);
    }
    public Iterable<JobOpeningDTO> listJobOpeningsByUser(SystemUser user) {
        return repository.findAllByUser(user);
    }
    public Iterable<JobOpeningDTO> listJobOpeningsByCustomers(String email, SystemUser user){
        return repository.findAllByCustomerID(email, user);
    }

    public JobOpeningDTO getJobOpeningDTOByReference(String jobReference) {
        return repository.findByJobReference(jobReference);
    }

    public Optional<JobOpening> getJobOpeningByReference(String jobReference){
        return repository.ofIdentity(new JobReference(jobReference));
    }

    public JobOpeningDTO saveJobOpening(JobOpening jobOpening) {
       return repository.save(jobOpening).toDTO();
    }
}
