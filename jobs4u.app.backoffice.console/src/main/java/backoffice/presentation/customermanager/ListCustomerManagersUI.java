package backoffice.presentation.customermanager;


import backoffice.presentation.authz.ListUsersUI;
import eapli.base.customerManager.application.ListCustomerManagerController;
import eapli.base.customerManager.domain.CustomerManager;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class ListCustomerManagersUI extends ListUsersUI {
  private final ListCustomerManagerController controller = new ListCustomerManagerController();

  @Override
  public String headline() {
    return "List Users";
  }

  @Override
  protected String elementName() {
    return "Customer Manager";
  }

  @Override
  protected Iterable<CustomerManager> elements() {
    return controller.allCustomerManagers();
  }
}
