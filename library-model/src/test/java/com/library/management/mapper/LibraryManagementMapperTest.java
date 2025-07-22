// Java
package com.library.management.mapper;

import com.library.management.dto.input.CustomerBasicInputDTO;
import com.library.management.dto.outputs.*;
import com.library.management.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagementMapperTest {

    @Test
    void testCustomerToCustomerInformationDTO() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setBirthDate(LocalDate.of(1990, 1, 1));
        customer.setEmail("john@example.com");
        customer.setContactNumber("1234567890");

        CustomerInformationDTO dto = LibraryManagementMapper.customerToCustomerInformationDTO(customer);
        assertEquals(1L, dto.getId());
        assertEquals("John Doe", dto.getName());
        assertEquals("1990-01-01", dto.getBirthdayDate());
        assertEquals("john@example.com", dto.getEmail());
        assertEquals("1234567890", dto.getContactNumber());
    }

    @Test
    void testCustomerFromCustomerBasicInputDTO() {
        CustomerBasicInputDTO inputDTO = new CustomerBasicInputDTO(
                "Jane Doe", "jane@example.com", "0987654321", "1985-05-20"
        );
        Customer customer = LibraryManagementMapper.customerFromCustomerBasicInputDTO(inputDTO);
        assertEquals("Jane Doe", customer.getName());
        assertEquals("jane@example.com", customer.getEmail());
        assertEquals("0987654321", customer.getContactNumber());
        assertEquals(LocalDate.of(1985, 5, 20), customer.getBirthDate());
        assertTrue(customer.getAcccountStatus());
    }

    @Test
    void testBookToBookInformationDTOWithReviews() {
        Book book = new Book();
        book.setId(2L);
        book.setTitle("Book Title");
        book.setAuthor("Author Name");
        book.setAvailableCopies(3);
        book.setTotalCopies(5);

        Review review1 = new Review();
        review1.setRating(4);
        Review review2 = new Review();
        review2.setRating(5);
        book.setReviews(Arrays.asList(review1, review2));

        BookInformationDTO dto = LibraryManagementMapper.bookToBookInformationDTO(book);
        assertEquals(2L, dto.getId());
        assertEquals("Book Title", dto.getTitle());
        assertEquals("Author Name", dto.getAuthor());
        assertEquals(3, dto.getAvailableCopies());
        assertEquals(5, dto.getTotalCopies());
        assertEquals(4.5, dto.getRating());
    }

    @Test
    void testBookToBookInformationDTOWithNoReviews() {
        Book book = new Book();
        book.setId(3L);
        book.setTitle("Empty Book");
        book.setAuthor("No Author");
        book.setAvailableCopies(1);
        book.setTotalCopies(2);
        book.setReviews(Arrays.asList());

        BookInformationDTO dto = LibraryManagementMapper.bookToBookInformationDTO(book);
        assertEquals(0.0, dto.getRating());
    }

    @Test
    void testIssuedBookToIssuedBookInformationDTOWithAllFields() {
        Book book = new Book();
        book.setId(4L);
        book.setTitle("Issued Book");
        book.setAuthor("Author");
        book.setAvailableCopies(2);
        book.setTotalCopies(4);

        Customer customer = new Customer();
        customer.setId(5L);
        customer.setName("Customer Name");
        customer.setBirthDate(LocalDate.of(2000, 2, 2));
        customer.setEmail("cust@example.com");
        customer.setContactNumber("1112223333");

        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setId(10L);
        issuedBook.setBook(book);
        issuedBook.setCustomer(customer);
        issuedBook.setIssuedDate(LocalDate.of(2024, 6, 1));
        issuedBook.setDueDate(LocalDate.of(2024, 6, 10));
        issuedBook.setReturnDate(LocalDate.of(2024, 6, 9));
        issuedBook.setIsReturned(true);
        issuedBook.setFineAmount(5.0);

        IssuedBookInformationDTO dto = LibraryManagementMapper.issuedBookToissuedBookInformationDTO(issuedBook);
        assertEquals(10L, dto.getBookIssueReferenceId());
        assertEquals("Issued Book", dto.getBookDetails().getTitle());
        assertEquals("Customer Name", dto.getCustomerDetails().getName());
        assertEquals("2024-06-01", dto.getBookIssuedDate());
        assertEquals("2024-06-10", dto.getBookReturnDueDate());
        assertEquals("2024-06-09", dto.getBookReturnDate());
        assertTrue(dto.getIsBookReturned());
        assertEquals(5.0, dto.getFineAmount());
    }

    // Java
    @Test
    void testIssuedBookToIssuedBookInformationDTONullDates() {
        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setId(11L);
        issuedBook.setBook(new Book());

        Customer customer = new Customer();
        customer.setBirthDate(LocalDate.of(2000, 1, 1)); // Set a valid birthDate
        issuedBook.setCustomer(customer);

        issuedBook.setIssuedDate(null);
        issuedBook.setDueDate(null);
        issuedBook.setReturnDate(null);
        issuedBook.setIsReturned(false);
        issuedBook.setFineAmount(0.0);

        IssuedBookInformationDTO dto = LibraryManagementMapper.issuedBookToissuedBookInformationDTO(issuedBook);
        assertNull(dto.getBookIssuedDate());
        assertNull(dto.getBookReturnDueDate());
        assertNull(dto.getBookReturnDate());
    }

    @Test
    void testReviewToReviewInformationDTO() {
        Book book = new Book();
        book.setTitle("Review Book");
        book.setAuthor("Review Author");

        Customer customer = new Customer();
        customer.setName("Reviewer");

        Review review = new Review();
        review.setBook(book);
        review.setCustomer(customer);
        review.setComment("Nice!");
        review.setRating(5);

        ReviewInformationDTO dto = LibraryManagementMapper.reviewToReviewInformationDTO(review);
        assertEquals("Review Book", dto.getBookName());
        assertEquals("Review Author", dto.getBookAuthor());
        assertEquals(customer, dto.getCustomer());
        assertEquals("Nice!", dto.getComment());
        assertEquals(5, dto.getRating());
    }

    @Test
    void testPaymentToPaymentInformationDTO() {
        Customer customer = new Customer();
        LocalDate date = LocalDate.of(2024, 6, 1);
        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setPaymentDate(date);
        payment.setPaymentId("PAY123");
        payment.setAmount(100.0);
        payment.setIsSuccessful(true);

        PaymentInformationDTO dto = LibraryManagementMapper.paymentToPaymentInformationDTO(payment);
        assertEquals(customer, dto.getCustomer());
        assertEquals(date, dto.getPaymentDate());
        assertEquals("PAY123", dto.getPaymentId());
        assertEquals(100.0, dto.getAmount());
        assertTrue(dto.getIsSuccessful());
    }

    // null pointer testing
    @Test
    void testCustomerToCustomerInformationDTONullInput() {
        assertNull(LibraryManagementMapper.customerToCustomerInformationDTO(null));
    }

    @Test
    void testCustomerFromCustomerBasicInputDTONullInput() {
        assertNull(LibraryManagementMapper.customerFromCustomerBasicInputDTO(null));
    }

    @Test
    void testBookToBookInformationDTONullInput() {
        assertNull(LibraryManagementMapper.bookToBookInformationDTO(null));
    }

    @Test
    void testIssuedBookToIssuedBookInformationDTONullInput() {
        assertNull(LibraryManagementMapper.issuedBookToissuedBookInformationDTO(null));
    }

    @Test
    void testReviewToReviewInformationDTONullInput() {
        assertNull(LibraryManagementMapper.reviewToReviewInformationDTO(null));
    }

    @Test
    void testPaymentToPaymentInformationDTONullInput() {
        assertNull(LibraryManagementMapper.paymentToPaymentInformationDTO(null));
    }
}