package eapli.base.customer.application;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.dto.CustomerDTO;
import eapli.base.customer.repository.CustomerRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetCustomerListController {
    AuthorizationService authz;
    CustomerRepository customerRepo;
    public Iterable<CustomerDTO> getCustomerList() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN, BaseRoles.CUSTOMER_MANAGER);
        Iterable<Customer> customers = customerRepo.findAll();
        List<CustomerDTO> customersDTO = new ArrayList<>();
        for (Customer customer : customers) {
            customersDTO.add(customer.toDTO());
        }
        return customersDTO;
    }


    public Optional<Customer> getCustomer(Long id){
        return customerRepo.ofIdentity(id);
    }

}
