package com.library.management.dto.outputs;

import com.library.management.model.Customer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentInformationDTOTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        Customer customer = new Customer();
        LocalDate date = LocalDate.of(2024, 6, 1);
        PaymentInformationDTO dto = new PaymentInformationDTO(customer, date, "PAY123", 100.0, true);
        assertEquals(customer, dto.getCustomer());
        assertEquals(date, dto.getPaymentDate());
        assertEquals("PAY123", dto.getPaymentId());
        assertEquals(100.0, dto.getAmount());
        assertTrue(dto.getIsSuccessful());
    }

    @Test
    void testEqualsAndHashCode() {
        Customer customer = new Customer();
        LocalDate date = LocalDate.of(2024, 6, 1);
        PaymentInformationDTO dto1 = new PaymentInformationDTO(customer, date, "PAY123", 100.0, true);
        PaymentInformationDTO dto2 = new PaymentInformationDTO(customer, date, "PAY123", 100.0, true);
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testToString() {
        Customer customer = new Customer();
        LocalDate date = LocalDate.of(2024, 6, 1);
        PaymentInformationDTO dto = new PaymentInformationDTO(customer, date, "PAY123", 100.0, true);
        assertTrue(dto.toString().contains("PAY123"));
    }
}