package com.bolton.votingapp.infrastructure.persistence.adapter;

import com.bolton.votingapp.application.mapper.VoterMapper;
import com.bolton.votingapp.domain.model.VoterModel;
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
    public VoterModel save(VoterModel voterModel) {
        VoterEntity entity = voterMapper.toEntity(voterModel);
        return voterMapper.toDomain(voterJpaRepository.save(entity));
    }

    @Override
    public Optional<VoterModel> findByEmail(String email) {
        return voterJpaRepository.findByEmail(email)
                .map(voterMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return voterJpaRepository.existsByEmail(email);
    }

    @Override
    public List<VoterModel> findAll() {
        return voterJpaRepository.findAll()
                .stream()
                .map(voterMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<VoterModel> findById(long id) {
        return voterJpaRepository.findById(id).map(voterMapper::toDomain);
    }
}