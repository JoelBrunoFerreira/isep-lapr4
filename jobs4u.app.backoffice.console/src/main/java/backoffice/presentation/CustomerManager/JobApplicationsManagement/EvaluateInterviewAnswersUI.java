package backoffice.presentation.CustomerManager.JobApplicationsManagement;

import eapli.base.jobApplication.application.EvaluateInterviewAnswersController;
import eapli.base.jobApplication.application.GenerateInterviewModelController;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class EvaluateInterviewAnswersUI extends AbstractUI {

    private final EvaluateInterviewAnswersController controller = new EvaluateInterviewAnswersController();
    @Override
    protected boolean doShow() {
        Iterable<JobApplicationDTO> jobApplicationDTOS = controller.getJobApplicationDTOs();
        if (jobApplicationDTOS.iterator().hasNext()) {
            SelectWidget<JobApplicationDTO> selectWidget = new SelectWidget<>("Job Application: ", jobApplicationDTOS, System.out::print);
            selectWidget.show();
            String jobReference = selectWidget.selectedElement().getJobOpeningReference();
            String candidate = selectWidget.selectedElement().getCandidateEmail();
            float result = controller.evaluateInterviewAnswers(jobReference, candidate);
            System.out.println("Interview Grade: " + result);

        } else {
            System.out.println("No job applications available.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Evaluate Interview Answers";
    }
}
