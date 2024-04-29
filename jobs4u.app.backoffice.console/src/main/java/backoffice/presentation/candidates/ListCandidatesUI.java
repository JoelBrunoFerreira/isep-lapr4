package backoffice.presentation.candidates;

import backoffice.presentation.authz.SystemUserPrinter;
import eapli.base.candidate.application.GetCandidateController;
import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
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
