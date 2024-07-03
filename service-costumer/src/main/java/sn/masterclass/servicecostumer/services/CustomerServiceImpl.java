package sn.masterclass.servicecostumer.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.masterclass.servicecostumer.dto.CustomerDTO;
import sn.masterclass.servicecostumer.entities.Customer;
import sn.masterclass.servicecostumer.exceptions.CustomerNotFoundException;
import sn.masterclass.servicecostumer.exceptions.EmailAlreadyExistException;
import sn.masterclass.servicecostumer.mapper.CustomerMapper;
import sn.masterclass.servicecostumer.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) throws EmailAlreadyExistException {
        log.info(String.format("Saving new customer %s", customerDTO.toString()));
        List<Customer> byEmail = customerRepository.findByEmail(customerDTO.getEmail());
        if (!byEmail.isEmpty()) {
            log.error(String.format("Customer with email %s already exist", customerDTO.getEmail()));
            throw new EmailAlreadyExistException();
        }
        Customer customerToSave = customerMapper.fromCustomerDTO(customerDTO);
        Customer savedCustomer = customerRepository.save(customerToSave);
        CustomerDTO result = customerMapper.fromCustomer(savedCustomer);
        log.info(String.format("Saved new customer %s", result.toString()));
        return result;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return customerMapper.fromListCustomers(allCustomers);
    }

    @Override
    public CustomerDTO findCustomerById(Long id) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) throw new CustomerNotFoundException();
        return customerMapper.fromCustomer(customer.get());
    }

    @Override
    public List<CustomerDTO> searchCustomerByName(String keyword) {
        List<Customer> customers = customerRepository.findByFirstnameContainingIgnoreCase(keyword);
        return customerMapper.fromListCustomers(customers);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) throw new CustomerNotFoundException();
        customerDTO.setId(id);
        Customer customerToUpdate = customerMapper.fromCustomerDTO(customerDTO);
        Customer updatedCustomer = customerRepository.save(customerToUpdate);
        return customerMapper.fromCustomer(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) throws CustomerNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) throw new CustomerNotFoundException();
        customerRepository.deleteById(id);
    }
}
