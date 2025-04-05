package com.example.plantilla_hack.security.endpoints;


import com.example.plantilla_hack.adapter.out.persistance.user.JPAUserRepository;
import com.example.plantilla_hack.model.User;
import com.example.plantilla_hack.security.dto.LoginResponse;
import com.example.plantilla_hack.security.dto.LoginUserDTO;
import com.example.plantilla_hack.security.dto.RegisterUserDTO;
import com.example.plantilla_hack.adapter.out.persistance.user.UserJPAEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JPAUserRepository userJpaRepository;

    public AuthenticationController(JPAUserRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDto) {

        Optional<User> userOptional = userJpaRepository.findByEmail(loginUserDto.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(loginUserDto.getPassword())) {
                LoginResponse loginResponse = new LoginResponse("Login successful");
                return ResponseEntity.ok(loginResponse);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginResponse("Invalid email or password"));
    }



}