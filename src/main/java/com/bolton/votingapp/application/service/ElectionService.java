package com.bolton.votingapp.application.service;

import com.bolton.votingapp.application.mapper.ElectionMapper;
import com.bolton.votingapp.domain.model.Election;
import com.bolton.votingapp.domain.repository.ElectionRepository;
import com.bolton.votingapp.infrastructure.persistence.entity.ElectionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ElectionService {
    private final ElectionRepository electionRepository;
    private final ElectionMapper electionMapper;



    // Create a new election
    public Election createElection(Election election) {
        ElectionEntity electionEntity = electionMapper.toEntity(election);
        electionRepository.save(electionEntity);
        return electionMapper.toDomain(electionEntity);
    }

    // Get all elections
    public List<Election> getAllElections() {
        return electionRepository.findAll()
                .stream()
                .map(electionMapper::toDomain)
                .toList();
    }

    // Get election by ID
    public Election getElectionById(Long electionId) {
        return electionRepository.findById(electionId)
                .map(electionMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Election not found"));
    }

    // Update election
    public Election updateElection(Long electionId, Election updatedElection) {
        Election election = getElectionById(electionId);
        election.setName(updatedElection.getName());
        election.setDescription(updatedElection.getDescription());
        election.setDate(updatedElection.getDate());
        election.setActive(updatedElection.isActive());
        electionRepository.save(electionMapper.toEntity(election));
        return election;
    }

    // Delete an election
    public void deleteElection(Long electionId) {
        Election election = getElectionById(electionId);
        electionRepository.delete(electionMapper.toEntity(election));
    }
}
