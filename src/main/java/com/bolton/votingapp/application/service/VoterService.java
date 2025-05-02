package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.infrastructure.persistence.entity.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterService {

    private final VoterRepository voterRepository;

    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public Voter registerVoter(Voter voter) {
        return voterRepository.save(voter);
    }

    public Optional<Voter> findByEmail(String email) {
        return voterRepository.findByEmail(email);
    }

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public boolean existsByEmail(String email) {
        return voterRepository.existsByEmail(email);
    }
}
