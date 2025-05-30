package com.bolton.votingapp.infrastructure.persistence.adapter;

import com.bolton.votingapp.application.mapper.VoteMapper;
import com.bolton.votingapp.domain.model.VoteModel;
import com.bolton.votingapp.infrastructure.persistence.repository.VoteJpaRepository;
import com.bolton.votingapp.domain.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VoteRepositoryImpl implements VoteRepository {

    private final VoteJpaRepository voteJpaRepository;
    private final VoteMapper voteMapper;

    @Override
    public VoteModel save(VoteModel voteModel) {
        return voteMapper.toDomain(voteJpaRepository.save(voteMapper.toEntity(voteModel)));
    }

    @Override
    public boolean hasVoted(Long voterId) {
        return voteJpaRepository.existsByVoterId(voterId);
    }

    @Override
    public List<VoteModel> findByElectionId(Long electionId) {
        return List.of();
    }

    @Override
    public List<VoteModel> findByVoterId(Long voterId) {
        return List.of();
    }

    @Override
    public VoteModel findById(long id) {
        return null;
    }
}