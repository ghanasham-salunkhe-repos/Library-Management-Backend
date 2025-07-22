package com.library.management.model.validations;

import com.library.management.model.IssuedBook;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssuedBookValidationTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidIssuedBook() {
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setIssuedDate(LocalDate.of(2024, 6, 1));
        issuedBook.setDueDate(LocalDate.of(2024, 6, 10));
        issuedBook.setFineAmount(0.0);
        Set<ConstraintViolation<IssuedBook>> violations = validator.validate(issuedBook);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testNullIssuedDate() {
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setIssuedDate(null);
        issuedBook.setDueDate(LocalDate.of(2024, 6, 10));
        issuedBook.setFineAmount(0.0);
        Set<ConstraintViolation<IssuedBook>> violations = validator.validate(issuedBook);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullDueDate() {
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setIssuedDate(LocalDate.of(2024, 6, 1));
        issuedBook.setDueDate(null);
        issuedBook.setFineAmount(0.0);
        Set<ConstraintViolation<IssuedBook>> violations = validator.validate(issuedBook);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNegativeFineAmount() {
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setIssuedDate(LocalDate.of(2024, 6, 1));
        issuedBook.setDueDate(LocalDate.of(2024, 6, 10));
        issuedBook.setFineAmount(-1.0);
        Set<ConstraintViolation<IssuedBook>> violations = validator.validate(issuedBook);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testFineAmountZero() {
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setIssuedDate(LocalDate.of(2024, 6, 1));
        issuedBook.setDueDate(LocalDate.of(2024, 6, 10));
        issuedBook.setFineAmount(0.0);
        Set<ConstraintViolation<IssuedBook>> violations = validator.validate(issuedBook);
        assertTrue(violations.isEmpty());
        assertEquals(0.0, issuedBook.getFineAmount());
    }

    @Test
    void testIsReturnedTrue() {
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setIssuedDate(LocalDate.of(2024, 6, 1));
        issuedBook.setDueDate(LocalDate.of(2024, 6, 10));
        issuedBook.setFineAmount(0.0);
        issuedBook.setIsReturned(true);
        Set<ConstraintViolation<IssuedBook>> violations = validator.validate(issuedBook);
        assertTrue(violations.isEmpty());
    }

}