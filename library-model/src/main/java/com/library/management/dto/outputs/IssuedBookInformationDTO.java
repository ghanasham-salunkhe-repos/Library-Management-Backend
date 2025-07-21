package com.library.management.dto.outputs;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IssuedBookInformationDTO {

    private Long bookIssueReferenceId;
    private BookInformationDTO bookDetails;
    private CustomerInformationDTO customerDetails;
    private String bookIssuedDate;
    private String bookReturnDueDate;
    private String bookReturnDate;
    private Boolean isBookReturned;
    private Double fineAmount;
}
