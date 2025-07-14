package com.library.management.service;

import com.library.management.dto.outputs.IssuedBookInformationDTO;

import java.util.List;

public interface IssuedBookService {
    List<IssuedBookInformationDTO> getAllIssuedBooksInformation();
    IssuedBookInformationDTO getIssuedBooksInformationById(Long issuedBookId);
    List<IssuedBookInformationDTO> getNotReturnedIssuedBooksInformation();
    List<IssuedBookInformationDTO> getReturnedIssuedBooksInformation();
}
