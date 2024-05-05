package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.JobReference;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.jobOpeningManagement.repositories.JobOpeningRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JpaJobOpeningRepository extends JpaAutoTxRepository<JobOpening, JobReference, JobReference>
        implements JobOpeningRepository {
    public JpaJobOpeningRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaJobOpeningRepository(final String puname) {
        super(puname, Application.settings().extendedPersistenceProperties(), "id");
    }


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
    public Iterable<JobOpeningDTO> findAllDTO() {
        Iterable<JobOpening> jobOpenings = findAll();
        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        for (JobOpening jobOpening : jobOpenings) {
            jobOpeningsDTO.add(jobOpening.toDTO());
        }
        return jobOpeningsDTO;
    }


    @Override
    public Iterable<JobOpeningDTO> findAllByCustomerID(String email, SystemUser user) {
        Iterable<JobOpening> jobOpenings = repo.findAll();
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
                if ((boolean) method.invoke(jo) && jo.isManagedBy(user)) {
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
        JobReference jr = new JobReference(jobReference);
        return ofIdentity(jr).get().toDTO();
    }

    @Override
    public Iterable<JobOpeningDTO> findAllByManager(SystemUser user) {
        List<JobOpeningDTO> result = new ArrayList<>();
        for (JobOpening jo : findAll()){
            if (jo.isManagedBy(user)){
                result.add(jo.toDTO());
            }
        }
        return result;
    }
}
