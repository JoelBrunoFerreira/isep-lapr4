package candidate.presentation.candidateUser;

import eapli.framework.actions.Action;

public class SignupRequestAction implements Action {
    @Override
    public boolean execute() {
        return new SignupRequestUI().show();
    }
}
