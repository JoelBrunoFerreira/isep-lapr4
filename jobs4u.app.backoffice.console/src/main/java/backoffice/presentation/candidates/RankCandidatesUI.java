package backoffice.presentation.candidates;

import eapli.base.jobApplication.application.ListApplicationController;
import eapli.base.jobApplication.application.RankJobApplicationController;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
public class RankCandidatesUI extends AbstractUI{

    ListApplicationController listApplicationController = new ListApplicationController();
    RankJobApplicationController rankJobApplicationController = new RankJobApplicationController();
    CandidatePrinter printer = new CandidatePrinter();
    @Override
    protected boolean doShow() {
        String reference = Console.readLine("Type the Job Reference: ");
        Iterable<JobApplicationDTO> jobApplications = listApplicationController.listApplicationsByJobOpeningId(reference);

        if (!jobApplications.iterator().hasNext()) {
            System.out.println("No job applications for the selected job opening.");
        } else {
            System.out.println("Current job applications:");
            for (JobApplicationDTO dto : jobApplications) {
                System.out.println();
                System.out.println("Job Opening: " + dto.JobOpeningReference);
                System.out.println("Candidate email: " + dto.candidateEmail);
                System.out.println("State: " + dto.state);
                System.out.println("Rank: " + dto.rank);
                System.out.println("Interview grade: " + dto.interviewGrade);
            }

            System.out.println();
            System.out.println("Ranking candidates: ");
            for (JobApplicationDTO dto: jobApplications) {
                System.out.println();
                System.out.println("Candidate email: " + dto.candidateEmail);
                String rank = Console.readLine("Rank: " );
                JobApplication application = rankJobApplicationController.rankCandidatesForJobApplication(rank, dto.candidateEmail, reference);
            }

        }

        return true;
    }

    @Override
    public String headline() {
        return "Rank Candidates";
    }
}
