package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.jobOpeningManagement.domain.*;
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


    public JobOpeningDTO updateJobOpening(JobOpeningDTO dto){
        JobOpening result = repo.ofIdentity(new JobReference(dto.getJobReference())).get();
        result.updateJobOpening(dto.getDescription(), Integer.parseInt(dto.getNumberVacancies()),dto.getJobOpeningAddress(), dto.getMode(), dto.getContractType(),dto.getJobTitle());
        repo.save(result);
        return result.toDTO();
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

    public Iterable<JobOpening> allCustomerJobOpenings(SystemUser customer) {
        Iterable<JobOpening> jobOpenings = repo.findAll();
        List<JobOpening> result = new ArrayList<>();
        for (JobOpening jo : jobOpenings) {
            if (jo.getCustomer().getSystemUser().equals(customer)) {
                if (jo.allActive())
                {
                    result.add(jo);
                }
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
                    method = JobOpening.class.getDeclaredMethod("allActive");
                    break;
                case ACTIVE_IMPENDING:
                    method = JobOpening.class.getDeclaredMethod("isActive");
                    break;
                case ACTIVE_APPLICATION:
                    method = JobOpening.class.getDeclaredMethod("isActiveApplication");
                    break;
                case ACTIVE_SCREENING:
                    method = JobOpening.class.getDeclaredMethod("isActiveScreening");
                    break;
                case ACTIVE_INTERVIEW:
                    method = JobOpening.class.getDeclaredMethod("isActiveInterview");
                    break;
                case ACTIVE_ANALYSIS:
                    method = JobOpening.class.getDeclaredMethod("isActiveAnalysis");
                    break;
                case ACTIVE_RESULT:
                    method = JobOpening.class.getDeclaredMethod("isActiveResult");
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

}
