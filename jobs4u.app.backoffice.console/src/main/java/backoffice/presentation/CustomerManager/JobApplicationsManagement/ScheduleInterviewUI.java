package backoffice.presentation.CustomerManager.JobApplicationsManagement;

import eapli.base.interviewModelManagement.application.ScheduleInterviewController;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class ScheduleInterviewUI extends AbstractUI {

    private final ScheduleInterviewController controller = new ScheduleInterviewController();

    @Override
    protected boolean doShow() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.getJobOpeningsByUser();
        if (!jobOpeningDTOS.iterator().hasNext()) {
            System.out.println("No job openings qualify for interviews.");
            return false;
        }

        SelectWidget<JobOpeningDTO> jobOpeningWidget = new SelectWidget<>("Job Openings", jobOpeningDTOS, System.out::print);
        jobOpeningWidget.show();
        JobOpeningDTO selectedJobOpening = jobOpeningWidget.selectedElement();
        String jobReference = selectedJobOpening.getJobReference();
        LocalDate startDate = selectedJobOpening.getRecruitmentProcessPhaseDTOList().get(2).getStartDate();
        LocalDate endDate = selectedJobOpening.getRecruitmentProcessPhaseDTOList().get(2).getEndDate();

        Iterable<JobApplicationDTO> jobApplicationDTOS = controller.getJobApplicationsByJobReference(jobReference);
        if (!jobApplicationDTOS.iterator().hasNext()) {
            System.out.println("No job applications available.");
            return false;
        }

        SelectWidget<JobApplicationDTO> jobApplicationWidget = new SelectWidget<>("Job Applications", jobApplicationDTOS, System.out::print);
        jobApplicationWidget.show();
        JobApplicationDTO selectedJobApplication = jobApplicationWidget.selectedElement();
        if (selectedJobApplication!=null){
            System.out.println("Interview phase between " + startDate + " and " + endDate + ".");
            try {
                Calendar scheduler = Console.readCalendar("Date and time for the interview: (dd-MM-yyyy hh:mm)", "dd-MM-yyyy hh:mm");
                int dayOfWeek = scheduler.get(Calendar.DAY_OF_WEEK);
                String dayOfWeekString = new DateFormatSymbols().getWeekdays()[dayOfWeek];

                if (isInvalidInterviewDate(scheduler, startDate, endDate, dayOfWeek)) {
                    System.out.println("Date not valid (" + dayOfWeekString + "), please pick a work day between the interview phase period.");
                } else {
                    controller.updateJobApplication(selectedJobApplication, scheduler);
                }
            } catch (Exception e) {
                System.out.println("An error occurred while scheduling the interview.");
            }

        }
        return false;
    }

    private boolean isInvalidInterviewDate(Calendar scheduler, LocalDate startDate, LocalDate endDate, int dayOfWeek) {
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY ||
                scheduler.before(toCalendar(startDate)) || scheduler.after(toCalendar(endDate));
    }

    private Calendar toCalendar(LocalDate date) {
        Calendar cal = Calendar.getInstance();
        cal.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth());
        return cal;
    }

    @Override
    public String headline() {
        return "Schedule Interview Date and Time";
    }
}