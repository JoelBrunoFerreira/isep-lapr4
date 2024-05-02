package backoffice.presentation.candidates;

import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.domain.Email;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Optional;

public class DisplayCandidateDataUI extends AbstractUI {

    ListUsersController theController = new ListUsersController();
    CanidateDTOPrinter printer = new CanidateDTOPrinter();

    @Override
    protected boolean doShow() {
        final String email = Console.readLine("Type the candidate's email:");

        Optional<CandidateDTO> candidateDTO = theController.findCandidateByEmail(email);

        if(!candidateDTO.isPresent()){
            System.out.println("No data found.");
        }
        else{
            System.out.println("Found");
            printer.print(candidateDTO.get());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Candidate data:";
    }


}
