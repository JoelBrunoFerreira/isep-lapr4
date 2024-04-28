package eapli.base.JobOpeningManagement.application;

import eapli.base.JobOpeningManagement.domain.ContractType;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.WorkingMode;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.application.GetCustomerListController;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCaseController
public class RegisterJobOpeningController {

    AuthorizationService authz;
    Iterable<CustomerDTO> customers;
    JobOpeningRepository jobOpeningRepo;
    private String manager;

    public RegisterJobOpeningController() {
        this.authz = AuthzRegistry.authorizationService();
        this.manager = authz.session().get().authenticatedUser().toString();
        this.jobOpeningRepo = PersistenceContext.repositories().jobOpenings();
        this.customers = new GetCustomerListController().getCustomerList();
    }

    public JobOpeningDTO registerJobOpening(final String title, final String description, final String address,
                                            final int numberVacancies, final String mode, final String contractType, Long customerID) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);

        Optional<Customer> customer = new GetCustomerListController().getCustomer(customerID);
        if (customer.isEmpty()) {
            throw new IllegalArgumentException("Customer ID not found");
        } else {
            JobOpening newJobOpening = new JobOpening(description,numberVacancies,address,mode,contractType,title,customer.get().getAcronym().toString(),manager);
            return jobOpeningRepo.save(newJobOpening).toDTO();
        }
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
