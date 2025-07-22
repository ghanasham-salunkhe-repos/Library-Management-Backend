package com.library.management.mapper;

import com.library.management.dto.input.CustomerBasicInputDTO;
import com.library.management.dto.outputs.*;
import com.library.management.model.*;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.stream.Collectors;

@UtilityClass
public class LibraryManagementMapper {

    public static CustomerInformationDTO customerToCustomerInformationDTO(Customer customer) {
        if (customer == null) return null;
        return new CustomerInformationDTO(
                customer.getId(),
                customer.getName(),
                customer.getBirthDate() != null ? customer.getBirthDate().toString() : null,
                customer.getEmail(),
                customer.getContactNumber()
        );
    }

    public static Customer customerFromCustomerBasicInputDTO(CustomerBasicInputDTO customerBasicInputDTO) {
        if (customerBasicInputDTO == null) return null;
        Customer customer = new Customer();
        customer.setAcccountStatus(true);
        customer.setBirthDate(customerBasicInputDTO.getDateOfBirth() != null ?
                LocalDate.parse(customerBasicInputDTO.getDateOfBirth()) : null);
        customer.setContactNumber(customerBasicInputDTO.getCustomerContactNumber());
        customer.setEmail(customerBasicInputDTO.getCustomerEmail());
        customer.setName(customerBasicInputDTO.getCustomerName());
        return customer;
    }

    public static BookInformationDTO bookToBookInformationDTO(Book book) {
        if (book == null) return null;
        double average = 0.0;
        if (book.getReviews() != null && !book.getReviews().isEmpty()) {
            average = book.getReviews().stream()
                    .collect(Collectors.averagingDouble(r -> r.getRating() != null ? r.getRating() : 0));
            average = Math.round(average * 100.0) / 100.0;
        }
        return new BookInformationDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getAvailableCopies(),
                book.getTotalCopies(),
                average
        );
    }

    public static IssuedBookInformationDTO issuedBookToissuedBookInformationDTO(IssuedBook issuedBook) {
        if (issuedBook == null) return null;
        return new IssuedBookInformationDTO(
                issuedBook.getId(),
                bookToBookInformationDTO(issuedBook.getBook()),
                customerToCustomerInformationDTO(issuedBook.getCustomer()),
                issuedBook.getIssuedDate() != null ? issuedBook.getIssuedDate().toString() : null,
                issuedBook.getDueDate() != null ? issuedBook.getDueDate().toString() : null,
                issuedBook.getReturnDate() != null ? issuedBook.getReturnDate().toString() : null,
                issuedBook.getIsReturned(),
                issuedBook.getFineAmount()
        );
    }

    public static ReviewInformationDTO reviewToReviewInformationDTO(Review review) {
        if (review == null) return null;
        Book book = review.getBook();
        return new ReviewInformationDTO(
                book != null ? book.getTitle() : null,
                book != null ? book.getAuthor() : null,
                review.getCustomer(),
                review.getComment(),
                review.getRating()
        );
    }

    public static PaymentInformationDTO paymentToPaymentInformationDTO(Payment payment) {
        if (payment == null) return null;
        return new PaymentInformationDTO(
                payment.getCustomer(),
                payment.getPaymentDate(),
                payment.getPaymentId(),
                payment.getAmount(),
                payment.getIsSuccessful()
        );
    }
}
