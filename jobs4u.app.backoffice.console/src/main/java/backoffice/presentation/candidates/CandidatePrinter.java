package backoffice.presentation.candidates;

import eapli.base.candidate.dto.CandidateDTO;
import eapli.framework.visitor.Visitor;

public class CandidatePrinter implements Visitor<CandidateDTO> {
    @Override
    public void visit(CandidateDTO candidateDTO) {
        System.out.printf("First name: %-15s Last name: %-15s Email: %-25s Phone Number: %-15s",
                candidateDTO.getFirstName(),
                candidateDTO.getLastName(),
                candidateDTO.getEmail(),
                candidateDTO.getPhoneNumber());
    }
}
