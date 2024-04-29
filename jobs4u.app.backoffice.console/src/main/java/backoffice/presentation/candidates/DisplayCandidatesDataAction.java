package backoffice.presentation.candidates;

import eapli.framework.actions.Action;

public class DisplayCandidatesDataAction implements Action {
    @Override
    public boolean execute() {
        return new backoffice.presentation.candidates.DisplayCandidateDataUI().show();
    }
}
