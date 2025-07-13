package com.library.management.service.impl;

import com.library.management.model.Customer;
import com.library.management.repositories.CustomerRepository;
import com.library.management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    // configured repository inside implementation class
    @Autowired
    CustomerRepository customerRepository;


    // get All Customers dta
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
