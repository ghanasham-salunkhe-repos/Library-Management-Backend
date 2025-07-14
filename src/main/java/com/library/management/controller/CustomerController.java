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
        List<CustomerInformationDTO> customers=customerService.getAllCustomers();

        if (customers.isEmpty()) {
            log.info("[GET][/api/customers/] No customers found");
            return  ResponseEntity.ok(new ArrayList<>());
        }

        log.info("[GET][/api/customers/] Total number of customers : {}",customers.size());
        // instead of sending data from the table, its ideal to share data in DTO format
        return ResponseEntity.ok(customers);
    }

    // get all active customers
    @GetMapping("/active")
    public ResponseEntity<List<CustomerInformationDTO>> getAllActiveCustomers() {

        log.info("[GET][/api/customers/active/] Fetching for active customers");
        List<CustomerInformationDTO> activeCustomers=customerService.getAllCustomerByAccountStatus(true);

        log.info("[GET][/api/customers/active] Number of active customers : {}",activeCustomers.size());
        // instead of sending data from the table, its ideal to share data in DTO format
        return ResponseEntity.ok(activeCustomers);
    }

    // get all inactive customers
    @GetMapping("/inactive")
    public ResponseEntity<List<CustomerInformationDTO>> getAllInactiveCustomers() {

        log.info("[GET][/api/customers/inactive/] Fetching for inactive customers");
        List<CustomerInformationDTO> activeCustomers=customerService.getAllCustomerByAccountStatus(false);

        log.info("[GET][/api/customers/inactive] Number of inactive customers : {}",activeCustomers.size());
        // instead of sending data from the table, its ideal to share data in DTO format
        return ResponseEntity.ok(activeCustomers);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerInformationDTO> getCustomerById(@PathVariable Long customerId) {

        log.info("[GET][/api/customers/{customerId}] searching for {}",customerId);
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

}
