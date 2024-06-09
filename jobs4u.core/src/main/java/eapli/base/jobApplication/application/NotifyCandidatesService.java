package eapli.base.jobApplication.application;

public class NotifyCandidatesService {

    public NotifyCandidatesService() {
        // Empty constructor
    }

    public String buildEmailForSelectedCandidate(String username, int rank, String jobReference) {

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

        return String.format(HTML,username, rank, jobReference);
    }
}
