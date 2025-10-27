package com.example.Authentication.Service;

import com.example.Authentication.DTO.LoginDto;
import com.example.Authentication.DTO.SignupDto;
import com.example.Authentication.Model.Auth;
import com.example.Authentication.Repository.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl {

    @Autowired
    private AuthRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createNewUser(SignupDto dto) {
        // Check if email already exists
        if (repo.findByEmail(dto.getEmail()).isPresent()) {
            return "Email already registered!";
        }

        // Check if username already exists
        if (repo.findByUsername(dto.getUsername()).isPresent()) {
            return "Username already exists!";
        }

        // Hash password before saving
        String hashed = passwordEncoder.encode(dto.getPassword());

        // Create new user with hashed password
        Auth newUser = new Auth(
                dto.getName(),
                dto.getEmail(),
                dto.getUsername(),
                hashed,
                dto.getRole()
        );

        // Save user in database
        repo.save(newUser);
        return "Signup successful!";
    }

    public String userLogin(LoginDto dto) {
        Optional<Auth> userOpt = repo.findByUsername(dto.getUsername());
        if (userOpt.isEmpty()) {
            return "Invalid username!";
        }

        Auth user = userOpt.get();
        if (passwordEncoder.matches(dto.getPassword(), user.getHashedPassword())) {
            return "Login successful! Welcome, " + user.getName();
        } else {
            return "Invalid password!";
        }
    }
}
