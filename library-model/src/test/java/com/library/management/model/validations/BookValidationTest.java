package com.library.management.model.validations;

import com.library.management.model.Book;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookValidationTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidBook() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setTotalCopies(10);
        book.setAvailableCopies(5);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testNullTitle() {
        Book book = new Book();
        book.setTitle(null);
        book.setAuthor("Author");
        book.setTotalCopies(10);
        book.setAvailableCopies(5);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testEmptyTitle() {
        Book book = new Book();
        book.setTitle("");
        book.setAuthor("Author");
        book.setTotalCopies(10);
        book.setAvailableCopies(5);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullAuthor() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor(null);
        book.setTotalCopies(10);
        book.setAvailableCopies(5);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testEmptyAuthor() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("");
        book.setTotalCopies(10);
        book.setAvailableCopies(5);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullTotalCopies() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setTotalCopies(null);
        book.setAvailableCopies(5);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNullAvailableCopies() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setTotalCopies(10);
        book.setAvailableCopies(null);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testNegativeTotalCopies() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setTotalCopies(-1);
        book.setAvailableCopies(5);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testAvailableCopiesExceedTotalCopies() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setTotalCopies(5);
        book.setAvailableCopies(10);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertTrue(violations.isEmpty());
    }
}