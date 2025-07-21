package com.library.management.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IssueBookIdNotFound extends RuntimeException {
    public IssueBookIdNotFound(String message) {
        super(message);
    }

    public IssueBookIdNotFound(Long customerId) {
        this("Book with id: " + customerId + " not found");
        log.info("{} not found", customerId);
    }
}
