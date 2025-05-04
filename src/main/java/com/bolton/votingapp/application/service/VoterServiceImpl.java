package com.bolton.votingapp.application.service;

import com.bolton.votingapp.application.mapper.VoterMapper;
import com.bolton.votingapp.domain.model.VoterModel;
import com.bolton.votingapp.domain.repository.VoterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoterServiceImpl implements VoterService {

    private final VoterRepository voterRepository;
    private final VoterMapper voterMapper;

    @Override
    public VoterModel registerVoter(VoterModel voterModel) {
        // VoterEntity entity = voterMapper.toEntity(voterModel); // Mapping domain to entity
        VoterModel saved = voterRepository.save(voterModel); // Save to DB
        return saved; // Convert back to domain model
    }

    @Override
    public boolean existsByEmail(String email) {
        return voterRepository.existsByEmail(email); // Check if email exists in DB
    }

    @Override
    public List<VoterModel> getAllVoters() {
        List<VoterModel> voterModels = voterRepository.findAll(); // Get all entities
        return voterModels; // Map to domain objects
    }
}
