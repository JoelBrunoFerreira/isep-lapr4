package backoffice.presentation.CustomerManager.candidateManagement;

import eapli.base.candidate.application.DisplayRankedCandidatesController;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        List<Map.Entry<CandidateDTO, Integer>> candidateDTOIntegerMap = controller.candidateDTOS(jobReference);
        if (!candidateDTOIntegerMap.isEmpty()){
            //printCandidateMap(candidateDTOIntegerMap);
            printCandidateMap(candidateDTOIntegerMap);
        }
        return false;
    }
    private void printCandidateMap( List<Map.Entry<CandidateDTO, Integer>>  candidateDTOIntegerMap) {
        candidateDTOIntegerMap.forEach(System.out::println);
        /*for (Map.Entry<CandidateDTO, Integer> entry : candidateDTOIntegerMap) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for (Map.Entry<CandidateDTO, Integer> entry : candidateDTOIntegerMap.entrySet()) {
            CandidateDTO candidate = entry.getKey();
            Integer votes = entry.getValue();
            System.out.println(candidate + "\nInterview Grade: " + votes);
        }*/
    }
    @Override
    public String headline() {
        return "Ranked Candidates";
    }
}
