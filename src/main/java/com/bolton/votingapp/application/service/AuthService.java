package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.domain.repository.VoterRepository;
import com.bolton.votingapp.application.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final VoterRepository voterRepository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthService(VoterRepository voterRepository, PasswordEncoder encoder, JwtService jwtService) {
        this.voterRepository = voterRepository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public String register(String name,String email, String rawPassword) {
        if (voterRepository.findByEmail(email).isPresent()) throw new IllegalArgumentException("Email exists");

        Voter voter = new Voter(null,name ,email, encoder.encode(rawPassword), false);
        voterRepository.save(voter);
        return jwtService.generateToken(email);
    }

    public String login(String email, String password) {
        Voter voter = voterRepository.findByEmail(email).orElseThrow();
        if (!encoder.matches(password, voter.getPassword()))
            throw new IllegalArgumentException("Invalid credentials");

        return jwtService.generateToken(email);
    }
}
