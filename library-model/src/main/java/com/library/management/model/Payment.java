package com.library.management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull
    private LocalDate paymentDate;

    @NotNull
    private String paymentId;

    @NotNull
    private Double amount;

    @NotNull
    private Boolean isSuccessful;
}
