package com.library.management.dto.input.validations;

import com.library.management.dto.input.CustomerBasicInputDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerBasicInputDTOValidationTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidDTO() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO(
                "Name", "email@test.com", "1234567890", "2000-01-01"
        );
        Set<ConstraintViolation<CustomerBasicInputDTO>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testNullName() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO(
                null, "email@test.com", "1234567890", "2000-01-01"
        );
        Set<ConstraintViolation<CustomerBasicInputDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testEmptyName() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO(
                "", "email@test.com", "1234567890", "2000-01-01"
        );
        Set<ConstraintViolation<CustomerBasicInputDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testInvalidEmail() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO(
                "Name", "invalid-email", "1234567890", "2000-01-01"
        );
        Set<ConstraintViolation<CustomerBasicInputDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullEmail() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO(
                "Name", null, "1234567890", "2000-01-01"
        );
        Set<ConstraintViolation<CustomerBasicInputDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testEmptyEmail() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO(
                "Name", "", "1234567890", "2000-01-01"
        );
        Set<ConstraintViolation<CustomerBasicInputDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testInvalidContactNumber() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO(
                "Name", "email@test.com", "12345", "2000-01-01"
        );
        Set<ConstraintViolation<CustomerBasicInputDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullContactNumber() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO(
                "Name", "email@test.com", null, "2000-01-01"
        );
        Set<ConstraintViolation<CustomerBasicInputDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullDateOfBirth() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO(
                "Name", "email@test.com", "1234567890", null
        );
        Set<ConstraintViolation<CustomerBasicInputDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
    }
}