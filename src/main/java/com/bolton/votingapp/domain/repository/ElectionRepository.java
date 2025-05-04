package com.bolton.votingapp.domain.repository;

import com.bolton.votingapp.domain.model.ElectionModel;
import com.bolton.votingapp.infrastructure.persistence.entity.ElectionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectionRepository {
    ElectionModel save(ElectionEntity election);
    List<ElectionModel> getAllElections();
    Optional<ElectionModel> getElectionById(Long electionId);
    ElectionModel updateElection(Long electionId, ElectionModel updatedElectionModel);
    public void deleteElection(Long electionId);
}
