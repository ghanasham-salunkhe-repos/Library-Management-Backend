package com.library.management.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IssuedBookTest {

    @Test
    void testGettersAndSetters() {
        IssuedBook issuedBook = new IssuedBook();
        Book book = new Book();
        Customer customer = new Customer();

        issuedBook.setId(1L);
        issuedBook.setBook(book);
        issuedBook.setCustomer(customer);
        issuedBook.setIssuedDate(LocalDate.of(2024, 6, 1));
        issuedBook.setDueDate(LocalDate.of(2024, 6, 10));
        issuedBook.setReturnDate(LocalDate.of(2024, 6, 9));
        issuedBook.setIsReturned(true);
        issuedBook.setFineAmount(5.0);

        assertEquals(1L, issuedBook.getId());
        assertEquals(book, issuedBook.getBook());
        assertEquals(customer, issuedBook.getCustomer());
        assertEquals(LocalDate.of(2024, 6, 1), issuedBook.getIssuedDate());
        assertEquals(LocalDate.of(2024, 6, 10), issuedBook.getDueDate());
        assertEquals(LocalDate.of(2024, 6, 9), issuedBook.getReturnDate());
        assertTrue(issuedBook.getIsReturned());
        assertEquals(5.0, issuedBook.getFineAmount());
    }

    @Test
    void testEqualsAndHashCode() {
        IssuedBook i1 = new IssuedBook();
        i1.setId(1L);

        IssuedBook i2 = new IssuedBook();
        i2.setId(1L);

        assertEquals(i1, i2);
        assertEquals(i1.hashCode(), i2.hashCode());
    }

    @Test
    void testToString() {
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setId(1L);
        assertTrue(issuedBook.toString().contains("1"));
    }

    @Test
    void testAllArgsConstructor() {
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setId(1L);
        issuedBook.setIssuedDate(LocalDate.of(2024, 6, 1));
        issuedBook.setDueDate(LocalDate.of(2024, 6, 10));
        issuedBook.setFineAmount(5.0);
        assertEquals(1L, issuedBook.getId());
        assertEquals(LocalDate.of(2024, 6, 1), issuedBook.getIssuedDate());
        assertEquals(LocalDate.of(2024, 6, 10), issuedBook.getDueDate());
        assertEquals(5.0, issuedBook.getFineAmount());
    }
}