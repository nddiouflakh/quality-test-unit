package sn.masterclass.servicecostumer.services;

import sn.masterclass.servicecostumer.dto.CustomerDTO;

import sn.masterclass.servicecostumer.exceptions.CustomerNotFoundException;
import sn.masterclass.servicecostumer.exceptions.EmailAlreadyExistException;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveNewCustomer(CustomerDTO customerDTO) throws EmailAlreadyExistException;
    List<CustomerDTO> getAllCustomers();
    CustomerDTO findCustomerById(Long id) throws CustomerNotFoundException;
    List<CustomerDTO> searchCustomerByName(String keyword);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) throws CustomerNotFoundException;
    void deleteCustomer(Long id) throws CustomerNotFoundException;
}
