package eapli.base.candidate.application;

import eapli.base.candidate.domain.Email;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.candidate.repository.CandidateRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.jobApplication.dto.JobApplicationDTO;
import eapli.base.jobApplication.repository.JobApplicationRepository;
import eapli.base.jobOpeningManagement.application.JobOpeningSvc;
import eapli.base.jobOpeningManagement.domain.JobOpening;
import eapli.base.jobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.ListWidget;

import java.util.*;

@UseCaseController
public class DisplayRankedCandidatesController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();;
    private final SystemUser user;
    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();
    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();
    private final JobOpeningSvc jobOpeningSvc = new JobOpeningSvc();

    public DisplayRankedCandidatesController() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        user = authz.session().get().authenticatedUser();
    }
    public Iterable<JobOpeningDTO> getJobOpeningDTOs(){
        List<JobOpeningDTO> result = new ArrayList<>();
        for (JobOpeningDTO dto : jobOpeningSvc.listJobOpeningsByUser(user)){
            if (dto.hasInterviewPhase()){
                result.add(dto);
            }
        }
        return result;
    }

    public List<Map.Entry<CandidateDTO, Integer>> candidateDTOS(String jobReference) {
        Map<CandidateDTO, Integer> result = new HashMap<>();
        Iterable<JobApplicationDTO> jobApplicationDTOS = jobApplicationRepository.getRankedApplicationsByJobReference(jobReference);
        if (jobApplicationDTOS.iterator().hasNext()){
            for (JobApplicationDTO dto : jobApplicationDTOS) {
                CandidateDTO candidateDTO = getCandidateDTO(dto.getCandidateEmail());
                if (candidateDTO != null) {
                    result.put(candidateDTO, dto.getInterviewGrade());
                }
            }
        }
        List<Map.Entry<CandidateDTO, Integer>> entryList = new ArrayList<>(result.entrySet());
        entryList.sort(new Comparator<Map.Entry<CandidateDTO, Integer>>() {
            @Override
            public int compare(Map.Entry<CandidateDTO, Integer> e1, Map.Entry<CandidateDTO, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        return entryList;
    }

    private CandidateDTO getCandidateDTO(String email){
        return candidateRepository.findByEmail(new Email(email)).get().toDTO();
    }

}
