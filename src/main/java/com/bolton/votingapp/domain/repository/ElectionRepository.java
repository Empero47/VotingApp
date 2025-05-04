package com.bolton.votingapp.domain.repository;

import com.bolton.votingapp.domain.model.ElectionModel;

import java.util.List;
import java.util.Optional;

public interface ElectionRepository {
    ElectionModel save(ElectionModel election);
    List<ElectionModel> getAllElections();
    Optional<ElectionModel> getById(Long electionId);
    ElectionModel updateElection(Long electionId, ElectionModel updatedElectionModel);
     void deleteById(Long electionId);
}
