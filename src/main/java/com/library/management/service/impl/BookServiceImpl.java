package com.library.management.service.impl;

import com.library.management.model.Book;
import com.library.management.repositories.BookRepository;
import com.library.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public void saveBook(Book book) {

    }
}
