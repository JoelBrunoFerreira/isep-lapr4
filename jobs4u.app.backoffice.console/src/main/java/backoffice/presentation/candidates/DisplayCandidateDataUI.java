package backoffice.presentation.candidates;

import backoffice.presentation.authz.SystemUserPrinter;
import eapli.base.candidate.application.GetCandidateController;
import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Optional;

public class DisplayCandidateDataUI extends AbstractUI {

    GetCandidateController theController = new GetCandidateController();
    SystemUserPrinter printer = new SystemUserPrinter();


    @Override
    protected boolean doShow() {
        final String email = Console.readLine("Type the candidate's email:");

        Optional<Candidate> candidate = theController.findByEmail(new Email(email));

        if(!candidate.isPresent()){
            System.out.println("No data found.");
        }
        else{
            System.out.println("Found");
            printer.visit(candidate.get().user());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Candidate data:";
    }
}
