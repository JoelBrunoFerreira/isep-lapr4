package backoffice.presentation.CustomerManager.JobApplicationsManagement;

import eapli.base.jobApplication.application.SaveInterviewAnswersController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class SaveInterviewAnswersUI extends AbstractUI {
    private final SaveInterviewAnswersController controller = new SaveInterviewAnswersController();
    @Override
    protected boolean doShow() {
        try {
            String candidateEmail = Console.readLine("Candidate email: ");
            String jobReference = Console.readLine("Job Reference applying to: ");
            String interviewAnswers = getInterviewAnswersFile();
            boolean success = controller.saveInterviewAnswersToJobApplication(candidateEmail, jobReference, interviewAnswers);
            System.out.println(success?"Save successful.":"Save unsuccessful.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    private String getInterviewAnswersFile() throws IOException {
        String filePath = Console.readLine("Interview Answers file path: ");
        return filePath;
        //File file = new File(filePath);
        //return FileUtils.readFileToString(file, "UTF-8");
    }
    @Override
    public String headline() {
        return "Save Interview Answers";
    }
}
