package com.bolton.votingapp.infrastructure.persistence.adapter;

import com.bolton.votingapp.application.mapper.VoterMapper;
import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.infrastructure.persistence.repository.VoterJpaRepository;
import com.bolton.votingapp.domain.repository.VoterRepository;
import com.bolton.votingapp.infrastructure.persistence.entity.VoterEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VoterRepositoryImpl implements VoterRepository {

    private final VoterJpaRepository voterJpaRepository;
    private final VoterMapper voterMapper;

    @Override
    public Voter save(Voter voter) {
        VoterEntity entity = voterMapper.toEntity(voter);
        return voterMapper.toDomain(voterJpaRepository.save(entity));
    }

    @Override
    public Optional<Voter> findByEmail(String email) {
        return voterJpaRepository.findByEmail(email)
                .map(voterMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return voterJpaRepository.existsByEmail(email);
    }

    @Override
    public List<Voter> findAll() {
        return voterJpaRepository.findAll()
                .stream()
                .map(voterMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Voter> findById(long id) {
        return voterJpaRepository.findById(id).map(VoterMapper::toDomain);
    }
}