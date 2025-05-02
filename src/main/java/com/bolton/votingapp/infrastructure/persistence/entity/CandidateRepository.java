package com.bolton.votingapp.infrastructure.persistence.entity;

import com.bolton.votingapp.domain.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    // Find all candidates in a specific election
    List<Candidate> findByElectionId(Long electionId);

    // Find a candidate by their name
    Candidate findByName(String name);

    // Find a candidate by their ID (used for querying candidate details)
    Candidate findById(long id);
}
