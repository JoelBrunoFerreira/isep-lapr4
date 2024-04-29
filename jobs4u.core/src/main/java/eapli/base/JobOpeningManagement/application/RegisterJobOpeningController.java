package eapli.base.JobOpeningManagement.application;

import eapli.base.JobOpeningManagement.domain.ContractType;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.domain.WorkingMode;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.JobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.customer.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class RegisterJobOpeningController {

    AuthorizationService authz;
    JobOpeningRepository jobOpeningRepository;
    private SystemUser manager;

    public RegisterJobOpeningController() {
        this.authz = AuthzRegistry.authorizationService();
        this.manager = authz.session().get().authenticatedUser();
        this.jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    }

    public JobOpeningDTO registerJobOpening(final String title, final String description, final String address,
                                            final int numberVacancies, final String mode, final String contractType, Customer customer) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);

        JobOpening newJobOpening = new JobOpening(description, numberVacancies, address, mode, contractType, title, customer, manager);

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
}
