package eapli.base.app.common.console.presentation.customer;

import eapli.base.app.common.console.presentation.util.TableFormatPrinter;
import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.visitor.Visitor;

public class CustomerPrinter implements Visitor<CustomerDTO> {
  @Override
  public void visit(final CustomerDTO visitee) {
    TableFormatPrinter printer = new TableFormatPrinter();

    printer.addColumn(visitee.getUsername().toString(), 20);
    printer.addColumn(visitee.getAddress().toString(), 20);
    printer.addColumn(visitee.getCode().toString(), 30);

    System.out.print(printer.format());
  }
}
