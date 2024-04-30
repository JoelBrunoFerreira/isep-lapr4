package backoffice.presentation.candidates;

import eapli.framework.presentation.console.AbstractUI;

public class ListCandidatesUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        return false;
    }

    @Override
    public String headline() {
        return null;
    }

    /*
    GetCandidateController theController = new GetCandidateController();
    SystemUserPrinter printer = new SystemUserPrinter();

    @Override
    protected boolean doShow() {
        Iterable<Candidate> candidates = theController.allCandidates();

        for(Candidate candidate: candidates){
            printer.visit(candidate.user());
        }

        return true;
    }

    @Override
    public String headline() {
        return "ALL CANDIDATES";
    }

     */
}
