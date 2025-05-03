package com.bolton.votingapp.application.service;

import com.bolton.votingapp.application.mapper.VoterMapper;
import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.domain.repository.VoterRepository;
import com.bolton.votingapp.infrastructure.persistence.entity.VoterEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoterServiceImpl implements VoterService {

    private final VoterRepository voterRepository;
    private final VoterMapper voterMapper;

    @Override
    public Voter registerVoter(Voter voter) {
        // VoterEntity entity = voterMapper.toEntity(voter); // Mapping domain to entity
        Voter saved = voterRepository.save(voter); // Save to DB
        return saved; // Convert back to domain model
    }

    @Override
    public boolean existsByEmail(String email) {
        return voterRepository.existsByEmail(email); // Check if email exists in DB
    }

    @Override
    public List<Voter> getAllVoters() {
        List<Voter> voters = voterRepository.findAll(); // Get all entities
        return voters; // Map to domain objects
    }
}
