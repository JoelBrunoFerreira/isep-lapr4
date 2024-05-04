package eapli.base.usermanagement.application;

import eapli.base.candidate.dto.CandidateDTO;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ListUsersControllerTest {

    ListUsersController listUsersController = new ListUsersController();
    @Test
    void findCandidateByEmail() {


        Optional<CandidateDTO> candidate = listUsersController.findCandidateByEmail("john@isep.pt");

        assertNotNull(candidate.get());
        assertNotNull(candidate.get().getEmail());
        assertNotNull(candidate.get().getPhoneNumber());
        assertNotNull(candidate.get().getFirstName());
    }
}