package com.library.management.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentTest {

    @Test
    void testGettersAndSetters() {
        Payment payment = new Payment();
        Customer customer = new Customer();

        payment.setId(1L);
        payment.setCustomer(customer);
        payment.setPaymentDate(LocalDate.of(2024, 6, 1));
        payment.setPaymentId("PAY123");
        payment.setAmount(100.0);
        payment.setIsSuccessful(true);

        assertEquals(1L, payment.getId());
        assertEquals(customer, payment.getCustomer());
        assertEquals(LocalDate.of(2024, 6, 1), payment.getPaymentDate());
        assertEquals("PAY123", payment.getPaymentId());
        assertEquals(100.0, payment.getAmount());
        assertTrue(payment.getIsSuccessful());
    }

    @Test
    void testEqualsAndHashCode() {
        Payment p1 = new Payment();
        p1.setId(1L);

        Payment p2 = new Payment();
        p2.setId(1L);

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testToString() {
        Payment payment = new Payment();
        payment.setPaymentId("PAY123");
        assertTrue(payment.toString().contains("PAY123"));
    }

    @Test
    void testAllArgsConstructor() {
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setPaymentDate(LocalDate.of(2024, 6, 1));
        payment.setPaymentId("PAY123");
        payment.setAmount(100.0);
        payment.setIsSuccessful(true);
        assertEquals(1L, payment.getId());
        assertEquals(LocalDate.of(2024, 6, 1), payment.getPaymentDate());
        assertEquals("PAY123", payment.getPaymentId());
        assertEquals(100.0, payment.getAmount());
        assertTrue(payment.getIsSuccessful());
    }
}