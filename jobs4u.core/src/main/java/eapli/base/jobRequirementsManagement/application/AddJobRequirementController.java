package eapli.base.jobRequirementsManagement.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobRequirementsManagement.domain.JobRequirement;
import eapli.base.jobRequirementsManagement.domain.JobRequirementClass;
import eapli.base.jobRequirementsManagement.domain.JobRequirementTitle;
import eapli.base.jobRequirementsManagement.repository.JobRequirementRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;



import java.util.Optional;


public class AddJobRequirementController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final JobRequirementRepository jobRequirementRepository = PersistenceContext.repositories().jobRequirements();




    public Optional<JobRequirement> addJobRequirement(final String name, final String className) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.LANGUAGE_ENGINEER);

        JobRequirement jobRequirement = new JobRequirement(new JobRequirementTitle(name), new JobRequirementClass(className));

        return Optional.of(jobRequirementRepository.save(jobRequirement));
    }

}
