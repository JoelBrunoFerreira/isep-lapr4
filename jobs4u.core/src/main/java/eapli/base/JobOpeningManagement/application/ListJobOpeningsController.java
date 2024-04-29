package eapli.base.JobOpeningManagement.application;

import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.time.LocalDate;

@UseCaseController
public class ListJobOpeningsController {
    final JobOpeningRepository repository = PersistenceContext.repositories().jobOpenings();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Iterable<JobOpeningDTO> listJobOpeningWithFilters(boolean allJobOpening, long customerID, LocalDate startDate, LocalDate endDate){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN,BaseRoles.CUSTOMER_MANAGER);
        try {
            if(allJobOpening){
                return repository.findAllActive(startDate,endDate);
            }else {

                return repository.findAllByCustomerIDAndDate(customerID, startDate,endDate);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    public Iterable<JobOpeningDTO> listJobOpeningsByCustomers(String acronym){
        return repository.findAllByCustomerID(acronym);
    }
    public Iterable<JobOpeningDTO> listJobOpenings(){
        return repository.findAllDTO();
    }

}
