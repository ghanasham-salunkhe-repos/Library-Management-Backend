package com.library.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Book Returns Management", description = "Endpoints related to book returns ")
@RestController
@RequestMapping("/api/returns")
public class ReturnController {
}
