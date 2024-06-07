package eapli.base.jobApplication.application;

import eapli.base.interviewModelManagement.domain.InterviewModel;
import eapli.base.interviewModelManagement.integration.InterviewModelPlugin;
import eapli.base.jobApplication.domain.JobApplication;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class GenerateInterviewModelController {

    private final GetApplicationService jobApplicationSvc;
    private final AuthorizationService authz;
    private final JobOpeningSvc jobOpeningSvc;
    private final String generatedIMsPath = "./generatedIMs/";

    public GenerateInterviewModelController() {
        authz = AuthzRegistry.authorizationService();
        jobApplicationSvc = new GetApplicationService();
        jobOpeningSvc = new JobOpeningSvc();
    }

    public Iterable<JobApplicationDTO> getJobApplicationDTOs() {
        List<JobApplicationDTO> dtos = new ArrayList<>();
        for (JobApplication jA : jobApplicationSvc.getJobApplications()) {
            dtos.add(jA.toDTO());
        }
        return dtos;
    }

    public boolean generateInterviewTemplate(String jobReference, String candidate) {
        InterviewModel interviewModel = jobOpeningSvc.getJobOpeningByReference(jobReference).get().getInterviewModel();
        if (interviewModel == null) {
            System.out.println("No interview for current job opening!");
            return true;
        } else {
            String template = generateTemplate(interviewModel);
            writeToFile(template, candidate, jobReference);
            System.out.println("Template generated successfully.");
            return false;
        }
    }

    private void writeToFile(String content, String candidate, String jobReference) {
        try {
            //TODO file name
            File myObj = new File(generatedIMsPath + candidate + "_" + jobReference + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String generateTemplate(InterviewModel interviewModel) {
        String path = interviewModel.getInterviewModelTemplate().toString();
        InterviewModelPlugin plugin = interviewModel.buildThePlugin();
        return plugin.generateTemplate(interviewModel.getInterviewModelTemplate().toString());
    }
}
