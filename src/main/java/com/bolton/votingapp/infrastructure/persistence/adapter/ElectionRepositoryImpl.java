package com.bolton.votingapp.infrastructure.persistence.adapter;

import com.bolton.votingapp.application.mapper.ElectionMapper;
import com.bolton.votingapp.domain.model.ElectionModel;
import com.bolton.votingapp.domain.repository.ElectionRepository;
import com.bolton.votingapp.infrastructure.persistence.entity.ElectionEntity;
import com.bolton.votingapp.infrastructure.persistence.repository.ElectionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ElectionRepositoryImpl implements ElectionRepository {

    private final ElectionJpaRepository electionJpaRepository;
    private final ElectionMapper electionMapper;

    @Override
    public ElectionModel save(ElectionModel election) {
        ElectionEntity entity = electionMapper.toEntity(election);
        return electionMapper.toModel(electionJpaRepository.save(entity));
    }

    @Override
    public List<ElectionModel> getAllElections() {
        return electionJpaRepository.findAll()
                .stream()
                .map(electionMapper::toModel)
                .toList();
    }

    @Override
    public Optional<ElectionModel> getById(Long electionId) {
        return electionJpaRepository.findById(electionId)
                .map(electionMapper::toModel);
    }

    @Override
    public ElectionModel updateElection(Long electionId, ElectionModel updatedElectionModel) {
        return electionMapper.toModel(electionJpaRepository.save(electionMapper.toEntity(updatedElectionModel)));
    }

    @Override
    public void deleteById(Long electionId) {
        electionJpaRepository.deleteById(electionId);
    }
}
