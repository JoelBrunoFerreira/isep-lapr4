package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.JobReference;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.domain.Acronym;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.time.LocalDate;
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

    public JpaJobOpeningRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public Iterable<JobOpeningDTO> findAllDTO() {
        Iterable<JobOpening> jobOpenings = findAll();
        List<JobOpeningDTO> jobOpeningsDTO = new ArrayList<>();
        for (JobOpening jobOpening : jobOpenings) {
            jobOpeningsDTO.add(jobOpening.toDTO());
        }
        return jobOpeningsDTO;
    }

    @Override
    public Iterable<JobOpeningDTO> findAllActive(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public Iterable<JobOpeningDTO> findAllByCustomerIDAndDate(long customerID, LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public Iterable<JobOpeningDTO> findAllByCustomerID(String acronym) {
        Iterable<JobOpening> jobOpenings = findAll();
        List<JobOpeningDTO> result = new ArrayList<>();

        for (JobOpening jo : jobOpenings) {
            if (jo.getCustomer().getAcronym().equals(acronym)) {
                result.add(jo.toDTO());
            }
        }
        return result;
    }
}
