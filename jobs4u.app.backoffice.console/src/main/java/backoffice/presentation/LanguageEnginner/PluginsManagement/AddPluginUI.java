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
                    try {
                        title = Console.readLine("Plugin name: ");
                        className = "antlr.JobRequirement";
                        model = getFileTemplate();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    Optional<JobRequirement> jobRequirement = addJobRequirementController.addJobRequirement(title, className, model);

                    if (jobRequirement.isPresent()) {
                        System.out.println("Successfully registered");
                    } else {
                        System.out.println("Something went wrong. Try again.");
                    }


                    break;
                case "2":
                    valid = true;
                    try {
                        title = Console.readLine("Plugin name: ");
                        className = "antlr.InterviewModel";
                        model = getFileTemplate();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
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

    private String getFileTemplate() throws IOException {
        //TODO get file path, read file and transform into string
        String filePath = Console.readLine("File path: ");
        File file = new File(filePath);
        return FileUtils.readFileToString(file, "UTF-8");
    }

    @Override
    public String headline() {
        return "Deploy plugins";
    }
}
