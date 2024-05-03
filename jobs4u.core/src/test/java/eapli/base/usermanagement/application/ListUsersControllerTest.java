package eapli.base.usermanagement.application;

import eapli.base.candidate.domain.Candidate;
import eapli.base.candidate.dto.CandidateDTO;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ListUsersControllerTest {

    ListUsersController listUsersController = new ListUsersController();
    @Test
    void findCandidateByEmail() {


        Optional<CandidateDTO> candidate = listUsersController.findCandidateByEmail("john@isep.pt");

        assertNotNull(candidate.get());
        assertNotNull(candidate.get().getEmail());
        assertNotNull(candidate.get().getPhoneNumber());
        assertNotNull(candidate.get().getName());
    }
}