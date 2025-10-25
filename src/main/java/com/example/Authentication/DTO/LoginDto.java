package com.example.Authentication.DTO;

public class LoginDto {
    String email;
    String pw;
    public LoginDto(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }

    public LoginDto() {
    }


    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
