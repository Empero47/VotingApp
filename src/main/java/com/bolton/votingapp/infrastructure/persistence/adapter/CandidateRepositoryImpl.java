package com.bolton.votingapp.infrastructure.persistence.adapter;

import com.bolton.votingapp.domain.model.Candidate;
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
    public Candidate save(Candidate candidate) {
        CandidateEntity ent = candidateMapper.toEntity(candidate);
        CandidateEntity saved = candidateJpaRepository.save(ent);
        return candidateMapper.toDomain(saved);
    }

    @Override
    public List<Candidate> findByElectionId(Long electionId) {
        return candidateJpaRepository.findByElectionId(electionId)
                .stream()
                .map(candidateMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Candidate findByName(String name) {
        return null;
    }

    @Override
    public Optional<Candidate> findById(Long id) {
        return Optional.empty();
    }
}
