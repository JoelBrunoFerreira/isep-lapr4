package backoffice.presentation.CustomerManager.candidateManagement;

import eapli.base.candidate.application.DisplayRankedCandidatesController;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

public class DisplayRankedCandidatesUI extends AbstractUI {
    private final DisplayRankedCandidatesController controller = new DisplayRankedCandidatesController();
    @Override
    protected boolean doShow() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.getJobOpeningDTOs();
        if (!jobOpeningDTOS.iterator().hasNext()){
            System.out.println("No job openings with interview phase available.");
            return false;
        }
        SelectWidget<JobOpeningDTO> jobOpeningDTO = new SelectWidget<>("Choose Job Opening", jobOpeningDTOS, System.out::print);
        jobOpeningDTO.show();
        String jobReference = jobOpeningDTO.selectedElement().getJobReference();
        List<CandidateDTO> result = controller.candidateDTOS(jobReference);

        return false;
    }

    @Override
    public String headline() {
        return "Ranked Candidates";
    }
}
