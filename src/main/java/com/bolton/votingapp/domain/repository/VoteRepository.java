package com.bolton.votingapp.domain.repository;

import com.bolton.votingapp.domain.model.VoteModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository {

    // Save votes
    VoteModel save(VoteModel voteModel);

    // Check if has voted
    boolean hasVoted(Long voterId);

    // Find all votes for a specific election or candidate
    List<VoteModel> findByElectionId(Long electionId);

    // Find all votes cast by a specific voter
    List<VoteModel> findByVoterId(Long voterId);

    // Find a vote by its ID (used for checking if a vote exists)
    VoteModel findById(long id);
}
