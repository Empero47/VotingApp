package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.VoterModel;
import com.bolton.votingapp.domain.repository.VoterRepository;
import com.bolton.votingapp.application.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final VoterRepository voterRepository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

//    public AuthService(VoterRepository voterRepository, PasswordEncoder encoder, JwtService jwtService) {
//        this.voterRepository = voterRepository;
//        this.encoder = encoder;
//        this.jwtService = jwtService;
//    }

    public String register(String name, String email, String rawPassword) {
        if (voterRepository.findByEmail(email).isPresent()) throw new IllegalArgumentException("Email exists");
        VoterModel voterModel = new VoterModel(null, name, email, encoder.encode(rawPassword), false);
        voterRepository.save(voterModel);
        return jwtService.generateToken(email);
    }

    public String login(String email, String password) {
        VoterModel voterModel = voterRepository.findByEmail(email).orElseThrow();
        log.info("VoterModel: {}", voterModel);
        if (!encoder.matches(password, voterModel.getPassword()))
            throw new IllegalArgumentException("Invalid credentials");

        return jwtService.generateToken(email);
    }
}
