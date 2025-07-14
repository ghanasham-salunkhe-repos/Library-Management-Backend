package com.library.management.dto.outputs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerInformationDTO {

    private Long id;
    private String name;
    private String birthdayDate;
    private String email;
    private String contactNumber;

}
