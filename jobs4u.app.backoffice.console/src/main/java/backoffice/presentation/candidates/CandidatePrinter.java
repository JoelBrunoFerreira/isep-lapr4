package backoffice.presentation.candidates;

import eapli.base.candidate.dto.CandidateDTO;
import eapli.framework.visitor.Visitor;

public class CandidatePrinter implements Visitor<CandidateDTO> {
    @Override
    public void visit(CandidateDTO candidateDTO) {
        System.out.printf("%s - %s - %s - %s", candidateDTO.getFirstName(), candidateDTO.getLastName(), candidateDTO.getEmail(), candidateDTO.getPhoneNumber());
    }
}
