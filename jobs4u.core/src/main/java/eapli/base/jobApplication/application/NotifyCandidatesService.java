package eapli.base.jobApplication.application;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;


public class NotifyCandidatesService {

    public NotifyCandidatesService() {
        // Empty constructor
    }
    public void buildEmailForSelectedCandidate(String to, int rank, String jobReference) {
        String emailBody = buildEmailForSelectedCandidateStr(to, rank, jobReference);
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
    private String buildEmailForSelectedCandidateStr(String username, int rank, String jobReference) {

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

        return String.format(HTML, username, rank, jobReference);
    }

    public String buildEmailForNonSelectedCandidates(String username, int rank, String jobReference) {

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

        return String.format(HTML,username, rank, jobReference);
    }
}
