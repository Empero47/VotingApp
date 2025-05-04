package com.bolton.votingapp.domain.repository;

import com.bolton.votingapp.domain.model.Election;
import com.bolton.votingapp.infrastructure.persistence.entity.ElectionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionRepository {
    public Election save(ElectionEntity election);
    public List<Election> getAllElections();
    Election getElectionById(Long electionId);
    Election updateElection(Long electionId, Election updatedElection);
    public void deleteElection(Long electionId);
}
