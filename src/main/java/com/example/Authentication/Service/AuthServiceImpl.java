package com.example.Authentication.Service;

import com.example.Authentication.DTO.LoginDto;
import com.example.Authentication.DTO.SignupDto;
import com.example.Authentication.Model.Auth;
import com.example.Authentication.Repository.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    AuthRepo repo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    BCryptPasswordEncoder bcryptEncoder;

    @Override
    public String createnewUser(SignupDto user) {

        Optional<Auth> existingEmail=repo.findByEmail(user.getEmail());
        System.out.println(existingEmail);
        if(existingEmail.isPresent()){
            return  "Email already exists";
        }
        String hashedpw=bcryptEncoder.encode(user.getPassword());
        repo.createUser(user.getName(),user.getEmail(),user.getPassword(),user.getRole(),hashedpw);
        System.out.println(hashedpw);
        return "User Registered Successfully";
    }

    @Override
    public String userLogin(LoginDto loginuser) {
        Optional<Auth> existingUser=repo.findByEmail(loginuser.getEmail());
        if(existingUser.isEmpty()) {
            return "Useremail not found";
        }

        Auth isExistinguser=existingUser.get();
        if(passwordEncoder.matches(loginuser.getPw(),isExistinguser.getHpw())){
            return "Login success";
        }
            return "Password Mismatch";


    }
}
