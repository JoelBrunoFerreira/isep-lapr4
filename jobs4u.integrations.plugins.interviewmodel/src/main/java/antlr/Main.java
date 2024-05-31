package antlr;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String interview = "jobs4u.integrations.plugins.interviewmodel/src/main/java/antlr/inputfiles/modelo.txt";
        String jobRequirements = "jobs4u.integrations.plugins.interviewmodel/src/main/java/antlr/inputfiles/JobRequirement_1.txt";

        InterviewModel interviewModel = new InterviewModel();

        System.out.println("--------------Interview------------------");
        System.out.println(interviewModel.generateTemplate(interview));
        JobRequirement jobRequirement = new JobRequirement();
        System.out.println("--------------Job Requirement------------------");
        System.out.println(jobRequirement.generateTemplate(jobRequirements));
        System.out.println();
    }
}