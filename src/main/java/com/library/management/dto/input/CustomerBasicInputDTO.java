package com.library.management.dto.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

// this DTO is for input
// it should match rules with model
@AllArgsConstructor
@Data
public class CustomerBasicInputDTO {

    @NotNull
    @NotEmpty
    private String customerName;

    @NotNull
    @Email
    @NotEmpty
    private String customerEmail;

    @NotNull
    @Pattern(regexp = "\\d{10}", message = "Contact number must be 10 digits")
    private String customerContactNumber;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateOfBirth;
}
