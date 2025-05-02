package com.bolton.votingapp.infrastructure.persistence.impl;

import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.infrastructure.persistence.entity.SpringDataVoterRepository;
import com.bolton.votingapp.infrastructure.persistence.entity.VoterRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public abstract class VoterRepositoryImpl implements VoterRepository {

    private final SpringDataVoterRepository springDataRepo;

    public VoterRepositoryImpl(SpringDataVoterRepository springDataRepo) {
        this.springDataRepo = springDataRepo;
    }

    @Override
    public Optional<Voter> findByEmail(String email) {
        return springDataRepo.findByEmail(email);
    }

    @Override
    public Voter save(Voter voter) {
        return springDataRepo.save(voter);
    }

    @Override
    public Optional<Voter> findById(Long id) {
        return springDataRepo.findById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return springDataRepo.existsByEmail(email);
    }
}
