package com.library.management.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", initialValue = 10001)
    private Long id;

    // notnull and not empty make sure data is not null + not empty
    @NotNull
    @NotEmpty
    private String name;


    // email annotation will add email rules on received string
    @NotNull
    @Email
    @NotEmpty
    private String email;

    // using the 10 digit regex pattern to get the only 10 numbers inside in input as contact number
    // no need for nonempty while using pattern
    @NotNull
    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    private String contactNumber;

    // enforce date pattern on localdate
    //no need for nonempty while using pattern
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    // this following two data point will be computed internally
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate membershipDate = LocalDate.now();

    // not enforcing not null as we will create it accordingly
    private Boolean isFeePaid = false;
}
