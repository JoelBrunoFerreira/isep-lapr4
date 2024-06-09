package backoffice.presentation.CustomerManager.JobApplicationsManagement;

import eapli.base.jobApplication.application.EvaluateJobRequirementController;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import mailClient.EmailService;

import java.io.IOException;

public class EvaluateJobRequirementUI extends AbstractUI {

    private final EvaluateJobRequirementController controller = new EvaluateJobRequirementController();
    private final EmailService emailService = new EmailService();

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
                    String candidateApproved = buildEmailForApprovedCandidate(candidate, jobReference);
                    emailService.sendEmail(candidate, candidateApproved);
                }else{
                    System.out.println("Result: Not approved");
                    String candidateNotApproved =buildEmailForNotApprovedCandidate(candidate, jobReference);
                    emailService.sendEmail(candidate, candidateNotApproved);
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

    private String buildEmailForApprovedCandidate(String username, String jobReference) {

        String HTML =
                """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Email</title>
                </head>
                <body>
                    %s
                    %s
                    %s
                </body>
                </html>
                """;

        return String.format(HTML, username, jobReference);
    }

    public String buildEmailForNotApprovedCandidate (String username, String jobReference) {

        String HTML =
                """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Email</title>
                </head>
                <body>
                    %s
                    %s
                    %s
                </body>
                </html>
                """;

        return String.format(HTML,username, jobReference);
    }
}
