package sn.masterclass.servicecostumer.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.masterclass.servicecostumer.dto.CustomerDTO;
import sn.masterclass.servicecostumer.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;

    }
    @GetMapping("/customers")
    public List<CustomerDTO> getAllCustomer() {
        return customerService.getAllCustomers();

    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }


    @GetMapping("/customers/search")
    public List<CustomerDTO> searchCustomerByName(String keyword) {
        return customerService.searchCustomerByName(keyword);
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveNewCustomer(customerDTO);
    }

    @PutMapping("/customers/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/customers{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
