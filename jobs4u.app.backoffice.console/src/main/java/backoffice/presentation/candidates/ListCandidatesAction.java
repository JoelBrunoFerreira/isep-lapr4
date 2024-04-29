package backoffice.presentation.candidates;

import eapli.framework.actions.Action;

public class ListCandidatesAction implements Action {

    @Override
    public boolean execute() {
        return new backoffice.presentation.candidates.ListCandidatesUI().show();
    }
}
