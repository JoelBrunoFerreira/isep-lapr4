package backoffice.presentation.candidates;

import backoffice.presentation.authz.SystemUserPrinter;
import eapli.base.candidate.application.GetCandidateController;
import eapli.base.candidate.domain.Candidate;
import eapli.framework.presentation.console.AbstractUI;

public class ListCandidatesUI extends AbstractUI {

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
}
