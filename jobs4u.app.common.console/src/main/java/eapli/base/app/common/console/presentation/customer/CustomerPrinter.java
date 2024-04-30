package eapli.base.app.common.console.presentation.customer;

import eapli.base.app.common.console.presentation.util.TableFormatPrinter;
import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.visitor.Visitor;

public class CustomerPrinter implements Visitor<CustomerDTO> {
  @Override
  public void visit(final CustomerDTO visitee) {
    TableFormatPrinter printer = new TableFormatPrinter();

    printer.addColumn(visitee.getEmail(), 20);
    printer.addColumn(visitee.getAddress(), 20);
    printer.addColumn(visitee.getAcronym(), 20);

    System.out.print(printer.format());
  }
}
