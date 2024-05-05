package backoffice.presentation.LanguageEnginner.PluginsManagement;

import backoffice.presentation.CustomerManager.CustomerManagerMainMenu;
import backoffice.presentation.LanguageEnginner.LanguageEngineerMainMenu;
import eapli.base.InterviewModelManagement.application.AddInterviewModelController;
import eapli.base.InterviewModelManagement.domain.InterviewModel;
import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.jobRequirementsManagement.application.AddJobRequirementController;
import eapli.base.jobRequirementsManagement.domain.JobRequirement;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Optional;

public class AddPluginUI extends AbstractUI {


    AddInterviewModelController addInterviewModelController = new AddInterviewModelController();
    AddJobRequirementController addJobRequirementController = new AddJobRequirementController();

    @Override
    protected boolean doShow() {
        System.out.println("1. Register job requirement");
        System.out.println("2. Register interview model");
        System.out.println("0. Return");
        String title;
        String className;

        boolean valid = false;
        while (!valid) {
            System.out.println();
            System.out.println("Please choose an option");
            String value = Console.readLine("");

            switch (value) {
                case "1":
                    valid = true;

                    title = Console.readLine("Plugin name: ");
                    className = Console.readLine("Plugin class: ");

                    Optional<JobRequirement> jobRequirement = addJobRequirementController.addJobRequirement(title, className);

                    if (jobRequirement.isPresent()) {
                        System.out.println("Successfully registered");
                    }
                    else {
                        System.out.println("Something went wrong. Try again.");
                    }


                    break;
                case "2":
                    valid = true;

                    title = Console.readLine("Plugin name: ");
                    className = Console.readLine("Plugin class: ");

                    Optional<InterviewModel> interviewModel = addInterviewModelController.addInterviewModel(title, className);

                    if (interviewModel.isPresent()) {
                        System.out.println("Successfully registered");
                    }
                    else {
                        System.out.println("Something went wrong. Try again.");
                    }
                    break;

                case "0":
                    valid = true;
                    new LanguageEngineerMainMenu().buildLanguageEngineerManagerMenu();
                    break;

                default:
            }
        }
        return true;


    }

    @Override
    public String headline() {
        return "Deploy plugins";
    }
}
