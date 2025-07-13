package com.library.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// rest controller is used to provide REST services on the controller
@RestController
@RequestMapping("/")
@Slf4j
public class CentralController {

    @GetMapping("/")
    public String homepage() {
        log.info("[GET]['/'] Api called");
        return "<h1>Hello world!</h1>";
    }
}
