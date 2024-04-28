import eapli.base.JobOpeningManagement.domain.ContractType;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.WorkingMode;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCaseController
public class RegisterJobOpeningController {

    AuthorizationService authz;
    CustomerRepository customerRepo;
    JobOpeningRepository jobOpeningRepo;

    public RegisterJobOpeningController() {
        this.authz = AuthzRegistry.authorizationService();
        this.customerRepo = PersistenceContext.repositories().customers();
        this.jobOpeningRepo = PersistenceContext.repositories().jobOpenings();
    }

    public void registerJobOpening(final String title, final String description, final String company, final String companyAddress,
                                   final int numberVacancies, final String mode, final String contractType, Long customerID) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);

        Optional<Customer> customer = customerRepo.ofIdentity(customerID);
        if (customer.isEmpty()) {
            throw new IllegalArgumentException("Customer ID not found");
        } else {
            JobOpening newJobOpening = new JobOpening(title, description, company, companyAddress,
                    numberVacancies, mode, contractType, customer.get());
            JobOpening savedJobOpening = jobOpeningRepo.save(newJobOpening);
        }
    }

    public Iterable<CustomerDTO> getCustomerList() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);

        Iterable<Customer> customers = customerRepo.findAll();
        List<CustomerDTO> customersDTO = new ArrayList<>();
        for (Customer customer : customers) {
            customersDTO.add(customer.toDTO());
        }
        return customersDTO;
    }

    public List<String> getModeList() {
        List<String> modeList = new ArrayList<>();
        WorkingMode[] modes = WorkingMode.values();
        for (WorkingMode mode : modes) {
            modeList.add(mode.toString());
        }
        return modeList;
    }

    public List<String> getContractTypeList() {
        List<String> contractTypesList = new ArrayList<>();
        ContractType[] contractTypes = ContractType.values();
        for (ContractType contractType : contractTypes) {
            contractTypesList.add(contractType.toString());
        }
        return contractTypesList;
    }
}
