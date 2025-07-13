package com.library.management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// rest controller is used to provide REST services on the controller
@RestController
public class CentralController {

    @RequestMapping("/")
    public String homepage() {
        return "<h1>Hello world!</h1>";
    }
}
