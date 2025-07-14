package com.library.management.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class IssuedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // we're creating many to one mapings
    // book_id will column populated here
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // customer can issue multiple books here
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull
    private LocalDate issuedDate;

    @NotNull
    private LocalDate dueDate;

    // following entries will be added after returned the product
    private LocalDate returnDate;
    private Boolean isReturned;

    @Min(0)
    private Double fineAmount = 0.0;

}
