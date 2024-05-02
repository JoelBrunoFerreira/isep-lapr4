package backoffice.presentation.CustomerManager.customerManagement;

import eapli.base.app.common.console.presentation.customer.CustomerPrinter;
import eapli.base.customer.application.ListCustomersController;
import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.presentation.console.AbstractListUI;
import eapli.framework.visitor.Visitor;

public class ListCustomersUI extends AbstractListUI<CustomerDTO> {
  private final ListCustomersController controller = new ListCustomersController();

  @Override
  public String headline() {
    return "List Customers";
  }

  @Override
  protected String emptyMessage() {
    return "No data.";
  }

  @Override
  protected Iterable<CustomerDTO> elements() {
    return controller.allCustomers();
  }

  @Override
  protected Visitor<CustomerDTO> elementPrinter() {
    return new CustomerPrinter();
  }

  @Override
  protected String elementName() {
    return "Customer";
  }

  @Override
  protected String listHeader() {
    return String.format("#  %-15s%-20s%-30s%-30s", "Mec. Number", "Username", "F. Name", "L. Name");
  }
}
