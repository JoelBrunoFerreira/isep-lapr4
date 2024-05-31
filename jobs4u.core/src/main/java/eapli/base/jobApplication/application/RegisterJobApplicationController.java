package eapli.base.jobApplication.application;

import eapli.base.jobApplication.domain.ApplicationFile;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@UseCaseController
public class RegisterJobApplicationController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final JobApplicationRepository applicationRepository = PersistenceContext.repositories().jobApplications();
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();
    private final ImportCandidatesFilePathsSvc importCandidatesFilePathsSvc = new ImportCandidatesFilePathsSvc();

    public RegisterJobApplicationController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);
    }

    public boolean candidateExists(String email) {
        return candidateRepository.findByEmail(new Email(email)).isPresent();
    }

    public boolean checkIfApplicationExists(String email, String jobReference) {
        Iterator<JobApplicationDTO> it = applicationRepository.findApplicationsDTOByCandidateEmail(email).iterator();
        if (it.hasNext()){
            String jobRef = it.next().getJobOpeningReference();
            if (jobRef.contains(jobReference)){
                return true;
            }
            System.out.println(jobRef);
        }
        return false;
    }

    public JobApplicationDTO registerJobApplication(String path, String candidateEmail, String jobReference) {
        //authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER, BaseRoles.OPERATOR);
        List<ApplicationFile> files = getApplicationFiles(path);
        Optional<Candidate> candidate = candidateRepository.findByEmail(new Email(candidateEmail));
        Optional<JobOpening> jobOpening = jobOpeningSvc.getJobOpeningByReference(jobReference);
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

    public String getFolderName(String directoryPath) {
        return importCandidatesFilePathsSvc.getFolderName(directoryPath);
    }
}
