package com.example.Authentication.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="AuthTable")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String email;
    String password;
    String hpw;
    String role;

    public Auth() {
    }

    public Auth(int id, String name, String email, String password, String hpw, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.hpw = hpw;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHpw() {
        return hpw;
    }

    public void setHpw(String hpw) {
        this.hpw = hpw;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }





}
