package backoffice.presentation.CustomerManager.JobApplicationsManagement;

import backoffice.presentation.CustomerManager.CustomerManagerMainMenu;
import backoffice.presentation.backofficeUser.SignupRequestAction;
import backoffice.presentation.candidates.CandidatePrinter;
import backoffice.presentation.operator.OperatorMainMenu;
import eapli.base.Application;
import eapli.base.JobApplication.application.ListApplicationController;
import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.infrastructure.authz.AuthenticationCredentialHandler;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.actions.Actions;
import eapli.framework.actions.ChainedAction;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.Optional;

public class ListJobApplicationsUI extends AbstractUI {


    ListApplicationController listApplicationController = new ListApplicationController();
    ListUsersController listUsersController = new ListUsersController();
    CandidatePrinter printer = new CandidatePrinter();

    @Override
    protected boolean doShow() {
        System.out.println("1. List by candidate");
        System.out.println("2. List by job opening");
        System.out.println("0. Return");

        boolean valid = false;
        while (!valid) {
            System.out.println();
            System.out.println("Please choose an option");
            String value = Console.readLine("");

            switch (value) {
                case "1":
                    valid = true;
                    final String email = Console.readLine("Type the candidate's email:");

                    Optional<CandidateDTO> candidateDTO = listUsersController.findCandidateByEmail(email);

                    if (!candidateDTO.isPresent()) {
                        System.out.println("Candidate not found.");

                    } else {
                        System.out.println("Candidate found");
                        printer.visit(candidateDTO.get());

                        Iterable<JobApplicationDTO> jobApplications = listApplicationController.listApplicationsByCandidate(email);

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
                    final String reference = Console.readLine("Type the Job Reference: ");

                    Iterable<JobApplicationDTO> jobApplications = listApplicationController.listApplicationsByJobOpeningId(reference);

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
                    new CustomerManagerMainMenu().displayCustomerManagerMenu();
                    break;

                default:
            }
        }
        return true;
    }

        @Override
        public String headline () {
            return "List Job Applications";
        }

    }
