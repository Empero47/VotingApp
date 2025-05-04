package com.bolton.votingapp.application.service;

import com.bolton.votingapp.application.mapper.ElectionMapper;
import com.bolton.votingapp.domain.model.ElectionModel;
import com.bolton.votingapp.domain.repository.ElectionRepository;
import com.bolton.votingapp.infrastructure.persistence.entity.ElectionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ElectionServiceImpl implements ElectionService {

    private final ElectionRepository electionRepository;
    private final ElectionMapper electionMapper;

    @Override
    public ElectionModel createElection(ElectionModel electionModel) {
        ElectionEntity electionEntity = electionMapper.toEntity(electionModel);
        electionRepository.save(electionEntity);
        return electionMapper.toModel(electionEntity);
    }

    @Override
    public List<ElectionModel> getAllElections() {
        return electionRepository.getAllElections();
    }

    @Override
    public ElectionModel getElectionById(Long electionId) {
        return electionRepository.getElectionById(electionId)
                .orElseThrow(() -> new RuntimeException("ElectionModel not found"));
    }

    @Override
    public ElectionModel updateElection(Long electionId, ElectionModel updatedElectionModel) {
        ElectionModel electionModel = getElectionById(electionId);
        electionModel.setName(updatedElectionModel.getName());
        electionModel.setDescription(updatedElectionModel.getDescription());
        electionModel.setDate(updatedElectionModel.getDate());
        electionModel.setActive(updatedElectionModel.isActive());
        electionRepository.save(electionMapper.toEntity(electionModel));
        return electionModel;
    }

    @Override
    public void deleteElection(Long electionId) {
        electionRepository.deleteElection(electionId);
    }
}

