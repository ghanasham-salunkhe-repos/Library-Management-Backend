package com.library.management.dto.outputs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookInformationDTOTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        BookInformationDTO dto = new BookInformationDTO(1L, "Title", "Author", 5, 10, 4.5);
        assertEquals(1L, dto.getId());
        assertEquals("Title", dto.getTitle());
        assertEquals("Author", dto.getAuthor());
        assertEquals(5, dto.getAvailableCopies());
        assertEquals(10, dto.getTotalCopies());
        assertEquals(4.5, dto.getRating());
    }

    @Test
    void testEqualsAndHashCode() {
        BookInformationDTO dto1 = new BookInformationDTO(1L, "Title", "Author", 5, 10, 4.5);
        BookInformationDTO dto2 = new BookInformationDTO(1L, "Title", "Author", 5, 10, 4.5);
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testToString() {
        BookInformationDTO dto = new BookInformationDTO(1L, "Title", "Author", 5, 10, 4.5);
        assertTrue(dto.toString().contains("Title"));
    }

}