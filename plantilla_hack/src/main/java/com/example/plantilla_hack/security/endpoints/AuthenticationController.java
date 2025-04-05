package com.example.plantilla_hack.security.endpoints;


import com.example.plantilla_hack.security.dto.LoginResponse;
import com.example.plantilla_hack.security.dto.LoginUserDTO;
import com.example.plantilla_hack.security.dto.RegisterUserDTO;
import com.example.plantilla_hack.adapter.out.persistance.UserJPA;
import com.example.plantilla_hack.security.AuthenticationService;
import com.example.plantilla_hack.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserJPA> register(@RequestBody RegisterUserDTO registerUserDto) {
        UserJPA registeredUserJPA = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUserJPA);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDto) {


        UserJPA authenticatedUserJPA = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUserJPA);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
    @GetMapping("/whoiam")
    public ResponseEntity<Map<String, Object>> whoAmI() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Object principal = authentication.getPrincipal();
        Map<String, Object> response = new HashMap<>();

        if (principal instanceof UserDetails userDetails) {
            response.put("username", userDetails.getUsername());

            // Si has cargado tu entidad User como UserDetails, puedes castear y extraer más datos:
            if (userDetails instanceof UserJPA user) {
                response.put("email", user.getEmail());

            }

        } else {
            response.put("username", principal.toString()); // fallback
        }

        return ResponseEntity.ok(response);
    }
}