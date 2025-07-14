package com.library.management.service;


import com.library.management.dto.CustomerInformationDTO;

import java.util.List;


public interface CustomerService {

    List<CustomerInformationDTO> getAllCustomers();
    List<CustomerInformationDTO> getAllCustomerByAccountStatus(Boolean accountStatus);
    CustomerInformationDTO getCustomerById(Long customerId);
}
