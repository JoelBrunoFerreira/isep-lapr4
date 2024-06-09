package eapli.base.jobApplication.application;

public class NotifyCandidatesService {

    public NotifyCandidatesService() {
        // Empty constructor
    }

    public String buildEmailForSelectedCandidate(String username, String jobReference, int rank) {

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
                    <h1>Jobs4u</h1>
                    <p>Mr./Mrs. %s following your job application @%s, we would like to congratulate you.</p>
                    <p>You took the %S place, the job is yours.</p>
                    <p>Best of luck!</p>
                    <br>
                    <footer>
                        <p>Made with &#x1F493; by Code Warriors - All rights reserved</p>
                    </footer>
                </body>
                </html>
                """;

        return String.format(HTML, username, jobReference, rank);
    }

    public String buildEmailForNonSelectedCandidates(String username, String jobReference, int rank) {

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
                    <h1>Jobs4u</h1>
                    <p>Mr./Mrs. %s following your job application @%s, we would like inform you that you were not selected.</p>
                    <p>You took the %S place.</p>
                    <p>Best of luck!</p>
                    <br>
                    <footer>
                        <p>Made with &#x1F493; by Code Warriors - All rights reserved</p>
                    </footer>
                </body>
                </html>
                """;

        return String.format(HTML, username, jobReference, rank);
    }
}
