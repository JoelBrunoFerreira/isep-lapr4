package backoffice.presentation.CustomerManager.JobApplicationsManagement;

import eapli.base.jobApplication.application.EvaluateInterviewAnswersController;
import eapli.base.jobApplication.application.EvaluateJobRequirementController;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.IOException;

public class EvaluateJobRequirementUI extends AbstractUI {

    private final EvaluateJobRequirementController controller = new EvaluateJobRequirementController();

    @Override
    protected boolean doShow() {
        Iterable<JobApplicationDTO> jobApplicationDTOS = controller.getJobApplicationDTOs();
        if (jobApplicationDTOS.iterator().hasNext()) {
            SelectWidget<JobApplicationDTO> selectWidget = new SelectWidget<>("Job Application: ", jobApplicationDTOS, System.out::print);
            selectWidget.show();
            String jobReference = selectWidget.selectedElement().getJobOpeningReference();
            String candidate = selectWidget.selectedElement().getCandidateEmail();
            try {
                double result = controller.evaluateJobRequirement(jobReference, candidate);
                if(result == 1){
                    System.out.println("Result: Approved");
                }else{
                    System.out.println("Result: Not approved");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

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
