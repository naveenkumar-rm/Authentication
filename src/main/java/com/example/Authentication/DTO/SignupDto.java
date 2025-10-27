package com.example.Authentication.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupDto {

    private String name;
    private String email;
    private String username;
    private String password;
    private String role;

    public SignupDto() {}

    public SignupDto(String name, String email, String username, String password, String role) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
