package com.bolton.votingapp.infrastructure.persistence.adapter;

import com.bolton.votingapp.domain.model.CandidateModel;
import com.bolton.votingapp.infrastructure.persistence.repository.CandidateJpaRepository;
import com.bolton.votingapp.domain.repository.CandidateRepository;
import com.bolton.votingapp.infrastructure.persistence.entity.CandidateEntity;
import com.bolton.votingapp.application.mapper.CandidateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CandidateRepositoryImpl implements CandidateRepository {

    private final CandidateJpaRepository candidateJpaRepository;
    private final CandidateMapper candidateMapper;

    @Override
    public CandidateModel save(CandidateModel candidateModel) {
        CandidateEntity ent = candidateMapper.toEntity(candidateModel);
        CandidateEntity saved = candidateJpaRepository.save(ent);
        return candidateMapper.toModel(saved);
    }

    @Override
    public List<CandidateModel> findByElectionId(Long electionId) {
        return candidateJpaRepository.findByElectionId(electionId)
                .stream()
                .map(candidateMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public CandidateModel findByName(String name) {
        return candidateJpaRepository.findByName(name)
                .map(candidateMapper::toModel)
                .orElseThrow(IllegalArgumentException::new);  // Or handle appropriately if not found
    }

    @Override
    public Optional<CandidateModel> findById(Long id) {
        return candidateJpaRepository.findById(id)
                .map(candidateMapper::toModel);
    }

    @Override
    public List<CandidateModel> findAll() {
        return candidateJpaRepository.findAll()
                .stream()
                .map(candidateMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        candidateJpaRepository.deleteById(id);
    }
}
