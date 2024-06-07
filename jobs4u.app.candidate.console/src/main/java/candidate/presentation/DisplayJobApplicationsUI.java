package candidate.presentation;

import candidate.application.DisplayJobApplicationsController;
import candidate.dto.JobApplicationDto;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;

import java.io.IOException;

public class DisplayJobApplicationsUI extends AbstractUI {
    private final DisplayJobApplicationsController controller = new DisplayJobApplicationsController();
    @Override
    protected boolean doShow() {
        try {
            Iterable<JobApplicationDto> jobApplicationDtos = controller.jobApplicationDtos();
            if (jobApplicationDtos!=null){
                ListWidget<JobApplicationDto> listWidget = new ListWidget<>("Job Applications: ", jobApplicationDtos, System.out::print);
                listWidget.show();
            }else {
                System.out.println("There are no job openings active at the moment.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    @Override
    public String headline() {
        return "Job Openings";
    }
}
