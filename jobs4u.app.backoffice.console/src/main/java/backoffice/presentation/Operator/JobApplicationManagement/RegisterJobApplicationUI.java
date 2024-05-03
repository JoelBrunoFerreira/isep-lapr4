package backoffice.presentation.Operator.JobApplicationManagement;

import backoffice.presentation.backofficeUser.AddCandidateUI;
import backoffice.presentation.backofficeUser.CandidatePrinter;
import eapli.base.JobApplication.application.RegisterJobApplicationController;
import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import backoffice.presentation.CustomerManager.JobOpeningManagement.JobOpeningPrinter;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.List;

public class RegisterJobApplicationUI extends AbstractUI {

    private final RegisterJobApplicationController controller = new RegisterJobApplicationController();

    @Override
    public boolean doShow() {
        String candidateEmail = getCandidateEmail();
        if (candidateEmail==null) {
            new AddCandidateUI().doShow();
            candidateEmail = getCandidateEmail();
        }
        String jobReference = Console.readLine("Job Reference: ");
        List<String> files = generateFiles();
        controller.registerJobApplication(files, candidateEmail, jobReference);

        return false;
    }

    private List<String> generateFiles() {
        List<String> files = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            files.add(String.format("File %d",i));
        }
        return files;
    }

    @Override
    public String headline() {
        return "Register Job Application";
    }


    private String getCandidateEmail() {
        Iterable<CandidateDTO> candidateDTO = controller.getCandidateDTO();
        if (candidateDTO.iterator().hasNext()) {
            SelectWidget<CandidateDTO> selectWidget = new SelectWidget<>("Select Candidate: ", candidateDTO, new CandidatePrinter());
            selectWidget.show();
            return selectWidget.selectedElement().getEmail();
        }
        return null;
    }
}
