package com.example.quizmanagement.controller;

import com.example.quizmanagement.model.User;
import com.example.quizmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.createUser(user.getUsername(), user.getPassword(), user.getRole());
    }
}
