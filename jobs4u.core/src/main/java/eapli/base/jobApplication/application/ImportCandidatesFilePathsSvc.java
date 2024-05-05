package eapli.base.jobApplication.application;

import eapli.framework.presentation.console.SelectWidget;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImportCandidatesFilePathsSvc {
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
