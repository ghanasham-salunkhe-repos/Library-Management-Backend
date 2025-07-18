package com.library.management.service.impl;

import com.library.management.dto.input.CustomerBasicInputDTO;
import com.library.management.dto.outputs.CustomerInformationDTO;
import com.library.management.exceptions.CustomerNotFoundException;
import com.library.management.mapper.LibraryManagementMapper;
import com.library.management.model.Customer;
import com.library.management.repositories.CustomerRepository;
import com.library.management.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    // configured repository inside implementation class
    // its always good to put the constructor than using the autowired
    final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // create entry for customer
    @Override
    public void createNewCustomerEntr(CustomerBasicInputDTO customerBasicInputDTO) {
        Customer customer = LibraryManagementMapper.customerFromCustomerBasicInputDTO(customerBasicInputDTO);
        customerRepository.save(customer);
    }

    // get All Customers dta
    @Override
    public List<CustomerInformationDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(LibraryManagementMapper::customerToCustomerInformationDTO).toList();
    }

    // get All Active customer details
    @Override
    public List<CustomerInformationDTO> getAllCustomerByAccountStatus(Boolean accountStatus) {
        List<Customer> activeCustomers = customerRepository.findAllByAcccountStatus(accountStatus);
        return activeCustomers.stream().map(LibraryManagementMapper::customerToCustomerInformationDTO).toList();
    }


    @Override
    public CustomerInformationDTO getCustomerById(Long customerId) {
        return LibraryManagementMapper.customerToCustomerInformationDTO(
                customerRepository.findById(customerId).orElseThrow(
                        () -> new CustomerNotFoundException(customerId)
                )
        );
    }
}
