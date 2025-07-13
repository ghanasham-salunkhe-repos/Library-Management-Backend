package com.library.management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private  String author;

    @NotNull
    private Integer totalCopies;

    @NotNull
    private Integer availableCopies;

    @OneToMany(mappedBy = "book")
    List<Review> reviews=new ArrayList<>();// one to many mappings
}
