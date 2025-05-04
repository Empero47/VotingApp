package com.bolton.votingapp.domain.repository;

import com.bolton.votingapp.domain.model.VoterModel;

import java.util.List;
import java.util.Optional;

public interface VoterRepository {
    VoterModel save(VoterModel voterModel);
    Optional<VoterModel> findByEmail(String email);
    boolean existsByEmail(String email);
    List<VoterModel> findAll();
    Optional<VoterModel> findById(long id);
}
