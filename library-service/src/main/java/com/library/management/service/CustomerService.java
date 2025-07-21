package com.library.management.service;


import com.library.management.dto.input.CustomerBasicInputDTO;
import com.library.management.dto.outputs.CustomerInformationDTO;
import com.library.management.dto.outputs.IssuedBookInformationDTO;

import java.util.List;


public interface CustomerService {

    // create entries
    void createNewCustomerEntr(CustomerBasicInputDTO customerBasicInputDTO);

    // retrive information
    List<CustomerInformationDTO> getAllCustomers();

    List<CustomerInformationDTO> getAllCustomerByAccountStatus(Boolean accountStatus);

    CustomerInformationDTO getCustomerById(Long customerId);

    List<IssuedBookInformationDTO> getActiveIssuedBookInformationById(Long customerId);

    List<IssuedBookInformationDTO> getIssuedBooksByCustomerId(Long customerId);

    List<CustomerInformationDTO> getAllCustomersWithActiveIssuedBooks();
}
