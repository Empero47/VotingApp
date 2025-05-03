package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.application.service.AuthService;
import com.bolton.votingapp.web.dto.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return authService.register(name,email, password);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
