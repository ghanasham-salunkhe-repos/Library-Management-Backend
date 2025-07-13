package com.library.management.controller;

import com.library.management.dto.CustomerInformationDTO;
import com.library.management.mapper.LibraryManagementMapper;
import com.library.management.model.Customer;
import com.library.management.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Tag(name = "Customer Management", description = "Customer activity related endpoints")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    // instead autowiring passing service with constructor
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    // try to use nouns in api path
//    endpoint to get all customers
    @GetMapping("")
    public ResponseEntity<List<CustomerInformationDTO>> getAllCustomers() {
        log.info("[GET][/api/customers/] Fetching all customers");
        List<Customer> customers=customerService.getAllCustomers();
        if (customers.isEmpty()) {
            log.info("[GET][/api/customers/] No customers found");
            return  ResponseEntity.ok(new ArrayList<>());
        }

        log.info("[GET][/api/customers/] Total number of customers : {}",customers.size());
        // instead of sending data from the table, its ideal to share data in DTO format
        return ResponseEntity.ok(
                customers.stream().map(LibraryManagementMapper::customerToCustomerInformationDTO).toList()
        );
    }

    // get all active customers
    @GetMapping("/active")
    public ResponseEntity<List<CustomerInformationDTO>> getAllActiveCustomers() {
        log.info("[GET][/api/customers/active/] Fetching for active customers");
        List<Customer> activeCustomers=customerService.getAllCustomerByAccountStatus(true);
        if (activeCustomers.isEmpty()) {
            log.info("[GET][/api/customers/active] No active customers found");
            return  ResponseEntity.ok(new ArrayList<>());
        }

        log.info("[GET][/api/customers/active] Number of active customers : {}",activeCustomers.size());
        // instead of sending data from the table, its ideal to share data in DTO format
        return ResponseEntity.ok(
                activeCustomers.stream().map(LibraryManagementMapper::customerToCustomerInformationDTO).toList()
        );
    }

    // get all inactive customers
    @GetMapping("/inactive")
    public ResponseEntity<List<CustomerInformationDTO>> getAllInactiveCustomers() {
        log.info("[GET][/api/customers/inactive/] Fetching for inactive customers");
        List<Customer> inactiveCustomers=customerService.getAllCustomerByAccountStatus(false);
        if (inactiveCustomers.isEmpty()) {
            log.info("[GET][/api/customers/inactive/] No inactive customers found");
            return ResponseEntity.ok(new ArrayList<>());
        }

        log.info("[GET][/api/customers/active/] Number of inactive customers : {}",inactiveCustomers.size());
        // instead of sending data from the table, its ideal to share data in DTO format
        return ResponseEntity.ok(
                inactiveCustomers.stream().map(LibraryManagementMapper::customerToCustomerInformationDTO).toList()
        );
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        log.info("[GET][/api/customers/{customerId}] searching for {}",customerId);
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

}
