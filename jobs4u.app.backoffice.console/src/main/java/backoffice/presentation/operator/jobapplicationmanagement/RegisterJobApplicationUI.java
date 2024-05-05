package backoffice.presentation.operator.jobapplicationmanagement;

import backoffice.presentation.candidates.CandidatePrinter;
import backoffice.presentation.operator.AddCandidateUI;
import eapli.base.JobApplication.application.RegisterJobApplicationController;
import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RegisterJobApplicationUI extends AbstractUI {

    private final RegisterJobApplicationController controller = new RegisterJobApplicationController();

    @Override
    public boolean doShow() {
        String directoryPath = Console.readLine("Path: ");
        String jobReference = controller.getFolderName(directoryPath);
        directoryPath = directoryPath.concat("\\").concat(jobReference);
        String candidateEmail = controller.getFolderName(directoryPath);
        if (controller.checkIfApplicationExists(candidateEmail, jobReference)){
            System.out.println("Application already registered!");
            return true;
        }
        if (!controller.candidateExists(candidateEmail)) {
            new AddCandidateUI().doShow();
        }
        directoryPath = directoryPath.concat("\\").concat(candidateEmail);
        JobApplicationDTO result = controller.registerJobApplication(directoryPath,candidateEmail,jobReference);
        System.out.println("Job application for " + result.getJobOpeningReference() +" and candidate "+ result.getCandidateEmail()+ " registered successfully!");
        return false;
    }


    @Override
    public String headline() {
        return "Register Job Application";
    }
}
