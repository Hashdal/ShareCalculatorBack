package com.learning.content_calendar.controller;

import org.springframework.web.bind.annotation.*;
import com.learning.content_calendar.service.GreetingService;


@RestController
@RequestMapping("/api")

public class HelloController {

    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService) {
        this.greetingService = greetingService;

    }

    @GetMapping("/hello-world/{name}")
    public String hello(@PathVariable String name) {
        return greetingService.greet(name);
    }
}