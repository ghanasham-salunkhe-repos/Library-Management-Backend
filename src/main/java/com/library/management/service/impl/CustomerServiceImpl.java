package com.library.management.service.impl;

import com.library.management.exceptions.CustomerNotFoundException;
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


    // get All Customers dta
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // get All Active customer details
    @Override
    public List<Customer> getAllCustomerByAccountStatus(Boolean accountStatus) {
        return customerRepository.findAllByAcccountStatus(accountStatus);
    }


    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(
                () -> new CustomerNotFoundException(customerId)
        );
    }
}
