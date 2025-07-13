package com.library.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Issue Management", description = "Book issuing endpoints")
@RestController
@RequestMapping("/api/issues")
public class IssueController {
}
