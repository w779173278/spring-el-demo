package com.demo.springeldemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer uid;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name =name;
        this.age = age;
    }
}
