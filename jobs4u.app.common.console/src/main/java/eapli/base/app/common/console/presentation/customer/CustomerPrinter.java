package eapli.base.app.common.console.presentation.customer;

import eapli.base.app.common.console.presentation.util.TableFormatPrinter;
import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.visitor.Visitor;

public class CustomerPrinter implements Visitor<CustomerDTO> {
  @Override
  public void visit(final CustomerDTO visitee) {
    System.out.print(visitee);
  }
}
