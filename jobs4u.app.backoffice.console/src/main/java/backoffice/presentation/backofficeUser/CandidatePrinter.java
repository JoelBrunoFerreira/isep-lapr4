package backoffice.presentation.backofficeUser;

import eapli.base.candidate.dto.CandidateDTO;
import eapli.framework.visitor.Visitor;

public class CandidatePrinter implements Visitor<CandidateDTO> {
    @Override
    public void visit(CandidateDTO candidateDTO) {
        System.out.printf("%s - %s - %s", candidateDTO.getName(), candidateDTO.getEmail(), candidateDTO.getPhoneNumber());
    }
}
