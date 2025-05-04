package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.CandidateModel;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    List<CandidateModel> findAll();
    Optional<CandidateModel> findById(Long id);
    List<CandidateModel> findByElectionId(Long id);
    CandidateModel save(CandidateModel candidateModel);
    CandidateModel update(Long id, CandidateModel candidateModel);
    void deleteById(Long id);
}
