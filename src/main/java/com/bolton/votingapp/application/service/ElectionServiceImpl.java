package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.Election;
import com.bolton.votingapp.domain.repository.ElectionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionServiceImpl implements ElectionService {

    private final ElectionRepository electionRepository;

    public ElectionServiceImpl(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    @Override
    public List<Election> findAll() {
        return electionRepository.findAll();
    }

    @Override
    public Optional<Election> findById(Long id) {
        return electionRepository.findById(id);
    }

    @Override
    public Election save(Election election) {
        return electionRepository.save(election);
    }

    @Override
    public Election update(Long id, Election election) {
        Election existing = electionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Election not found"));
        existing.setTitle(election.getTitle());
        existing.setDescription(election.getDescription());
        existing.setStartDate(election.getStartDate());
        existing.setEndDate(election.getEndDate());
        return electionRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        electionRepository.deleteById(id);
    }
}

