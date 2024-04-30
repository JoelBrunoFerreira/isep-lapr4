package backoffice.presentation.candidates;

import eapli.framework.presentation.console.AbstractUI;

public class DisplayCandidateDataUI extends AbstractUI {
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

     */
}
