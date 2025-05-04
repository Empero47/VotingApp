package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.ElectionModel;

import java.util.List;

public interface ElectionService {
    ElectionModel createElection(ElectionModel electionModel);
    List<ElectionModel> getAllElections();
    ElectionModel getElectionById(Long electionId);
    ElectionModel updateElection(Long electionId, ElectionModel updatedElectionModel);
    void deleteElection(Long electionId);
}
