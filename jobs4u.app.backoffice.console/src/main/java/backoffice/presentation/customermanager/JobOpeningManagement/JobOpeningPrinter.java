package backoffice.presentation.customermanager.JobOpeningManagement;

import eapli.base.JobOpeningManagement.dto.JobOpeningDTO;
import eapli.base.app.common.console.presentation.util.TableFormatPrinter;
import eapli.framework.visitor.Visitor;

public class JobOpeningPrinter implements Visitor<JobOpeningDTO> {
    @Override
    public void visit(final JobOpeningDTO visitee) {
        System.out.print(visitee);
    }
}