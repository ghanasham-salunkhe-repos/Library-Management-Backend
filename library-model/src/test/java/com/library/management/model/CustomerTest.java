package com.library.management.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    @Test
    void testGettersAndSetters() {
        Customer customer = new Customer();
        customer.setId(10001L);
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setContactNumber("1234567890");
        customer.setBirthDate(LocalDate.of(1990, 1, 1));
        customer.setMembershipDate(LocalDate.of(2024, 1, 1));
        customer.setIsFeePaid(true);
        customer.setAcccountStatus(true);

        assertEquals(10001L, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("john@example.com", customer.getEmail());
        assertEquals("1234567890", customer.getContactNumber());
        assertEquals(LocalDate.of(1990, 1, 1), customer.getBirthDate());
        assertEquals(LocalDate.of(2024, 1, 1), customer.getMembershipDate());
        assertTrue(customer.getIsFeePaid());
        assertTrue(customer.getAcccountStatus());
    }

    @Test
    void testEqualsAndHashCode() {
        Customer c1 = new Customer();
        c1.setId(1L);
        c1.setName("A");
        c1.setEmail("a@b.com");
        c1.setContactNumber("1234567890");
        c1.setBirthDate(LocalDate.of(2000, 1, 1));

        Customer c2 = new Customer();
        c2.setId(1L);
        c2.setName("A");
        c2.setEmail("a@b.com");
        c2.setContactNumber("1234567890");
        c2.setBirthDate(LocalDate.of(2000, 1, 1));

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testToString() {
        Customer customer = new Customer();
        customer.setName("Test");
        assertTrue(customer.toString().contains("Test"));
    }

    @Test
    void testAllArgsConstructor() {
        Customer customer = new Customer();
        customer.setId(10001L);
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setContactNumber("1234567890");
        customer.setBirthDate(LocalDate.of(1990, 1, 1));
        assertEquals(10001L, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("john@example.com", customer.getEmail());
        assertEquals("1234567890", customer.getContactNumber());
        assertEquals(LocalDate.of(1990, 1, 1), customer.getBirthDate());
    }
}