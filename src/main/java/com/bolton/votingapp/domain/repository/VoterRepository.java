package com.bolton.votingapp.domain.repository;

import com.bolton.votingapp.domain.model.Voter;

import java.util.List;
import java.util.Optional;

public interface VoterRepository {
    Voter save(Voter voter);
    Optional<Voter> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Voter> findAll();
    Optional<Voter> findById(long id);
}
