package com.example.Authentication.Repository;

import com.example.Authentication.Model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepo extends JpaRepository<Auth, Integer> {
    Optional<Auth> findByUsername(String username);
    Optional<Auth> findByEmail(String email);
}
