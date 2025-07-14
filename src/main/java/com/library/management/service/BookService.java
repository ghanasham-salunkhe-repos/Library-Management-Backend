package com.library.management.service;

import com.library.management.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooKDetailsWithAvailability();
}
