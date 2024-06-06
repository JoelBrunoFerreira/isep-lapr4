package backoffice.presentation.CustomerManager.JobApplicationsManagement;

import eapli.base.jobApplication.application.GenerateInterviewModelController;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class GenerateInterviewModelUI extends AbstractUI {
    private final GenerateInterviewModelController controller = new GenerateInterviewModelController();

    @Override
    protected boolean doShow() {
        Iterable<JobApplicationDTO> jobApplicationDTOS = controller.getJobApplicationDTOs();
        if (jobApplicationDTOS.iterator().hasNext()) {
            SelectWidget<JobApplicationDTO> selectWidget = new SelectWidget<>("Job Application: ", jobApplicationDTOS, System.out::print);
            selectWidget.show();
            String jobReference = selectWidget.selectedElement().getJobOpeningReference();
            return controller.generateInterviewTemplate(jobReference);

        } else {
            System.out.println("No job applications available.");
        }
        return false;
    }


    @Override
    public String headline() {
        return "Generate Interview Model";
    }
}
