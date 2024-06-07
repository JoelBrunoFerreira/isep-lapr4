package eapli.base.interviewModelManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@UseCaseController
public class ScheduleInterviewController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobApplicationRepository repository = PersistenceContext.repositories().jobApplications();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();
    private final SystemUser user;

    public ScheduleInterviewController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        user = authz.session().get().authenticatedUser();
    }

    public Iterable<JobOpeningDTO> getJobOpeningsByUser(){
        List<JobOpeningDTO> result = new ArrayList<>();
        for (JobOpeningDTO dto : jobOpeningSvc.listJobOpeningsByUser(user)){
            if ((dto.getStatus().equalsIgnoreCase(Status.ACTIVE.toString())
                    ||dto.getStatus().equalsIgnoreCase(Status.ACTIVE_APPLICATION.toString())
                    ||dto.getStatus().equalsIgnoreCase(Status.ACTIVE_SCREENING.toString())
                    ||dto.getStatus().equalsIgnoreCase(Status.ACTIVE_INTERVIEWS.toString()))
            &&dto.hasInterviewPhase()){
                result.add(dto);
            }
        }
        return result;
    }

    public Iterable<JobApplicationDTO> getJobApplicationsByJobReference(String jobReference){
        List<JobApplicationDTO> result = new ArrayList<>();
        for (JobApplicationDTO dto : repository.findApplicationsByJobOpeningReference(jobReference))
        {
            if (dto.getInterviewSchedule()==null){
                result.add(dto);
            }
        }
        return result;
    }

    public JobApplicationDTO updateJobApplication(JobApplicationDTO dto, Calendar scheduler){
        JobApplication jobApplication = repository.ofIdentity(dto.getId()).get();
        jobApplication.setInterviewSchedule(scheduler);
        return repository.save(jobApplication).toDTO();
    }
}
