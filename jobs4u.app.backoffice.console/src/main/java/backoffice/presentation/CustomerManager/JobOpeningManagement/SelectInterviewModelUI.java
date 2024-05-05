package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.InterviewModelManagement.application.SelectInterviewModelController;
import eapli.base.InterviewModelManagement.dto.InterviewModelDTO;
import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class SelectInterviewModelUI extends AbstractUI {
    private SelectInterviewModelController controller = new SelectInterviewModelController();
    @Override
    protected boolean doShow() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.getJobOpeningPendingInterviewModel();
        Iterable<InterviewModelDTO> interviewModelDTOS = controller.getAllInterviewModelDTOs();
        if (jobOpeningDTOS.iterator().hasNext() && interviewModelDTOS.iterator().hasNext()){
            SelectWidget<JobOpeningDTO> joSelectWidget = new SelectWidget<>("Job Openings pending an Interview Model: ", jobOpeningDTOS, new JobOpeningPrinter());
            joSelectWidget.show();
            String jobReference = joSelectWidget.selectedElement().getJobReference();
            SelectWidget<InterviewModelDTO> imSelectWidget = new SelectWidget<>("Interview Models: ", interviewModelDTOS, System.out::print);
            imSelectWidget.show();
            JobOpeningDTO result = controller.updateJobOpeningInterviewModel(jobReference, imSelectWidget.selectedElement());
            System.out.println(result);
        }else{
            System.out.println("No job openings are pending an Interview Model.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Select an Interview Model for a Job Opening";
    }
}
