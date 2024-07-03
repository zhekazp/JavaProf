package org.task3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Roots root;

    public User(String name, String password, String email, String phone, Roots root) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.root = root;
    }
}
