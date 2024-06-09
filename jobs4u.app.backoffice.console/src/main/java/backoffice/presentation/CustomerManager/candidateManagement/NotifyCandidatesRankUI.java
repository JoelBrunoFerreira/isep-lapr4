package backoffice.presentation.CustomerManager.candidateManagement;

import eapli.base.jobApplication.application.NotifyCandidatesController;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class NotifyCandidatesRankUI extends AbstractUI {
    NotifyCandidatesController controller = new NotifyCandidatesController();

    @Override
    protected boolean doShow() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.getJobAppplicationRanks();
        if (!jobOpeningDTOS.iterator().hasNext()) {
            System.out.println("No Job Openings in result phase");
            return false;
        } else {
            SelectWidget<JobOpeningDTO> jobOpeningDTOSelectWidget = new SelectWidget<>("Job Openings ", jobOpeningDTOS);
            jobOpeningDTOSelectWidget.show();
            String jobReference = jobOpeningDTOSelectWidget.selectedElement().getJobReference();
            int vacancies = Integer.parseInt(jobOpeningDTOSelectWidget.selectedElement().getNumberVacancies());
            controller.notifyCandidates(jobReference, vacancies);
            return true;
        }
    }

    @Override
    public String headline() {
        return "Notify Candidates for a Job Opening";
    }

}
