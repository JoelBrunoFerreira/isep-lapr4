package backoffice.presentation.users;


import backoffice.presentation.authz.ListUsersUI;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class ListCustomerManagersUI extends ListUsersUI {
  private final ListUsersController controller = new ListUsersController();

  @Override
  public String headline() {
    return "List Users";
  }

  @Override
  protected String elementName() {
    return "Customer Manager";
  }

  @Override
  protected Iterable<SystemUser> elements() {
    return controller.allCustomerManagers();
  }
}
