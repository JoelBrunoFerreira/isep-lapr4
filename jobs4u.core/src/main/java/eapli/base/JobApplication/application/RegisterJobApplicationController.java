package eapli.base.JobApplication.application;

import eapli.base.JobApplication.domain.ApplicationFile;
import eapli.base.JobApplication.domain.JobApplication;
import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.base.JobApplication.repository.JobApplicationRepository;
import eapli.base.JobOpeningManagement.application.JobOpeningSvc;
import eapli.base.JobOpeningManagement.domain.JobOpening;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.base.customer.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UseCaseController
public class RegisterJobApplicationController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final JobApplicationRepository applicationRepository = PersistenceContext.repositories().jobApplications();
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();

    public RegisterJobApplicationController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);
    }

    public Iterable<CandidateDTO> getCandidateDTO() {
        return candidateRepository.findAllDTO();
    }

    public JobApplicationDTO registerJobApplication(List<String> fileList, String candidateEmail, String jobReference) {
        //authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);
        List<ApplicationFile> files = getApplicationFiles(fileList);
        Optional<Candidate> candidate = candidateRepository.findByEmail(new Email(candidateEmail));
        Optional<JobOpening> jobOpening = jobOpeningSvc.getJobOpening(jobReference);
        JobApplication jobApplication = new JobApplication(files,candidate.get(),jobOpening.get());
        return applicationRepository.save(jobApplication).toDTO();

    }
    private List<ApplicationFile> getApplicationFiles(List<String> list){
        List<ApplicationFile> result = new ArrayList<>();
        for (String s : list){
            result.add(new ApplicationFile(s));
        }
        return result;
    }
}
