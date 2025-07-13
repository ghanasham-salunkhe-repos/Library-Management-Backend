package com.library.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Management", description = "Books related endpoints")
@RestController
@RequestMapping("/api/books")
public class BookController {

}
