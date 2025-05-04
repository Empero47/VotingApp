package com.bolton.votingapp.domain.repository;

import com.bolton.votingapp.domain.model.CandidateModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository{

    // Save Candidates
    CandidateModel save(CandidateModel candidateModel);

    // Find all candidates in a specific election
    List<CandidateModel> findByElectionId(Long electionId);

    // Find a candidate by their name
    CandidateModel findByName(String name);

    // Find a candidate by their ID (used for querying candidate details)
//    CandidateModel findById(Long id);
    Optional<CandidateModel> findById(Long id);

    List<CandidateModel> findAll();
    void deleteById(Long id);
}