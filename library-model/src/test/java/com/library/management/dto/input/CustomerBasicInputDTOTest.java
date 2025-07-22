package com.library.management.dto.input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerBasicInputDTOTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO(
                "Name", "email@test.com", "1234567890", "2000-01-01"
        );
        assertEquals("Name", dto.getCustomerName());
        assertEquals("email@test.com", dto.getCustomerEmail());
        assertEquals("1234567890", dto.getCustomerContactNumber());
        assertEquals("2000-01-01", dto.getDateOfBirth());
    }

    @Test
    void testEqualsAndHashCode() {
        CustomerBasicInputDTO dto1 = new CustomerBasicInputDTO("Name", "email@test.com", "1234567890", "2000-01-01");
        CustomerBasicInputDTO dto2 = new CustomerBasicInputDTO("Name", "email@test.com", "1234567890", "2000-01-01");
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testToString() {
        CustomerBasicInputDTO dto = new CustomerBasicInputDTO("Name", "email@test.com", "1234567890", "2000-01-01");
        assertTrue(dto.toString().contains("Name"));
    }
}