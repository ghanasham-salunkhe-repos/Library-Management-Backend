package com.library.management.model.validations;

import com.library.management.model.Review;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ReviewValidationTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidReview() {
        Review review = new Review();
        review.setRating(5);
        Set<ConstraintViolation<Review>> violations = validator.validate(review);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testNullRating() {
        Review review = new Review();
        review.setRating(null);
        Set<ConstraintViolation<Review>> violations = validator.validate(review);
        assertFalse(violations.isEmpty());
    }

    @Test
    void testMinimumRating() {
        Review review = new Review();
        review.setRating(1);
        Set<ConstraintViolation<Review>> violations = validator.validate(review);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testMaximumRating() {
        Review review = new Review();
        review.setRating(5);
        Set<ConstraintViolation<Review>> violations = validator.validate(review);
        assertTrue(violations.isEmpty());
        assertEquals(5, review.getRating());
    }

}