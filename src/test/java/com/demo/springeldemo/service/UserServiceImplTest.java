package com.demo.springeldemo.service;

import com.demo.springeldemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    void add() {
        userService.add(new User(2,"aa", 12));
    }

    @Test
    void list(){
        List<User> list = userService.list();
        System.out.println(list);
    }
}