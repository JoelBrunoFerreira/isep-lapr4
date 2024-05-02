package backoffice.presentation.CustomerManager.JobOpeningManagement;

import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.framework.visitor.Visitor;

public class JobOpeningPrinter implements Visitor<JobOpeningDTO> {
    @Override
    public void visit(final JobOpeningDTO visitee) {
        System.out.print(visitee);
    }
}