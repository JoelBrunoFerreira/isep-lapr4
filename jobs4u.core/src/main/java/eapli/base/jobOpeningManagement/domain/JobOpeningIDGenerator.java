package eapli.base.jobOpeningManagement.domain;

import eapli.base.Application;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.List;

public class JobOpeningIDGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        JobReference resultJobReference = null;
        if (o instanceof JobOpening) {
            JobOpening newJobOpening = (JobOpening) o;
            String customerAcronym = newJobOpening.getCustomer().getAcronym().toString();
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
                        String paddedID = String.format("%06d", newID); // Pad the ID with zeros
                        resultJobReference = new JobReference(customerAcronym + "-" + paddedID);
                    } else {
                        resultJobReference = new JobReference(customerAcronym + "-000001"); // Initial job reference
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
