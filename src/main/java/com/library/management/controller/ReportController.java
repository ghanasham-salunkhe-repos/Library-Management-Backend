package com.library.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Reporting Management", description = "Library management reporting endpoints")
@RestController
@RequestMapping("/api/reports")
public class ReportController {
}
