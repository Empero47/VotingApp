package com.bolton.votingapp.domain.repository;

import com.bolton.votingapp.domain.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository {

    // Save votes
    Vote save(Vote vote);

    // Check if has voted
    boolean hasVoted(Long voterId);

    // Find all votes for a specific election or candidate
    List<Vote> findByElectionId(Long electionId);

    // Find all votes cast by a specific voter
    List<Vote> findByVoterId(Long voterId);

    // Find a vote by its ID (used for checking if a vote exists)
    Vote findById(long id);
}
