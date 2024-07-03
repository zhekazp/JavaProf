package org.task4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private Roots root;

    public User(String name, String password, String email, String phone, Roots root) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.root = root;
    }




}
