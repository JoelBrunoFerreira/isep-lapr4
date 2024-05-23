package eapli.base.persistence.impl.inmemory;

import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.JobReference;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.jobOpeningManagement.repositories.JobOpeningRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class InMemoryJobOpeningRepository extends InMemoryDomainRepository<JobOpening, JobReference> implements JobOpeningRepository {
    static {
        InMemoryInitializer.init();
    }
    @Override
    public Iterable<JobOpeningDTO> findAllDTO() {
        Iterable<JobOpening> jobOpenings = findAll();
        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        for (JobOpening jobOpening : jobOpenings) {
            jobOpeningsDTO.add(jobOpening.toDTO());
        }
        return jobOpeningsDTO;
    }
    @Override
    public Iterable<JobOpeningDTO> findAllByUser(SystemUser user) {
        Iterable<JobOpening> jobOpenings = findAll();
        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        for (JobOpening jobOpening : jobOpenings) {
            if (jobOpening.isManagedBy(user)) {
                jobOpeningsDTO.add(jobOpening.toDTO());
            }
        }
        return jobOpeningsDTO;
    }

    @Override
    public Iterable<JobOpeningDTO> findAllByCustomerID(String email, SystemUser user) {
        Iterable<JobOpening> jobOpenings = findAll();
        List<JobOpeningDTO> result = new ArrayList<>();

        for (JobOpening jo : jobOpenings) {
            if (jo.getCustomer().getSystemUser().email().toString().equals(email) && jo.isManagedBy(user)) {
                result.add(jo.toDTO());
            }
        }
        return result;
    }

    @Override
    public Iterable<JobOpeningDTO> findAllByStatus(Status status, SystemUser user) {
        Iterable<JobOpening> jobOpenings = findAll();
        List<JobOpeningDTO> result = new ArrayList<>();
        Method method = null;
        try {
            switch (status) {
                case PENDING:
                    method = JobOpening.class.getDeclaredMethod("isPending");
                    break;
                case ACTIVE:
                    method = JobOpening.class.getDeclaredMethod("isActive");
                    break;
                case COMPLETED:
                    method = JobOpening.class.getDeclaredMethod("isCompleted");
                    break;
                default:
                    break;
            }
            for (JobOpening jo : jobOpenings) {
                if ((boolean) method.invoke(jo)) {
                    result.add(jo.toDTO());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public JobOpeningDTO findByJobReference(String jobReference) {
        return null;
    }


    @Override
    public JobOpeningDTO updateJobOpening(JobOpeningDTO dto) {
        return null;
    }
}
