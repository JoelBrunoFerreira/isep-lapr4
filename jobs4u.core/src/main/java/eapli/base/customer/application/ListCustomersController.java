package eapli.base.customer.application;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 *
 * @author losa
 */
public class ListCustomersController {
  private final AuthorizationService authz = AuthzRegistry.authorizationService();

  private final CustomerRepository repo = PersistenceContext.repositories().customers();
  private final CustomerService service = new CustomerService();

  public Iterable<Customer> activeCustomers() {
    authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);

    return this.repo.findAllActive();
  }

  public Iterable<CustomerDTO> allCustomers() {
    authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);

    //return service.findAll();
    return null;
  }
}
