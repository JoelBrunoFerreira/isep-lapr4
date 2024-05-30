package customer.presentation;

import customer.application.DisplayJobOpeningsController;
import customer.dto.JobOpeningDto;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;

import java.io.IOException;

public class DisplayJobOpeningsUI extends AbstractUI {
    private final DisplayJobOpeningsController controller = new DisplayJobOpeningsController();
    @Override
    protected boolean doShow() {
        try {
            Iterable<JobOpeningDto> jobOpeningDtos = controller.jobOpeningDtos();
            if (jobOpeningDtos!=null){
                ListWidget<JobOpeningDto> listWidget = new ListWidget<>("Job Openings: ", jobOpeningDtos, System.out::print);
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
