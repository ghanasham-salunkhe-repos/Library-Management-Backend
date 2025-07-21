package com.library.management.service;

import com.library.management.dto.outputs.BookInformationDTO;

import java.util.List;

public interface BookService {

    List<BookInformationDTO> getBooKDetailsWithAvailability();

    BookInformationDTO getBookById(Long bookId);

    List<BookInformationDTO> getOutOfStockBooks();

    List<BookInformationDTO> getAllAvailableBooks();

    List<BookInformationDTO> getAllBooksOfRating(Integer rating);

    List<BookInformationDTO> getAllBooksAboveRating(Integer rating);
}
