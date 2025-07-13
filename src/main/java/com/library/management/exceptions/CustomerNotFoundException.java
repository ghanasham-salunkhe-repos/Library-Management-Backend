package com.library.management.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(Long customerId) {
        this("Customer with id: " + customerId + " not found");
        log.info("{} not found", customerId);
    }
}
