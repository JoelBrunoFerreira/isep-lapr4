package backoffice.presentation.candidates;

import eapli.base.candidate.dto.CandidateDTO;

public class CanidateDTOPrinter {
    public void print(final CandidateDTO dto) {
        System.out.printf("%-30s%-30s%-30s\n", dto.getEmail(), dto.getName(), dto.getPhoneNumber());
    }

}
