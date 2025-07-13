package com.library.management.service;


import com.library.management.model.Customer;

import java.util.List;


public interface CustomerService {

    List<Customer> getAllCustomers();
    List<Customer> getAllCustomerByAccountStatus(Boolean accountStatus);
    Customer getCustomerById(Long customerId);
}
