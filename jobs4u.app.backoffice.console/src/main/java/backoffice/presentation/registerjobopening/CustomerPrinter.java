package backoffice.presentation.registerjobopening;

import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.visitor.Visitor;

public class CustomerPrinter implements Visitor<CustomerDTO> {
    @Override
    public void visit(CustomerDTO visitee) {
        System.out.println(visitee);
    }
}
