package com.library.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Reviews", description = "Book reviews endpoints")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
}
