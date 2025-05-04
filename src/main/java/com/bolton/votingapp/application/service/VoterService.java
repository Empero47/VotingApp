package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.VoterModel;

import java.util.List;

public interface VoterService {
    VoterModel registerVoter(VoterModel voterModel);
    boolean existsByEmail(String email); // Check if email exists
    List<VoterModel> getAllVoters(); // Get all voters
}
