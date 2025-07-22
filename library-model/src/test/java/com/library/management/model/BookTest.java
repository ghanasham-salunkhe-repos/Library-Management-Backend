package com.library.management.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testGettersAndSetters() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Title");
        book.setAuthor("Test Author");
        book.setTotalCopies(10);
        book.setAvailableCopies(5);

        assertEquals(1L, book.getId());
        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertEquals(10, book.getTotalCopies());
        assertEquals(5, book.getAvailableCopies());
        assertNotNull(book.getReviews());
    }

    @Test
    void testEqualsAndHashCode() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Title");
        book1.setAuthor("Author");
        book1.setTotalCopies(10);
        book1.setAvailableCopies(5);

        Book book2 = new Book();
        book2.setId(1L);
        book2.setTitle("Title");
        book2.setAuthor("Author");
        book2.setTotalCopies(10);
        book2.setAvailableCopies(5);

        assertEquals(book1, book2);
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    void testToString() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Title");
        assertTrue(book.toString().contains("Title"));
    }

    @Test
    void testAllArgsConstructor() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setTotalCopies(10);
        book.setAvailableCopies(5);
        assertEquals(1L, book.getId());
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals(10, book.getTotalCopies());
        assertEquals(5, book.getAvailableCopies());
    }
}