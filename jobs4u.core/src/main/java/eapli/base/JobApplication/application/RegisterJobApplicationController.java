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
import eapli.framework.presentation.console.SelectWidget;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@UseCaseController
public class RegisterJobApplicationController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final JobApplicationRepository applicationRepository = PersistenceContext.repositories().jobApplications();
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();

    public RegisterJobApplicationController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);
    }

    public boolean candidateExists(String email){
        return candidateRepository.findByEmail(new Email(email)).isPresent();
    }
    public boolean checkIfApplicationExists(String email){
        return applicationRepository.findApplicationsByJCandidateEmail(email).iterator().hasNext();
    }
    public JobApplicationDTO registerJobApplication(String path, String candidateEmail, String jobReference) {
        //authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);
        List<ApplicationFile> files = getApplicationFiles(path);
        Optional<Candidate> candidate = candidateRepository.findByEmail(new Email(candidateEmail));
        Optional<JobOpening> jobOpening = jobOpeningSvc.getJobOpening(jobReference);
        JobApplication jobApplication = new JobApplication(files, candidate.get(), jobOpening.get());
        return applicationRepository.save(jobApplication).toDTO();

    }


    private List<ApplicationFile> getApplicationFiles(String directoryPath) {
        List<ApplicationFile> applicationFiles = new ArrayList<>();
        File directory = new File(directoryPath);

        // Check if the provided path is a directory
        if (!directory.isDirectory()) {
            System.out.println("Error: Provided path is not a directory.");
            return applicationFiles;
        }

        // Get list of files in the directory
        File[] files = directory.listFiles();

        applicationFiles = Arrays.stream(files)
                .map(file -> new ApplicationFile(file.getPath()))
                .collect(Collectors.toList());

        return applicationFiles;
    }

}
