package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.interviewModelManagement.dto.InterviewModelDTO;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.jobRequirementsManagement.application.SelectJobRequirementController;
import eapli.base.jobRequirementsManagement.domain.JobRequirement;
import eapli.base.jobRequirementsManagement.dto.JobRequirementDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class SelectJobRequirementsUI extends AbstractUI {

    private final SelectJobRequirementController controller = new SelectJobRequirementController();
    @Override
    protected boolean doShow() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.getJobOpeningPendingJobRequirements();
        Iterable<JobRequirementDTO> jobReqDTOS = controller.getAllJobRequirementDTOs();
        if (jobOpeningDTOS.iterator().hasNext() && jobReqDTOS.iterator().hasNext()){
            SelectWidget<JobOpeningDTO> joSelectWidget = new SelectWidget<>("Job Openings pending an Interview Model: ", jobOpeningDTOS, new JobOpeningPrinter());
            joSelectWidget.show();
            String jobReference = joSelectWidget.selectedElement().getJobReference();
            SelectWidget<JobRequirementDTO> imSelectWidget = new SelectWidget<>("Job Requirements: ", jobReqDTOS, System.out::print);
            imSelectWidget.show();
            JobOpeningDTO result = controller.updateJobOpeningJobRequirement(jobReference, imSelectWidget.selectedElement());
            System.out.println(result);
        }else{
            System.out.println("No job openings are pending an Interview Model.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Select Job Requirement Specification: ";
    }
}
