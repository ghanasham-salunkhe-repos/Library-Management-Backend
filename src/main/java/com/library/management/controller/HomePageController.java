package com.library.management.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Home Page Functionalities", description = "Homepage related endpoints")
@RestController
@RequestMapping(("/api/"))
public class HomePageController {

    @GetMapping("/")
    public String homePage() {
        return "<h1>Hello World</h1>";
    }
}
