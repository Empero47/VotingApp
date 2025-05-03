package com.bolton.votingapp.infrastructure.persistence.adapter;

import com.bolton.votingapp.application.mapper.VoteMapper;
import com.bolton.votingapp.domain.model.Vote;
import com.bolton.votingapp.infrastructure.persistence.repository.VoteJpaRepository;
import com.bolton.votingapp.domain.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class VoteRepositoryImpl implements VoteRepository {

    private final VoteJpaRepository voteJpaRepository;
    private final VoteMapper voteMapper;

    @Override
    public Vote save(Vote vote) {
        return voteMapper.toDomain(voteJpaRepository.save(voteMapper.toEntity(vote)));
    }

    @Override
    public boolean hasVoted(Long voterId) {
        return voteJpaRepository.existsByVoterId(voterId);
    }
}