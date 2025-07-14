package com.library.management.service.impl;

import com.library.management.dto.CustomerInformationDTO;
import com.library.management.exceptions.CustomerNotFoundException;
import com.library.management.mapper.LibraryManagementMapper;
import com.library.management.model.Customer;
import com.library.management.repositories.CustomerRepository;
import com.library.management.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    // configured repository inside implementation class
    // its always good to put the constructor than using the autowired
    final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    // get All Customers dta
    @Override
    public List<CustomerInformationDTO> getAllCustomers() {
        List<Customer> customers=customerRepository.findAll();
        if(customers.isEmpty()) {
            return  new ArrayList<>();
        }
        return customers.stream().map(LibraryManagementMapper::customerToCustomerInformationDTO).toList();
    }

    // get All Active customer details
    @Override
    public List<CustomerInformationDTO> getAllCustomerByAccountStatus(Boolean accountStatus) {
        List<Customer> activeCustomers=customerRepository.findAllByAcccountStatus(accountStatus);
        if (activeCustomers.isEmpty()) {
            return  new ArrayList<>();
        }
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
