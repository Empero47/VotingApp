package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.Voter;
import java.util.List;

public interface VoterService {
    Voter registerVoter(Voter voter);
    boolean existsByEmail(String email); // Check if email exists
    List<Voter> getAllVoters(); // Get all voters
}
