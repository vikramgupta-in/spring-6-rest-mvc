package guru.springframework.spring6restmvc.service;

import guru.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
List<Customer> getCustomers();

Customer getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);
}
