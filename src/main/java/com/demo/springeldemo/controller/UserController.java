package com.demo.springeldemo.controller;


import com.demo.springeldemo.pojo.User;
import com.demo.springeldemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> list() {
        return userService.list();
    }

    @PostMapping
    public String add(@RequestBody User user) {
        userService.add(user);
        return String.valueOf(user.getUid());
    }
}
