package eapli.base.jobApplication.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class NotifyCandidatesController {
    private final AuthorizationService authz;
    private final JobApplicationRepository applicationRepository;

    public NotifyCandidatesController() {
        authz = AuthzRegistry.authorizationService();
        applicationRepository= PersistenceContext.repositories().jobApplications();
    }


    /*
    public int getCandidateRanks() {

    }

     */




    public String buildEmailHTMLSuccess(String firstName, String lastName, int rank, String jobReference) {

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
                    <h1>Welcome to Jobs4u</h1>
                    <p>Mr./Mrs. %s %s thank you for registering on our app.</p>
                    <p>Your username is: %s</p>
                    <p>Your password is: %s</p>
                    <p>Best of luck!</p>
                    <br>
                    <footer>
                        <p>Made with &#x1F493; by Code Warriors - All rights reserved</p>
                    </footer>
                </body>
                </html>
                """;

        return String.format(HTML, firstName, lastName, rank, jobReference);
    }

    public String buildEmailHTMLInsuccess(String firstName, String lastName, int rank, String jobReference) {

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
                    <h1>Welcome to Jobs4u</h1>
                    <p>Mr./Mrs. %s %s thank you for registering on our app.</p>
                    <p>Your username is: %s</p>
                    <p>Your password is: %s</p>
                    <p>Best of luck!</p>
                    <br>
                    <footer>
                        <p>Made with &#x1F493; by Code Warriors - All rights reserved</p>
                    </footer>
                </body>
                </html>
                """;

        return String.format(HTML, firstName, lastName, rank, jobReference);
    }

}
