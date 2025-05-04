package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.Candidate;
import com.bolton.votingapp.domain.model.Election;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    List<Candidate> findAll();
    Optional<Candidate> findById(Long id);
    Candidate save(Candidate candidate);
    Candidate update(Long id, Candidate candidate);
    void deleteById(Long id);
}
