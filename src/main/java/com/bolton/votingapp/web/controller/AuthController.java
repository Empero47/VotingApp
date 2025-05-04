package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.application.service.AuthService;
import com.bolton.votingapp.web.dto.LoginRequest;
import com.bolton.votingapp.web.dto.RegisterRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest.getName(),registerRequest.getEmail(), registerRequest.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
