package com.library.management.controller;

import com.library.management.model.Book;
import com.library.management.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Book Management", description = "Books related endpoints")
@RestController
@RequestMapping("/api/books")
@Slf4j
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> getAvalabilityInformation() {

        log.info("[GET][/api/books] fetching all books information");
        List<Book> books = bookService.getBooKDetailsWithAvailability();
        return new ArrayList<>();
    }
}
