package eapli.base.jobApplication.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.interviewModelManagement.domain.InterviewModel;
import eapli.base.interviewModelManagement.integration.InterviewModelPlugin;
import eapli.base.interviewModelManagement.integration.InterviewModelResult;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.domain.JobApplicationState;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobRequirementsManagement.domain.JobRequirement;
import eapli.base.jobRequirementsManagement.integration.JobRequirementPlugin;
import eapli.base.jobRequirementsManagement.integration.JobRequirementResult;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class EvaluateJobRequirementController {

    private final GetApplicationService jobApplicationSvc;
    private final AuthorizationService authz;
    private final JobOpeningSvc jobOpeningSvc;
    private final JobApplicationRepository repo;

    public EvaluateJobRequirementController() {
        authz = AuthzRegistry.authorizationService();
        jobApplicationSvc = new GetApplicationService();
        jobOpeningSvc = new JobOpeningSvc();
        repo = PersistenceContext.repositories().jobApplications();
    }

    public Iterable<JobApplicationDTO> getJobApplicationDTOs() {
        List<JobApplicationDTO> dtos = new ArrayList<>();
        for (JobApplication jA : jobApplicationSvc.getAllJobApplications()) {
            if (jA.jobApplicationState().equals(JobApplicationState.SCREENING)
            || jA.jobApplicationState().equals(JobApplicationState.ANALYSIS)) {//||jA.jobApplicationState().equals(Status.ACTIVE_INTERVIEW)){
                dtos.add(jA.toDTO());
            }
        }
        return dtos;
    }

    public double evaluateJobRequirement(String jobReference, String candidate) throws IOException {
        JobOpening jobOpening = jobOpeningSvc.getJobOpeningByReference(jobReference).get();
        JobApplication jobApplication = jobApplicationSvc.getJobApplicationByCandidateEmailAndJobReference(candidate, jobReference).get();

        JobRequirement jobRequirement = jobOpening.getJobRequirement();
        JobRequirementPlugin plugin = jobRequirement.buildThePlugin();
        JobRequirementResult result = plugin.validateRequirements(jobApplication.getRequirementAnswers().toString());
        if (result.isValid()){
            jobApplication.approveJobRequirements(result);
            repo.save(jobApplication);
            System.out.println("Candidate passed Job Requirements.");
        }else{
            jobApplication.approveJobRequirements(result);
            repo.save(jobApplication);
            System.out.println("Job Requirement file is not valid.");
            System.out.println(result.getErrorMessage());
        }
        return result.getGrade();
    }
}
