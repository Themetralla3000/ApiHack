package com.example.plantilla_hack.security;


import com.example.plantilla_hack.security.dto.LoginUserDTO;
import com.example.plantilla_hack.security.dto.RegisterUserDTO;
import com.example.plantilla_hack.adapter.out.persistance.UserJPA;
import com.example.plantilla_hack.adapter.out.persistance.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserJPA signup(RegisterUserDTO input) {
        UserJPA userJPA = new UserJPA();
        userJPA.setFullName(input.getFullName());
        userJPA.setEmail(input.getEmail());
        userJPA.setPassword(passwordEncoder.encode(input.getPassword()));


        return userRepository.save(userJPA);
    }

    public UserJPA authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
