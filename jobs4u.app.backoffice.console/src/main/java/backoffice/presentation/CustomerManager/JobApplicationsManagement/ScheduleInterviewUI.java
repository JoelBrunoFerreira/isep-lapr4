package backoffice.presentation.CustomerManager.JobApplicationsManagement;

import eapli.base.interviewModelManagement.application.ScheduleInterviewController;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ScheduleInterviewUI extends AbstractUI {

    private final ScheduleInterviewController controller = new ScheduleInterviewController();
    @Override
    protected boolean doShow() {
        String jobReference;
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.getJobOpeningsByUser();
        if (!(jobOpeningDTOS.iterator().hasNext())){
            System.out.println("No job openings qualify for interviews.");
            return false;
        }
        SelectWidget<JobOpeningDTO> jobOpeningDTO = new SelectWidget<>("Job Openings", jobOpeningDTOS, System.out::print);
        jobOpeningDTO.show();
        jobReference = jobOpeningDTO.selectedElement().getJobReference();

        //TODO get application based on jobReference
        Iterable<JobApplicationDTO> jobApplicationDTOS = controller.getJobApplicationsByJobReference(jobReference);
        if (!jobApplicationDTOS.iterator().hasNext()){
            System.out.println("No job applications available.");
            return false;
        }
        SelectWidget<JobApplicationDTO> jobApplicationDTO = new  SelectWidget<>("Job Applications", jobApplicationDTOS, System.out::print);
        jobApplicationDTO.show();
        try{
            Calendar scheduler = Console.readCalendar("Date and time for the interview: (dd-MM-yyyy hh:mm)", "dd-MM-yyyy hh:mm");
            int dayOfWeek = scheduler.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek==Calendar.SATURDAY||dayOfWeek==Calendar.SUNDAY){
                System.out.println("Date not valid, please pick a work day.");
            }
            controller.updateJobApplication(jobApplicationDTO.selectedElement(), scheduler);
        }catch (Exception w){}
        return false;
    }

    @Override
    public String headline() {
        return "Schedule Interview Date and Time";
    }
}
