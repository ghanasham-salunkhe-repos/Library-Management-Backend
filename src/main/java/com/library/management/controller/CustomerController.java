package com.library.management.controller;

import com.library.management.model.Customer;
import com.library.management.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Customer Management", description = "Customer activity related endpoints")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

//    endpoint to get all customers
    @GetMapping("/fetchAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
