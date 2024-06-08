package backoffice.presentation.LanguageEnginner.PluginsManagement;

import backoffice.presentation.LanguageEnginner.LanguageEngineerMainMenu;
import eapli.base.interviewModelManagement.application.AddInterviewModelController;
import eapli.base.interviewModelManagement.domain.InterviewModel;
import eapli.base.jobRequirementsManagement.application.AddJobRequirementController;
import eapli.base.jobRequirementsManagement.domain.JobRequirement;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
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
        String model;


        boolean valid = false;
        while (!valid) {
            System.out.println();
            System.out.println("Please choose an option");
            String value = Console.readLine("");

            switch (value) {
                case "1":
                    valid = true;
                    title = Console.readLine("Plugin name: ");
                    //TODO change class name
                    className = "app.JRPlugin";
                    model = Console.readLine("File Path: "); //getFileTemplate();


                    Optional<JobRequirement> jobRequirement = addJobRequirementController.addJobRequirement(title, className, model);

                    if (jobRequirement.isPresent()) {
                        System.out.println("Successfully registered");
                    } else {
                        System.out.println("Something went wrong. Try again.");
                    }


                    break;
                case "2":
                    valid = true;

                    title = Console.readLine("Plugin name: ");
                    className = "app.IMPlugin";
                    model = Console.readLine("File Path: "); //getFileTemplate();

                    Optional<InterviewModel> interviewModel = addInterviewModelController.addInterviewModel(title, className, model);

                    if (interviewModel.isPresent()) {
                        System.out.println("Successfully registered");
                    } else {
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
