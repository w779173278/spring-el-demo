package com.demo.springeldemo.service;

import com.demo.springeldemo.core.AopTest;
import com.demo.springeldemo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final List<User> data = new ArrayList<>();
    private static Integer atomicCount = 0;

    @Override
    public User add(User user) {
        data.add(user);
        user.setUid(atomicCount++);
        return user;
    }

    @Override
    @AopTest("#user.age")
    public List<User> list() {
        return data;
    }
}
