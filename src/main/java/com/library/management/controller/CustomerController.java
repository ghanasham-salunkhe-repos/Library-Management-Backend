package com.library.management.controller;

import com.library.management.dto.CustomerInformationDTO;
import com.library.management.mapper.LibraryManagementMapper;
import com.library.management.model.Customer;
import com.library.management.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Customer Management", description = "Customer activity related endpoints")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    // instead autowiring passing service with constructor
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }


//    endpoint to get all customers
    @GetMapping("/fetchAll")
    public List<CustomerInformationDTO> getAllCustomers() {
        List<Customer> customers=customerService.getAllCustomers();

        if (customers.isEmpty()) {
            return  new ArrayList<>();
        }

        // instead of sending data from the table, its ideal to share data in DTO format
        return customers.stream().map(LibraryManagementMapper::customerToCustomerInformationDTO).toList();
    }



}
