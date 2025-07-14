package com.library.management.service;


import com.library.management.dto.input.CustomerBasicInputDTO;
import com.library.management.dto.outputs.CustomerInformationDTO;

import java.util.List;


public interface CustomerService {

    // create entries
    void createNewCustomerEntr(CustomerBasicInputDTO customerBasicInputDTO);

    // retrive information
    List<CustomerInformationDTO> getAllCustomers();

    List<CustomerInformationDTO> getAllCustomerByAccountStatus(Boolean accountStatus);

    CustomerInformationDTO getCustomerById(Long customerId);
}
