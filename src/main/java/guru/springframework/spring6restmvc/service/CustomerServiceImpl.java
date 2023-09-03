package guru.springframework.spring6restmvc.service;

import guru.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer,Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer cust1 = Customer.builder()
                .customerName("First Customer")
                .Id(1)
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer cust2 = Customer.builder()
                .customerName("Second Customer")
                .Id(2)
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer cust3 = Customer.builder()
                .customerName("Third Customer")
                .Id(3)
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(cust1.getId(),cust1);
        customerMap.put(cust2.getId(),cust2);
        customerMap.put(cust3.getId(),cust3);
    }

    @Override
    public List<Customer> getCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerMap.get(id);
    }
}
