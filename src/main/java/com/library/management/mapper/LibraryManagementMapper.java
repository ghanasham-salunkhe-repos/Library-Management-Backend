package com.library.management.mapper;

import com.library.management.dto.CustomerInformationDTO;
import com.library.management.model.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LibraryManagementMapper {

    public static CustomerInformationDTO customerToCustomerInformationDTO(Customer customer) {
        return new CustomerInformationDTO(
                customer.getId(),customer.getName(),customer.getBirthDate().toString(),customer.getEmail(),customer.getContactNumber());
    }
}
