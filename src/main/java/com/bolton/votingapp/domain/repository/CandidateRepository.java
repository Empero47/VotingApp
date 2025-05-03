package com.bolton.votingapp.domain.repository;

import com.bolton.votingapp.domain.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository{

    // Save Candidates
    Candidate save(Candidate candidate);

    // Find all candidates in a specific election
    List<Candidate> findByElectionId(Long electionId);

    // Find a candidate by their name
    Candidate findByName(String name);

    // Find a candidate by their ID (used for querying candidate details)
//    Candidate findById(Long id);
    Optional<Candidate> findById(Long id);
}