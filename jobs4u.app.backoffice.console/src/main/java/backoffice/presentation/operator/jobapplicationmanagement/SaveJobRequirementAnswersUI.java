package backoffice.presentation.operator.jobapplicationmanagement;

import eapli.base.jobApplication.application.SaveJobRequirementAnswersController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class SaveJobRequirementAnswersUI extends AbstractUI {
    private final SaveJobRequirementAnswersController controller = new SaveJobRequirementAnswersController();
    @Override
    public boolean doShow() {
        try {
            String candidateEmail = Console.readLine("Candidate email: ");
            String jobReference = Console.readLine("Job Reference applying to: ");
            String jobRequirements = Console.readLine("File path: ");
            boolean success = controller.saveJobRequirementAnswersToJobApplication(candidateEmail, jobReference, jobRequirements);
            System.out.println(success?"Save successful.":"Save unsuccessful.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public String headline() {
        return "Save Job Requirement Answers";
    }
}
