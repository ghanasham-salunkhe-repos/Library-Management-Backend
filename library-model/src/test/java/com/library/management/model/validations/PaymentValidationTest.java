package com.library.management.model.validations;

import com.library.management.model.Payment;
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

class PaymentValidationTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidPayment() {
        Payment payment = new Payment();
        payment.setPaymentDate(LocalDate.of(2024, 6, 1));
        payment.setPaymentId("PAY123");
        payment.setAmount(100.0);
        payment.setIsSuccessful(true);
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testNullPaymentDate() {
        Payment payment = new Payment();
        payment.setPaymentDate(null);
        payment.setPaymentId("PAY123");
        payment.setAmount(100.0);
        payment.setIsSuccessful(true);
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullPaymentId() {
        Payment payment = new Payment();
        payment.setPaymentDate(LocalDate.of(2024, 6, 1));
        payment.setPaymentId(null);
        payment.setAmount(100.0);
        payment.setIsSuccessful(true);
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullAmount() {
        Payment payment = new Payment();
        payment.setPaymentDate(LocalDate.of(2024, 6, 1));
        payment.setPaymentId("PAY123");
        payment.setAmount(null);
        payment.setIsSuccessful(true);
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullIsSuccessful() {
        Payment payment = new Payment();
        payment.setPaymentDate(LocalDate.of(2024, 6, 1));
        payment.setPaymentId("PAY123");
        payment.setAmount(100.0);
        payment.setIsSuccessful(null);
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testZeroAmount() {
        Payment payment = new Payment();
        payment.setPaymentDate(LocalDate.of(2024, 6, 1));
        payment.setPaymentId("PAY123");
        payment.setAmount(0.0);
        payment.setIsSuccessful(true);
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testIsSuccessfulFalse() {
        Payment payment = new Payment();
        payment.setPaymentDate(LocalDate.of(2024, 6, 1));
        payment.setPaymentId("PAY123");
        payment.setAmount(100.0);
        payment.setIsSuccessful(false);
        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);
        assertTrue(violations.isEmpty());
    }


}
