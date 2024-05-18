package backoffice.presentation.CustomerManager.JobApplicationsManagement;

import backoffice.presentation.CustomerManager.CustomerManagerMainMenu;
import backoffice.presentation.candidates.CandidatePrinter;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.jobApplication.application.ListApplicationController;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Optional;

public class ListJobApplicationsUI extends AbstractUI {


    ListApplicationController listApplicationController = new ListApplicationController();
    ListUsersController listUsersController = new ListUsersController();
    CandidatePrinter printer = new CandidatePrinter();

    @Override
    protected boolean doShow() {
        System.out.println("1. List by candidate");
        System.out.println("2. List by job opening");
        System.out.println("3. List all data of a specific application");
        System.out.println("0. Return");

        boolean valid = false;
        while (!valid) {
            System.out.println();
            System.out.println("Please choose an option");
            String value = Console.readLine("");

            final String email, reference;
            Iterable<JobApplicationDTO> jobApplications;

            switch (value) {
                case "1":
                    valid = true;
                    email = Console.readLine("Type the candidate's email:");

                    Optional<CandidateDTO> candidateDTO = listUsersController.findCandidateByEmail(email);

                    if (!candidateDTO.isPresent()) {
                        System.out.println("Candidate not found.");

                    } else {
                        System.out.println("Candidate found");
                        printer.visit(candidateDTO.get());

                        jobApplications = listApplicationController.listApplicationsByCandidate(email);

                        if (!jobApplications.iterator().hasNext()) {
                            System.out.println("No job applications for the selected candidate.");
                        } else {
                            for (JobApplicationDTO dto : jobApplications) {
                                System.out.println();
                                System.out.println("Job Opening: " + dto.JobOpeningReference);
                                System.out.println("State: " + dto.state);
                                System.out.println("Rank: " + dto.rank);
                                System.out.println("Interview grade: " + dto.interviewGrade);
                            }
                        }
                    }
                    break;
                case "2":
                    valid = true;
                    reference = Console.readLine("Type the Job Reference: ");
                    email = Console.readLine("Type the candidate's email:");

                    Optional<JobApplicationDTO> jobApplication = listApplicationController.getJobApplicationByEmailAndJobReference(email, reference);

                    if (!jobApplication.isPresent()) {
                        System.out.println("No job applications with the submitted data.");
                    } else {
                        System.out.println();
                        System.out.println("Job Opening: " + jobApplication.get().JobOpeningReference);
                        System.out.println("Candidate: " + jobApplication.get().candidateEmail);
                        System.out.println("State: " + jobApplication.get().state);
                        System.out.println("Rank: " + jobApplication.get().rank);
                        System.out.println("Interview grade: " + jobApplication.get().interviewGrade);
                    }
                    break;

                case "3":
                    valid = true;
                    reference = Console.readLine("Type the Job Reference: ");

                    jobApplications = listApplicationController.listApplicationsByJobOpeningId(reference);

                    if (!jobApplications.iterator().hasNext()) {
                        System.out.println("No job applications for the selected job opening.");
                    } else {
                        for (JobApplicationDTO dto : jobApplications) {
                            System.out.println();
                            System.out.println("Job Opening: " + dto.JobOpeningReference);
                            System.out.println("State: " + dto.state);
                            System.out.println("Rank: " + dto.rank);
                            System.out.println("Interview grade: " + dto.interviewGrade);
                        }
                    }
                    break;
                case "0":
                    valid = true;
                    new CustomerManagerMainMenu().buildCustomerManagerMenu();
                    break;

                default:
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "List Job Applications";
    }

}
