package backoffice.presentation.operator.jobapplicationmanagement;

import backoffice.presentation.operator.AddCandidateUI;
import eapli.base.jobApplication.application.RegisterJobApplicationController;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class RegisterJobApplicationUI extends AbstractUI {

    private final RegisterJobApplicationController controller = new RegisterJobApplicationController();

    @Override
    public boolean doShow() {
        try {
            String directoryPath = Console.readLine("Path: ");
            String jobReference = controller.getFolderName(directoryPath);
            directoryPath = directoryPath.concat("//").concat(jobReference);
            String candidateEmail = controller.getFolderName(directoryPath);
            if (controller.checkIfApplicationExists(candidateEmail, jobReference)) {
                System.out.println("Application already registered!");
                return true;
            }
            if (!controller.candidateExists(candidateEmail)) {
                new AddCandidateUI().doShow();
            }
            directoryPath = directoryPath.concat("//").concat(candidateEmail);
            JobApplicationDTO result = controller.registerJobApplication(directoryPath, candidateEmail, jobReference);
            System.out.println("Job application for " + result.getJobOpeningReference() + " and candidate " + result.getCandidateEmail() + " registered successfully!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Register Job Application";
    }
}
