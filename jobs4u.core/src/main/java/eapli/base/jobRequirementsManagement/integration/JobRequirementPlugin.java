package eapli.base.jobRequirementsManagement.integration;

import java.io.IOException;

public interface JobRequirementPlugin {

    String generateTemplate(String path);

    JobRequirementResult validateRequirements(String path) throws IOException;

}
