package eapli.base.jobRequirementsManagement.application;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class GenerateJobRequirementsController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public GenerateJobRequirementsController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.OPERATOR);
    }

    public void formTemplate(String job, TreeMap<String, String> dataFields, String filePath) throws IOException {

        FileWriter writer = new FileWriter(filePath + "/" + job + ".txt");
        for (Map.Entry<String, String> entry : dataFields.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        writer.close();

    }

}
