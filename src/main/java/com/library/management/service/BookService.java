package com.library.management.service;

import com.library.management.dto.outputs.BookInformationDTO;

import java.util.List;

public interface BookService {

    List<BookInformationDTO> getBooKDetailsWithAvailability();

    BookInformationDTO getBookById(Long bookId);
}
