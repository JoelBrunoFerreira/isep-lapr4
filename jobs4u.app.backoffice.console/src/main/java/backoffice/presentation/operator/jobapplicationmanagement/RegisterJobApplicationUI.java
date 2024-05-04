package backoffice.presentation.operator.jobapplicationmanagement;

import backoffice.presentation.candidates.CandidatePrinter;
import backoffice.presentation.operator.AddCandidateUI;
import eapli.base.JobApplication.application.RegisterJobApplicationController;
import eapli.base.JobApplication.dto.JobApplicationDTO;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RegisterJobApplicationUI extends AbstractUI {

    private final RegisterJobApplicationController controller = new RegisterJobApplicationController();

    @Override
    public boolean doShow() {
        String directoryPath = Console.readLine("Path: ");
        String jobReference = getFolderName(directoryPath);
        directoryPath = directoryPath.concat("\\").concat(jobReference);
        String candidateEmail = getFolderName(directoryPath);
        if (controller.checkIfApplicationExists(candidateEmail)){
            System.out.println("Application already registered!");
            return false;
        }
        if (!controller.candidateExists(candidateEmail)) {
            new AddCandidateUI().doShow();
        }
        directoryPath = directoryPath.concat("\\").concat(candidateEmail);
        JobApplicationDTO result = controller.registerJobApplication(directoryPath,candidateEmail,jobReference);
        System.out.println("Job application for " + result.getJobOpeningReference() +" and candidate "+ result.getCandidateEmail()+ " registered successfully!");
        return true;
    }
    

    @Override
    public String headline() {
        return "Register Job Application";
    }

    private List<String> getSubfolderNames(String directoryPath) {
        List<String> subfolderNames = new ArrayList<>();
        File directory = new File(directoryPath);

        // Check if the provided path is a directory
        if (!directory.isDirectory()) {
            System.out.println("Error: Provided path is not a directory.");
            return subfolderNames;
        }

        // Get list of subfolders
        File[] subfolders = directory.listFiles(File::isDirectory);

        // Check if there are any subfolders
        if (subfolders == null || subfolders.length == 0) {
            System.out.println("No subfolders found in the directory.");
            return subfolderNames;
        }

        // Print the names of subfolders
        for (File subfolder : subfolders) {
            String subfolderName = subfolder.getName();
            subfolderNames.add(subfolderName);
        }
        return subfolderNames;
    }

    public String getFolderName(String directoryPath) {
        List<String> jobReferenceList = getSubfolderNames(directoryPath);
        if (jobReferenceList.isEmpty()){
            return null;
        }
        SelectWidget<String> selectWidget = new SelectWidget<>("Folder:", jobReferenceList, visitee -> System.out.print(visitee));
        selectWidget.show();

        return selectWidget.selectedElement();
    }
}
