package com.example.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        log.info("Fetching user: {}", id);
        return new UserResponse(id, "Soham", "soham@gmail.com");
    }
}

record UserResponse(Long id, String name, String email) {}
