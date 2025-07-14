package com.library.management.service.impl;

import com.library.management.model.Book;
import com.library.management.repositories.BookRepository;
import com.library.management.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooKDetailsWithAvailability() {
        return bookRepository.findAll();
    }
}
