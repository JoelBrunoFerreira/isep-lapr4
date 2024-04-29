package eapli.base.customermanagement.application;


import eapli.base.customermanagement.domain.Customer;
import eapli.base.customermanagement.dto.CustomerDTO;
import eapli.base.customermanagement.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author mcn
 */
@ApplicationService
public class CustomerService {
  private final AuthorizationService authz = AuthzRegistry.authorizationService();
  private final CustomerRepository repo = PersistenceContext.repositories().customers();


  public Optional<Customer> findCustomerByUsername(final Username user) {
    authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);
    return repo.findByUsername(user);
  }

  public Iterable<CustomerDTO> findAll() {
    final Iterable<Customer> customers = repo.findAll();
    return convertToDto(customers);

  }

  private Iterable<CustomerDTO> convertToDto(Iterable<Customer> customers) {
    return StreamSupport.stream(customers.spliterator(), true)
            .map(Customer::toDto)
            .collect(Collectors.toUnmodifiableList());
  }
}
