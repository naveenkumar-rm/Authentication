package com.example.Authentication.Service;

import com.example.Authentication.DTO.LoginDto;
import com.example.Authentication.DTO.SignupDto;
import com.example.Authentication.Model.Auth;

public interface AuthService {
    public String createnewUser(SignupDto dto);
    public String userLogin(LoginDto loginuser);
}
