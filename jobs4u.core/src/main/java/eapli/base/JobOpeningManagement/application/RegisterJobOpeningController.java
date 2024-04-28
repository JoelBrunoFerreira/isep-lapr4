import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

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
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.ADMIN, Jobs4uRoles.CUSTOMER_MANAGER);

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
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.ADMIN, Jobs4uRoles.CUSTOMER_MANAGER);

        Iterable<Customer> customers = customerRepo.findAll();
        List<CustomerDTO> customersDTO = new ArrayList<>();
        for (Customer customer : customers) {
            customersDTO.add(customer.toDTO());
        }
        return customersDTO;
    }

    public List<String> getModeList() {
        List<String> modeList = new ArrayList<>();
        Mode[] modes = Mode.values();
        for (Mode mode : modes) {
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
