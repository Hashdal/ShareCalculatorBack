package com.learning.content_calendar.controller;

import org.springframework.web.bind.annotation.*;
import com.learning.content_calendar.service.UserService;
import java.util.List;
import com.learning.content_calendar.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

}