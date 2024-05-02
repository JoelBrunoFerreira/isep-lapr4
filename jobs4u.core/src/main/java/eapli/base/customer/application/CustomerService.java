package eapli.base.customer.application;


import eapli.base.customer.domain.Customer;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ApplicationService
public class CustomerService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CustomerRepository repo = PersistenceContext.repositories().customers();

    public CustomerService() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
    }

    public Optional<Customer> findCustomerByUsername(String user) {
        return repo.findByUsername(Username.valueOf(user));
    }

    public Iterable<CustomerDTO> findAllDTO() {
        final Iterable<Customer> customers = repo.findAll();
        return convertToDTO(customers);

    }

    private Iterable<CustomerDTO> convertToDTO(Iterable<Customer> customers) {
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOs.add(customer.toDTO());
        }
        return customerDTOs;
    }

}
