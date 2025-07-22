package com.library.management.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReviewTest {

    @Test
    void testGettersAndSetters() {
        Review review = new Review();
        Book book = new Book();
        Customer customer = new Customer();

        review.setId(1L);
        review.setBook(book);
        review.setCustomer(customer);
        review.setComment("Great book!");
        review.setRating(5);

        assertEquals(1L, review.getId());
        assertEquals(book, review.getBook());
        assertEquals(customer, review.getCustomer());
        assertEquals("Great book!", review.getComment());
        assertEquals(5, review.getRating());
    }

    @Test
    void testEqualsAndHashCode() {
        Review r1 = new Review();
        r1.setId(1L);

        Review r2 = new Review();
        r2.setId(1L);

        assertEquals(r1, r2);
        assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    void testToString() {
        Review review = new Review();
        review.setComment("Nice");
        assertTrue(review.toString().contains("Nice"));
    }

    @Test
    void testAllArgsConstructor() {
        Review review = new Review();
        review.setId(1L);
        review.setRating(5);
        assertEquals(1L, review.getId());
        assertEquals(5, review.getRating());
    }
}