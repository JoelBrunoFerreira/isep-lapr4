package backoffice.presentation.operator.jobapplicationmanagement;

import eapli.base.jobRequirementsManagement.application.GenerateJobRequirementsController;
import eapli.framework.io.util.Console;

import java.io.IOException;
import java.util.TreeMap;


public class GenerateJobRequirementsTemplateUI {
    private final TreeMap<String, String> dataFields;
    private final GenerateJobRequirementsController generateJobRequirementsController = new GenerateJobRequirementsController();
    public GenerateJobRequirementsTemplateUI() {
        this.dataFields = new TreeMap<>();
    }
    public void display() {
        System.out.println("===================================");
        System.out.println("Generate Template for Job Opening: ");
        System.out.println("===================================");
        String typeOfJobOpening = Console.readLine("Insert the type of Job Opening: ");
        int numberOfQuestions = Console.readInteger("How many questions should the template have: ");

        for (int i = 1; i <= numberOfQuestions; i++) {
            String question = Console.readLine("Insert question: " + i);
            String answer = Console.readLine("Insert answer: " + i);
            dataFields.put(question, answer);
        }

        String filePath = Console.readLine("Insert the path where you want to store the template: ");
        System.out.println();

        try{
            generateJobRequirementsController.formTemplate(typeOfJobOpening, dataFields, filePath);
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("Template generated successfully");
        System.out.println();
    }
}
