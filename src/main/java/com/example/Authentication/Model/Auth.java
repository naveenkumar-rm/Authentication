package com.example.Authentication.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "auth_table")

public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String username;
    @Column(unique = true)
    private String hashedPassword;
    private String role;


    public Auth(String name, String email, String username, String hashed, String role) {
    }

    public Auth(int id, String name, String email, String username, String hashedPassword, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.role = role;
    }



}
