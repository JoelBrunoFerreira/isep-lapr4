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
        writer.write("<JOB_REQUIREMENT>\n");
        writer.write("<TITLE>\""+job+"\"</TITLE>\n");

        for (Map.Entry<String, String> entry : dataFields.entrySet()) {
            writer.write("<QUESTION_BLOCK>\n");
            writer.write("<QUESTION>\"" +entry.getKey()+ "\"</QUESTION>\n");

            if(isNumber(entry.getValue())) {
                writer.write("<CORRECT_ANSWER>" + entry.getValue() + "</CORRECT_ANSWER>\n");
            } else {
                writer.write("<CORRECT_ANSWER>\"" + entry.getValue() + "\"</CORRECT_ANSWER>\n");
            }
            writer.write("<CANDIDATE_ANSWER></CANDIDATE_ANSWER>\n");
            writer.write("</QUESTION_BLOCK>\n");
        }
        writer.write("</JOB_REQUIREMENT>\n");
        writer.write("<EOF>");
        writer.close();

    }

    private boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
