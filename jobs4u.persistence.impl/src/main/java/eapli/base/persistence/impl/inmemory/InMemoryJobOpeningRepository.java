package eapli.base.persistence.impl.inmemory;

import eapli.base.JobOpeningManagement.domain.Status;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.JobReference;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InMemoryJobOpeningRepository extends InMemoryDomainRepository<JobOpening, JobReference> implements JobOpeningRepository {
static {
    InMemoryInitializer.init();
}
    @Override
    public Iterable<JobOpeningDTO> findAllDTO() {
        return null;
    }

    @Override
    public Iterable<JobOpeningDTO> findAllByCustomerID(String email) {
        Iterable<JobOpening> jobOpenings = findAll();
        List<JobOpeningDTO> result = new ArrayList<>();

        for (JobOpening jo : jobOpenings) {
            if (jo.getCustomer().getSystemUser().email().toString().equals(email)) {
                result.add(jo.toDTO());
            }
        }
        return result;
    }

    @Override
    public Iterable<JobOpeningDTO> findAllByStatus(Status status) {
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
}
