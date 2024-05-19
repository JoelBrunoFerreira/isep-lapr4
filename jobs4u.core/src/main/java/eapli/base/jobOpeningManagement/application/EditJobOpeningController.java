package eapli.base.jobOpeningManagement.application;

import eapli.base.customer.application.CustomerService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobOpeningManagement.domain.*;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.jobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.jobRequirementsManagement.dto.JobRequirementDTO;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.hibernate.jdbc.Work;

import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class EditJobOpeningController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final SystemUser user;

    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final JobOpeningRepository repository = PersistenceContext.repositories().jobOpenings();

    public EditJobOpeningController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        user = authz.session().get().authenticatedUser();
    }

    public Iterable<JobOpeningDTO> listJobOpeningsByUSer() {
        return jobOpeningSvc.listJobOpeningsByUser(user);
    }
    public JobOpeningDTO getJobOpeningByReference(String jobReference){
        return jobOpeningSvc.getJobOpeningDTOByReference(jobReference);
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
    public JobOpeningDTO updateJobOpening(JobOpeningDTO dto) {
        return repository.updateJobOpening(dto);
    }
}
