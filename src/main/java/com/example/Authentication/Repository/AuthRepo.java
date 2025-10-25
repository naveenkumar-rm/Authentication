package com.example.Authentication.Repository;

import com.example.Authentication.DTO.LoginDto;
import com.example.Authentication.Model.Auth;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthRepo extends JpaRepository<Auth,Integer> {

    @Transactional
    @Modifying
    @Query(value="call signup(:name,:email,:password,:role,:hpw)",nativeQuery = true)
    public void createUser(@Param("name") String name,@Param("email") String email,
                           @Param("password")  String password,@Param("role") String role,@Param("hpw") String hpw);

    public Optional<Auth> findByEmail(String email);
    public void findByEmailAndPassword(String email,String password);
}
