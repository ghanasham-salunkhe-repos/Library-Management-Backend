package com.library.management.dto.outputs;


import com.library.management.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PaymentInformationDTO {

    private Customer customer;
    private LocalDate paymentDate;
    private String paymentId;
    private Double amount;
    private Boolean isSuccessful;
}
