package com.library.management.service.impl;

import com.library.management.dto.outputs.BookInformationDTO;
import com.library.management.exceptions.BookNotFoundException;
import com.library.management.mapper.LibraryManagementMapper;
import com.library.management.model.Book;
import com.library.management.repositories.BookRepository;
import com.library.management.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookInformationDTO> getBooKDetailsWithAvailability() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            return new ArrayList<>();
        }
        return books.stream().map(LibraryManagementMapper::bookToBookInformationDTO).toList();
    }

    @Override
    public BookInformationDTO getBookById(Long bookId) {
        // search data by id if not found throw exception
        return LibraryManagementMapper.bookToBookInformationDTO(
                bookRepository.findById(bookId).orElseThrow(
                    ()-> new BookNotFoundException(bookId)
                ));
    }
}
