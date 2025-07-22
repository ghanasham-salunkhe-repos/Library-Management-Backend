package com.library.management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Book {


    @OneToMany(mappedBy = "book")
    List<Review> reviews = new ArrayList<>();// one to many mappings
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private String author;

    @Min(0)
    @NotNull
    private Integer totalCopies;
    @NotNull
    private Integer availableCopies;
}
