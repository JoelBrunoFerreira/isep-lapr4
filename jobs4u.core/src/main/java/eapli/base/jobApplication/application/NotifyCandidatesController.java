package eapli.base.jobApplication.application;

import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.Status;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class NotifyCandidatesController {
    private final AuthorizationService authz;
    private final JobOpeningSvc jobOpeningSvc;
    private final GetApplicationService getApplicationService;
    private final NotifyCandidatesService notifyCandidatesService;

    public NotifyCandidatesController() {
        authz = AuthzRegistry.authorizationService();
        jobOpeningSvc = new JobOpeningSvc();
        getApplicationService = new GetApplicationService();
        notifyCandidatesService = new NotifyCandidatesService();
    }

    public Iterable<JobOpeningDTO> getJobAppplicationRanks() {
        return jobOpeningSvc.listJobOpeningsByStatus(Status.ACTIVE_RESULT, authz.session().get().authenticatedUser());
        // Return List of JobOpenings in phase result
    }

    public void notifyCandidates(String jobReference, int vacancies) {
        int counter = 0;
        Map<Integer, String> results = new TreeMap<>();
        for (JobApplication jobApplication : getApplicationService.getJobApplicationsByJobReference(jobReference)) {
            results.put(jobApplication.getRank().valueOf(), jobApplication.getCandidate().getEmail().toString());
        }

        for (Map.Entry<Integer, String> entry : results.entrySet()) {

            if (counter < vacancies) {
                counter++;
                String first = notifyCandidatesService.buildEmailForSelectedCandidate(entry.getValue(), jobReference, entry.getKey());
                sendEmail(entry.getValue(), first);
            } else {
                String others = notifyCandidatesService.buildEmailForNonSelectedCandidates(entry.getValue(), jobReference, entry.getKey());
                sendEmail(entry.getValue(), others);
            }
        }
    }

    public void sendEmail(String to, String emailBody) {
        // From --> Our Domain
        final String from = "sys-admin@jobs4u-isep.xyz";

        // API Settings
        final String username = "api";
        final String password = "27b4dfc3f6f8fccdfdab16e45fdd8450";
        final String host = "live.smtp.mailtrap.io";

        // Mailtrap SMTP server config
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587"); // --> Recommended port by host

        // Authentication
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
        // Email message
        Session session = Session.getInstance(props, authenticator);
        try {
            Message message = new MimeMessage(session);
            // set From
            message.setFrom(new InternetAddress(from));
            // set To
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            // set email subject field
            message.setSubject("Jobs4u!");
            // set the content of the email message
            message.setContent(emailBody, "text/html");
            // send the email message
            Transport.send(message);
            System.out.println("Email Message Sent Successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
