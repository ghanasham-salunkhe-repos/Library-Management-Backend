package com.library.management.dto.outputs;

import com.library.management.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewInformationDTO {

    private String bookName;
    private String bookAuthor;
    private Customer customer;
    private String comment;
    private Integer rating;
}
