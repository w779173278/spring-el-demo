package com.demo.springeldemo.service;

import com.demo.springeldemo.pojo.User;

import java.util.List;

public interface UserService {

    User add(User user);

    List<User> list();
}
