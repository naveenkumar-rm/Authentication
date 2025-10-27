package com.example.Authentication.Controller;

import com.example.Authentication.DTO.LoginDto;
import com.example.Authentication.DTO.SignupDto;
import com.example.Authentication.Service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl service;

    @PostMapping("/signup")
    public ResponseEntity<String> signupUser(@RequestBody SignupDto signupDto) {
        String response = service.createNewUser(signupDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
        String response = service.userLogin(loginDto);
        return ResponseEntity.ok(response);
    }
}
