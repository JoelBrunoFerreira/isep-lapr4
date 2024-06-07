package backoffice.presentation.interviewModel;

import backoffice.presentation.CustomerManager.JobOpeningManagement.JobOpeningPrinter;
import eapli.base.interviewModelManagement.application.GenerateInterviewTemplateController;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateInterviewModelTemplateUI extends AbstractUI {

    private final GenerateInterviewTemplateController controller = new GenerateInterviewTemplateController();

    private JobOpeningDTO getJobOpening() {
        Iterable<JobOpeningDTO> jobOpeningDTOS = controller.listJobOpeningsDTO();
        if (!jobOpeningDTOS.iterator().hasNext()){
            System.out.println("No job openings are pending.");
            return null;
        } else {
            SelectWidget<JobOpeningDTO> selectJobOpeningDTO = new SelectWidget<>("Job Openings:", jobOpeningDTOS, new JobOpeningPrinter());
            selectJobOpeningDTO.show();
            return selectJobOpeningDTO.selectedElement();
        }

    }

    @Override
    public boolean doShow() {

        JobOpeningDTO jobOpeningDTO = getJobOpening();
        if (jobOpeningDTO == null) {
            System.out.println("Returning to main menu...");
            return false;
        } else {

            String template = null;

            try {
                template = controller.generateInterviewTemplate(jobOpeningDTO.getJobReference());
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }


            if (template != null && !template.isEmpty()) {
                String folderPath = Console.readLine("Insert destination folder for the interview template:");
                if (!folderPath.endsWith("\\")) {
                    folderPath = folderPath.concat("\\");
                }
                File folder = new File(folderPath);
                if (folder.exists() && folder.isDirectory()) {
                    String fileName = Console.readLine("Insert the name of the interview template:");
                    String filePath = folderPath + fileName + ".txt";
                    File file = new File(filePath);
                    try {
                        if (file.createNewFile()) {
                            FileWriter fw = new FileWriter(filePath);
                            fw.write(template);
                            fw.flush();
                            fw.close();
                            System.out.println("File has been created! (" + filePath + ")");
                        } else {
                            System.out.println("File already exists!");
                        }
                    } catch (IOException e) {
                        // throw new RuntimeException(e);
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("File path does not exist or it's not a valid folder!");
                }
            }

        return true;
        }
    }

    @Override
    public String headline() {
        return "";
    }
}
