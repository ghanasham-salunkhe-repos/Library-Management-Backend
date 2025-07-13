package com.library.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Search Management", description = "Book search related endpoints")
@RestController
@RequestMapping("/api/search")
public class SearchController {
}
