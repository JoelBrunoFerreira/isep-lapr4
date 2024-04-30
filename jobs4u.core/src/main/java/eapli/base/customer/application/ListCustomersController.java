package eapli.base.customer.application;

import eapli.base.customer.dto.CustomerDTO;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class ListCustomersController {
    private final CustomerService customerService = new CustomerService();
    public Iterable<CustomerDTO> allCustomers() {
        return customerService.findAllDTO();
    }
}
