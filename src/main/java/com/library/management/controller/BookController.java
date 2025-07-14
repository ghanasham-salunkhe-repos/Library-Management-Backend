package com.library.management.controller;

import com.library.management.dto.outputs.BookInformationDTO;
import com.library.management.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Book Management", description = "Books related endpoints")
@RestController
@RequestMapping("/api/books")
@Slf4j
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<BookInformationDTO>> getAvalabilityInformation() {

        log.info("[GET][/api/books] fetching all books information");
        List<BookInformationDTO> books = bookService.getBooKDetailsWithAvailability();
        log.info("[GET][/api/books] Total count of books : {}", books.size());
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookInformationDTO> getBookById(@PathVariable Long bookId) {

        log.info("[GET][/api/books/{}] finding book with id {}", bookId, bookId);
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }

    @GetMapping("/out-of-stock")
    ResponseEntity<List<BookInformationDTO>> getOutOfStockBook() {
        log.info("[GET][/api/books/out-of-stock] Get out of stock books");
        return ResponseEntity.ok(bookService.getOutOfStockBooks());
    }

    @GetMapping("/in-stocks")
    ResponseEntity<List<BookInformationDTO>> getInStockBook() {
        log.info("[GET][/api/books/in-stocks] Get in-stock books");
        return ResponseEntity.ok(bookService.getAllAvailableBooks());
    }

    @GetMapping("/ratings/{rating}")
    ResponseEntity<List<BookInformationDTO>> getBooksByRating(@PathVariable Integer rating) {

        log.info("[GET][/api/books/ratings/{}] finding book with rating {}", rating, rating);
        return ResponseEntity.ok(bookService.getAllBooksOfRating(rating));
    }

    @GetMapping("/recommended")
    ResponseEntity<List<BookInformationDTO>> getRecommendedBooks() {
        log.info("[GET][/api/books/recommended] Get recommended books");
        return ResponseEntity.ok(bookService.getAllBooksAboveRating(4));
    }
}
