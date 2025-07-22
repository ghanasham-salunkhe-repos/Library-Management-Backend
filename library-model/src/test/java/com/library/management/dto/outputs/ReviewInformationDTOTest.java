package com.library.management.dto.outputs;

import com.library.management.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReviewInformationDTOTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        Customer customer = new Customer();
        ReviewInformationDTO dto = new ReviewInformationDTO("Book", "Author", customer, "Nice book", 5);
        assertEquals("Book", dto.getBookName());
        assertEquals("Author", dto.getBookAuthor());
        assertEquals(customer, dto.getCustomer());
        assertEquals("Nice book", dto.getComment());
        assertEquals(5, dto.getRating());
    }

    @Test
    void testEqualsAndHashCode() {
        Customer customer = new Customer();
        ReviewInformationDTO dto1 = new ReviewInformationDTO("Book", "Author", customer, "Nice book", 5);
        ReviewInformationDTO dto2 = new ReviewInformationDTO("Book", "Author", customer, "Nice book", 5);
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testToString() {
        Customer customer = new Customer();
        ReviewInformationDTO dto = new ReviewInformationDTO("Book", "Author", customer, "Nice book", 5);
        assertTrue(dto.toString().contains("Book"));
    }
}