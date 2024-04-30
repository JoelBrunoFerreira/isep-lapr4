package eapli.base.JobOpeningManagement.application;

import eapli.base.JobOpeningManagement.domain.ContractType;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.WorkingMode;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.application.CustomerService;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCaseController
public class RegisterJobOpeningController {

    AuthorizationService authz;
    JobOpeningRepository jobOpeningRepository;

    CustomerService customerService;

    public RegisterJobOpeningController() {
        this.authz = AuthzRegistry.authorizationService();
        customerService = new CustomerService();
        this.jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    }

    public JobOpeningDTO registerJobOpening(final String title, final String description, final String address,
                                            final int numberVacancies, final String mode, final String contractType, final String customerEmail) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        Optional<Customer> customer = customerService.findCustomerByUsername(customerEmail);
        JobOpening newJobOpening = new JobOpening(description, numberVacancies, address, mode, contractType, title, customer.get(), authz.session().get().authenticatedUser());
        return jobOpeningRepository.save(newJobOpening).toDTO();

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


    public Iterable<CustomerDTO> getCustomersDTO(){
        return customerService.findAllDTO();
    }
}
