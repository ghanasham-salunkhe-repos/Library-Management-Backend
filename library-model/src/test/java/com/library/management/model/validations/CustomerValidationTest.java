package com.library.management.model.validations;

import com.library.management.model.Customer;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerValidationTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidCustomer() {
        Customer customer = new Customer();
        customer.setName("Name");
        customer.setEmail("email@test.com");
        customer.setContactNumber("1234567890");
        customer.setBirthDate(LocalDate.of(2000, 1, 1));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testNullName() {
        Customer customer = new Customer();
        customer.setName(null);
        customer.setEmail("email@test.com");
        customer.setContactNumber("1234567890");
        customer.setBirthDate(LocalDate.of(2000, 1, 1));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testEmptyName() {
        Customer customer = new Customer();
        customer.setName("");
        customer.setEmail("email@test.com");
        customer.setContactNumber("1234567890");
        customer.setBirthDate(LocalDate.of(2000, 1, 1));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testInvalidEmail() {
        Customer customer = new Customer();
        customer.setName("Name");
        customer.setEmail("invalid-email");
        customer.setContactNumber("1234567890");
        customer.setBirthDate(LocalDate.of(2000, 1, 1));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullEmail() {
        Customer customer = new Customer();
        customer.setName("Name");
        customer.setEmail(null);
        customer.setContactNumber("1234567890");
        customer.setBirthDate(LocalDate.of(2000, 1, 1));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testEmptyEmail() {
        Customer customer = new Customer();
        customer.setName("Name");
        customer.setEmail("");
        customer.setContactNumber("1234567890");
        customer.setBirthDate(LocalDate.of(2000, 1, 1));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testInvalidContactNumber() {
        Customer customer = new Customer();
        customer.setName("Name");
        customer.setEmail("email@test.com");
        customer.setContactNumber("12345");
        customer.setBirthDate(LocalDate.of(2000, 1, 1));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullContactNumber() {
        Customer customer = new Customer();
        customer.setName("Name");
        customer.setEmail("email@test.com");
        customer.setContactNumber(null);
        customer.setBirthDate(LocalDate.of(2000, 1, 1));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullBirthDate() {
        Customer customer = new Customer();
        customer.setName("Name");
        customer.setEmail("email@test.com");
        customer.setContactNumber("1234567890");
        customer.setBirthDate(null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testLongName() {
        Customer customer = new Customer();
        customer.setName("A".repeat(256));
        customer.setEmail("email@test.com");
        customer.setContactNumber("1234567890");
        customer.setBirthDate(LocalDate.of(2000, 1, 1));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testContactNumberWithLetters() {
        Customer customer = new Customer();
        customer.setName("Name");
        customer.setEmail("email@test.com");
        customer.setContactNumber("12345abcde");
        customer.setBirthDate(LocalDate.of(2000, 1, 1));
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        assertFalse(violations.isEmpty());
    }
}
