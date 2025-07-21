package com.library.management.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Library System", description = "System management endpoints")
@RestController
@RequestMapping("/api/system")
public class SystemController {
}
