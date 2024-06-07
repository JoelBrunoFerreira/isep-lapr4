package eapli.base.jobApplication.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.interviewModelManagement.domain.InterviewModel;
import eapli.base.interviewModelManagement.integration.InterviewModelPlugin;
import eapli.base.interviewModelManagement.integration.InterviewModelResult;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class EvaluateInterviewAnswersController {

    private final GetApplicationService jobApplicationSvc;
    private final AuthorizationService authz;
    private final JobOpeningSvc jobOpeningSvc;
    private final JobApplicationRepository repo;

    public EvaluateInterviewAnswersController() {
        authz = AuthzRegistry.authorizationService();
        jobApplicationSvc = new GetApplicationService();
        jobOpeningSvc = new JobOpeningSvc();
        repo = PersistenceContext.repositories().jobApplications();
    }

    public Iterable<JobApplicationDTO> getJobApplicationDTOs() {
        List<JobApplicationDTO> dtos = new ArrayList<>();
        for (JobApplication jA : jobApplicationSvc.getJobApplications()) {
            if (jA.jobApplicationState().equals(Status.ACTIVE_ANALYSIS) || jA.jobApplicationState().equals(Status.ACTIVE_INTERVIEWS)) {//||jA.jobApplicationState().equals(Status.ACTIVE_INTERVIEW)){
                dtos.add(jA.toDTO());
            }
        }
        return dtos;
    }

    public float evaluateInterviewAnswers(String jobReference, String candidate) {
        JobOpening jobOpening = jobOpeningSvc.getJobOpeningByReference(jobReference).get();
        JobApplication jobApplication = jobApplicationSvc.getJobApplicationByCandidateEmailAndJobReference(candidate, jobReference).get();

        InterviewModel interviewModel = jobOpening.getInterviewModel();
        InterviewModelPlugin plugin = interviewModel.buildThePlugin();
        InterviewModelResult result = plugin.evaluateInterviewModel(jobApplication.getInterviewAnswers().toString());
        if (result.isValid()){
            jobApplication.setInterviewGrade(result.getGrade());
            repo.save(jobApplication);
        }else{
            System.out.println("Answered interview model is not valid.");
        }
        return jobApplication.getInterviewResult().getGrade();
    }
}
