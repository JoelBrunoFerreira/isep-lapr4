package candidate.application;

import java.io.IOException;

public class CandidateLoginController {
    public boolean login(String username, String password) throws IOException {
        return SrvProxy.candidateLogin(username, password);
    }
}
