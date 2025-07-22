package com.library.management.dto.outputs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerInformationDTOTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        CustomerInformationDTO dto = new CustomerInformationDTO(1L, "Name", "2000-01-01", "email@test.com", "1234567890");
        assertEquals(1L, dto.getId());
        assertEquals("Name", dto.getName());
        assertEquals("2000-01-01", dto.getBirthdayDate());
        assertEquals("email@test.com", dto.getEmail());
        assertEquals("1234567890", dto.getContactNumber());
    }

    @Test
    void testEqualsAndHashCode() {
        CustomerInformationDTO dto1 = new CustomerInformationDTO(1L, "Name", "2000-01-01", "email@test.com", "1234567890");
        CustomerInformationDTO dto2 = new CustomerInformationDTO(1L, "Name", "2000-01-01", "email@test.com", "1234567890");
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testToString() {
        CustomerInformationDTO dto = new CustomerInformationDTO(1L, "Name", "2000-01-01", "email@test.com", "1234567890");
        assertTrue(dto.toString().contains("Name"));
    }

}