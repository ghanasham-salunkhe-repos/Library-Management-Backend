package com.library.management.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(Long customerId) {
        this("Book with id: " + customerId + " not found");
        log.info("{} not found", customerId);
    }
}
