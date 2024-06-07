package eapli.base.jobOpeningManagement.application;

import eapli.base.jobApplication.application.GetApplicationService;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.domain.JobApplicationState;
import eapli.base.jobOpeningManagement.domain.Status;

public class StatusChangeSvc {
    private final GetApplicationService applicationService;

    public StatusChangeSvc() {
        this.applicationService = new GetApplicationService();
    }

    public void changeJobApplicationStatus(String jobReference, String status) {
        String jobApplicationState = getJobApplicationState(Status.valueOf(status));
        for (JobApplication jobApplication : applicationService.getJobApplicationsByJobReference(jobReference)) {
            jobApplication.changeApplicationStatus(jobApplicationState);
        }
    }

    private String getJobApplicationState(Status status) {
        return switch (status) {
            case ACTIVE_APPLICATION -> JobApplicationState.ACCEPTED.toString();
            case ACTIVE_SCREENING -> JobApplicationState.SCREENING.toString();
            case ACTIVE_INTERVIEWS -> JobApplicationState.INTERVIEWING.toString();
            case ACTIVE_ANALYSIS -> JobApplicationState.ANALYSIS.toString();
            case ACTIVE_RESULT -> JobApplicationState.RESULT.toString();
            case COMPLETED -> JobApplicationState.FINALIZED.toString();
            default -> JobApplicationState.REJECTED.toString();
        };
    }

}
