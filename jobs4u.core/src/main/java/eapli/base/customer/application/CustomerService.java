package eapli.base.customer.application;


import eapli.framework.application.ApplicationService;


@ApplicationService
public class CustomerService {
  /*
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

   */

}
