package eapli.base.jobApplication.application;

import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Map;
import java.util.TreeMap;

public class NotifyCandidatesController {
    private final AuthorizationService authz;
    private final JobOpeningSvc jobOpeningSvc;
    private final GetApplicationService getApplicationService;
    private final NotifyCandidatesService notifyCandidatesService;
    public NotifyCandidatesController() {
        authz = AuthzRegistry.authorizationService();
        jobOpeningSvc = new JobOpeningSvc();
        getApplicationService = new GetApplicationService();
        notifyCandidatesService = new NotifyCandidatesService();
    }

    public Iterable<JobOpeningDTO> getJobAppplicationRanks() {
        return jobOpeningSvc.listJobOpeningsByStatus(Status.ACTIVE_RESULT, authz.session().get().authenticatedUser());
        // Return List of JobOpenings in phase result
    }

    public void notifyCandidates(String jobReference, int vacancies) {
        int counter = 0;

        Map<Integer, String> results = new TreeMap<>();
        for (JobApplication jobApplication : getApplicationService.getJobApplicationsByJobReference(jobReference)) {
            results.put(jobApplication.getRank().valueOf(), jobApplication.getCandidate().getEmail().toString());
        }

        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            if (counter < vacancies) {
                counter++;
                notifyCandidatesService.buildEmailForSelectedCandidate(entry.getValue(), entry.getKey(), jobReference);
            } else {
                notifyCandidatesService.buildEmailForNonSelectedCandidates(entry.getValue(), entry.getKey(), jobReference);
            }
        }
    }
}
