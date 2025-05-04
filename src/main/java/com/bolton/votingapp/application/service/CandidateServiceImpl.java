package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.Candidate;
import com.bolton.votingapp.domain.repository.CandidateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;


    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> findById(Long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate update(Long id, Candidate candidate) {
        Candidate existing = candidateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Candidate not found"));
        existing.setName(candidate.getName());
        existing.setParty(candidate.getParty());
        // Set other fields
        return candidateRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        candidateRepository.deleteById(id);
    }
}
