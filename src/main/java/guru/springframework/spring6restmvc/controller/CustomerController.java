package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;


    @PutMapping("{custId}")
    public ResponseEntity updateById(@PathVariable UUID custId, @RequestBody Customer customer){

        customerService.updateCustomerById(custId,customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer){
        HttpHeaders headers = new HttpHeaders();
        Customer savedCustomer = customerService.saveNewCustomer(customer);
        headers.add("Location","/api/v1/customer/"+savedCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET)
  public List<Customer> getCustomers(){
      return customerService.getCustomers();
  }

  @RequestMapping(value= "/{custId}",method = RequestMethod.GET)
  public Customer getCustomerById(@PathVariable("custId") UUID id){
        return customerService.getCustomerById(id);
  }
}
