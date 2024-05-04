package backoffice.presentation.operator;

import backoffice.presentation.candidates.CandidatePrinter;
import eapli.base.candidate.domain.Candidate;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.presentation.console.AbstractUI;

public class ListCandidateUI extends AbstractUI {
    ListUsersController controller = new ListUsersController();
    CandidatePrinter printer = new CandidatePrinter();

    @Override
    protected boolean doShow() {
        Iterable<Candidate> candidateDTO = controller.listAllCandidates();

        if(!candidateDTO.iterator().hasNext()){
            System.out.println("No Candidates found in DB.");
        }
        else{
            System.out.println("=======================");
            System.out.print(headline());
            System.out.println("=======================");
            for (Candidate candidate : controller.listAllCandidates()) {
                printer.visit(candidate.toDTO());
                System.out.println();
            }
            System.out.println();
        }

        return true;
    }

    @Override
    public String headline() {
        return "List of all Candidates\n";
    }
}
