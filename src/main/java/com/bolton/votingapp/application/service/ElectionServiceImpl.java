package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.ElectionModel;
import com.bolton.votingapp.domain.repository.ElectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ElectionServiceImpl implements ElectionService {

    private final ElectionRepository electionRepository;

    @Override
    public ElectionModel createElection(ElectionModel electionModel) {
        return electionRepository.save(electionModel);
    }

    @Override
    public List<ElectionModel> getAllElections() {
        return electionRepository.getAllElections();
    }

    @Override
    public ElectionModel getElectionById(Long electionId) {
        return electionRepository.getById(electionId)
                .orElseThrow(() -> new RuntimeException("ElectionModel not found"));
    }

    @Override
    public ElectionModel updateElection(Long electionId, ElectionModel updatedElectionModel) {
        ElectionModel electionModel = getElectionById(electionId);
        electionModel.setTitle(updatedElectionModel.getTitle());
        electionModel.setDescription(updatedElectionModel.getDescription());
        electionModel.setStartDate(updatedElectionModel.getStartDate());
        electionModel.setEndDate(updatedElectionModel.getEndDate());
        electionModel.setActive(updatedElectionModel.isActive());
        electionRepository.save(electionModel);
        return electionModel;
    }

    @Override
    public void deleteElection(Long electionId) {
        electionRepository.deleteById(electionId);
    }
}

