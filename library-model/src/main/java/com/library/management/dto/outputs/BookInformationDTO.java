package com.library.management.dto.outputs;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookInformationDTO {
    private Long id;
    private String title;
    private String author;
    private Integer availableCopies;
    private Integer totalCopies;
    private Double rating;
}
