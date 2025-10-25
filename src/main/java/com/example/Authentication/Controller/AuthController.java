package com.example.Authentication.Controller;


import com.example.Authentication.DTO.LoginDto;
import com.example.Authentication.DTO.SignupDto;

import com.example.Authentication.Service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthServiceImpl service;

    @PostMapping("/signup")
    public String signupUser(@RequestBody SignupDto signupdto){
        System.out.println(signupdto);
        return service.createnewUser(signupdto);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDto loginDto){
        return  service.userLogin(loginDto);
    }
}
