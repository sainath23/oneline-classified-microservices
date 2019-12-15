package com.doitgeek.oc.usermanagementservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestRestController {

    @GetMapping
    public String greet() {
        System.out.println("Inside greet...");
        return "Hello from test controller...";
    }
}
