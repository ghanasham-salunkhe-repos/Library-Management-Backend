package com.library.management.mapper;

import com.library.management.dto.input.CustomerBasicInputDTO;
import com.library.management.dto.outputs.BookInformationDTO;
import com.library.management.dto.outputs.CustomerInformationDTO;
import com.library.management.dto.outputs.IssuedBookInformationDTO;
import com.library.management.model.Book;
import com.library.management.model.Customer;
import com.library.management.model.IssuedBook;
import com.library.management.model.Review;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.stream.Collectors;

@UtilityClass
public class LibraryManagementMapper {

    // mappers related to customer entity
    public static CustomerInformationDTO customerToCustomerInformationDTO(Customer customer) {
        return new CustomerInformationDTO(
                customer.getId(), customer.getName(), customer.getBirthDate().toString(), customer.getEmail(), customer.getContactNumber());
    }

    public static Customer customerFromCustomerBasicInputDTO(CustomerBasicInputDTO customerBasicInputDTO) {
        Customer customer = new Customer();
        customer.setAcccountStatus(true);
        customer.setBirthDate(LocalDate.parse(customerBasicInputDTO.getDateOfBirth()));
        customer.setContactNumber(customerBasicInputDTO.getCustomerContactNumber());
        customer.setEmail(customerBasicInputDTO.getCustomerEmail());
        customer.setName(customerBasicInputDTO.getCustomerName());
        return customer;
    }


    // mappers for book entity
    public static BookInformationDTO bookToBookInformationDTO(Book book) {
        double average = book.getReviews().stream()
                .collect(Collectors.averagingDouble(Review::getRating));
        average = Math.round(average * 100.0) / 100.0;
        return new BookInformationDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getAvailableCopies(), book.getTotalCopies(), average);
    }


    // mappers for issueBook table
    public static IssuedBookInformationDTO issuedBookToissuedBookInformationDTO(IssuedBook issuedBook) {
        return new IssuedBookInformationDTO(
                issuedBook.getId(),
                LibraryManagementMapper.bookToBookInformationDTO(issuedBook.getBook()),
                LibraryManagementMapper.customerToCustomerInformationDTO(issuedBook.getCustomer()),
                issuedBook.getIssuedDate() != null ? issuedBook.getIssuedDate().toString() : null,
                issuedBook.getDueDate() != null ? issuedBook.getDueDate().toString() : null,
                issuedBook.getReturnDate() != null ? issuedBook.getReturnDate().toString() : null,
                issuedBook.getIsReturned(),
                issuedBook.getFineAmount()
        );
    }
}
