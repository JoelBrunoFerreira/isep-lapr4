package eapli.base.jobRequirementsManagement.integration;

import java.io.IOException;

public interface JobRequirementPlugin {

    String generateTemplate(String model);

    JobRequirementResult validateRequirements(String model, String requirements) throws IOException;

}
