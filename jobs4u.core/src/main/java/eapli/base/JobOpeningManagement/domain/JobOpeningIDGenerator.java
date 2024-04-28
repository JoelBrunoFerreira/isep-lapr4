package eapli.base.JobOpeningManagement.domain;

import eapli.base.Application;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.Generator;
import org.hibernate.id.IdentifierGenerator;

import java.util.List;

public class JobOpeningIDGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        JobReference resultJobReference = null;
        if (o instanceof JobOpening) {
            JobOpening newJobOpening = (JobOpening) o;
            String customerAcronym = newJobOpening.getCustomerAcronym();
            try {
                EntityManager em = getEntityManager();
                int leftSize = customerAcronym.length() + 1;
                String query = "select max(JO.jobReference.id) maximus from JobOpening JO " +
                        " where left(JO.jobReference.id," + leftSize + ")='" + customerAcronym + "-'";
                Query result = em.createQuery(query);
                if (result != null) {
                    List results = result.getResultList();
                    if (!results.isEmpty() && results.get(0) != null) {
                        String stringID = (String) results.get(0);
                        stringID = stringID.substring(leftSize);
                        int newID = Integer.parseInt(stringID);
                        newID++;
                        resultJobReference = new JobReference(customerAcronym + "-" + newID);
                    } else {
                        resultJobReference = new JobReference(customerAcronym + "-1");
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
        return resultJobReference;
    }

    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory(Application.settings().persistenceUnitName()).createEntityManager();
    }
}
