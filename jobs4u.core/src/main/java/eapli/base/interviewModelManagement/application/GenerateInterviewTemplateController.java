package eapli.base.interviewModelManagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.interviewModelManagement.domain.InterviewModel;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.domain.JobReference;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.jobOpeningManagement.repositories.JobOpeningRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Optional;

public class GenerateInterviewTemplateController {

    private final JobOpeningRepository jobOpeningRepository;

    private final AuthorizationService authz;

    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();

    public Iterable<JobOpeningDTO> listJobOpeningsDTO() {
        return jobOpeningSvc.listJobOpeningsByUser(authz.session().get().authenticatedUser());
    }

    public GenerateInterviewTemplateController(){
        this.authz= AuthzRegistry.authorizationService();
        this.jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    }

    //US1012
    public String generateInterviewTemplate (String jobOpeningID){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);

        Optional<JobOpening> jobOpeningOptional = jobOpeningRepository.ofIdentity(new JobReference(jobOpeningID));
        if(!jobOpeningOptional.isPresent()){
            throw new IllegalArgumentException("Job opening not found!");
        }



        JobOpening jobOpening = jobOpeningOptional.get();
        InterviewModel interviewModel = jobOpening.interviewModel(); //gets the interview model for that jobOpening
        if (interviewModel == null) {
            throw new IllegalArgumentException("Interview model not found!");
        }
        var interviewModelPlugin = interviewModel.buildThePlugin(); //var is to be able to instantiate an interface
        return interviewModelPlugin.generateTemplate(interviewModel.getInterviewModelTemplate().toString());
    }

}
