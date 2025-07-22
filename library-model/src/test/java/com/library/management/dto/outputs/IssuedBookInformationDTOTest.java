package com.library.management.dto.outputs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IssuedBookInformationDTOTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        BookInformationDTO book = new BookInformationDTO(1L, "Title", "Author", 5, 10, 4.5);
        CustomerInformationDTO customer = new CustomerInformationDTO(2L, "Name", "2000-01-01", "email@test.com", "1234567890");
        IssuedBookInformationDTO dto = new IssuedBookInformationDTO(
                100L, book, customer, "2024-06-01", "2024-06-10", "2024-06-09", true, 5.0
        );
        assertEquals(100L, dto.getBookIssueReferenceId());
        assertEquals(book, dto.getBookDetails());
        assertEquals(customer, dto.getCustomerDetails());
        assertEquals("2024-06-01", dto.getBookIssuedDate());
        assertEquals("2024-06-10", dto.getBookReturnDueDate());
        assertEquals("2024-06-09", dto.getBookReturnDate());
        assertTrue(dto.getIsBookReturned());
        assertEquals(5.0, dto.getFineAmount());
    }

    @Test
    void testEqualsAndHashCode() {
        BookInformationDTO book = new BookInformationDTO(1L, "Title", "Author", 5, 10, 4.5);
        CustomerInformationDTO customer = new CustomerInformationDTO(2L, "Name", "2000-01-01", "email@test.com", "1234567890");
        IssuedBookInformationDTO dto1 = new IssuedBookInformationDTO(100L, book, customer, "2024-06-01", "2024-06-10", "2024-06-09", true, 5.0);
        IssuedBookInformationDTO dto2 = new IssuedBookInformationDTO(100L, book, customer, "2024-06-01", "2024-06-10", "2024-06-09", true, 5.0);
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testToString() {
        BookInformationDTO book = new BookInformationDTO(1L, "Title", "Author", 5, 10, 4.5);
        CustomerInformationDTO customer = new CustomerInformationDTO(2L, "Name", "2000-01-01", "email@test.com", "1234567890");
        IssuedBookInformationDTO dto = new IssuedBookInformationDTO(100L, book, customer, "2024-06-01", "2024-06-10", "2024-06-09", true, 5.0);
        assertTrue(dto.toString().contains("100"));
    }
}