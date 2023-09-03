package guru.springframework.spring6restmvc.service;

import guru.springframework.spring6restmvc.model.Customer;

import java.util.List;

public interface CustomerService {
List<Customer> getCustomers();

Customer getCustomerById(int id);
}
