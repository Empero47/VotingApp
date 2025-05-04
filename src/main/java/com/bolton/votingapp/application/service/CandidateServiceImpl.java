package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.repository.PartyRepository;
import com.bolton.votingapp.domain.model.CandidateModel;
import com.bolton.votingapp.domain.repository.CandidateRepository;
import com.bolton.votingapp.domain.repository.ElectionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final ElectionRepository electionRepository;
    private final PartyRepository partyRepository;


    @Override
    public List<CandidateModel> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<CandidateModel> findById(Long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public List<CandidateModel> findByElectionId(Long id) {
        return candidateRepository.findByElectionId(id);
    }

    @Override
    public CandidateModel save(CandidateModel candidateModel) {
        var election = electionRepository.getById(candidateModel.getElectionId())
                .orElseThrow(RuntimeException::new);

        var party = partyRepository.getById(candidateModel.getPartyId())
                .orElseThrow(RuntimeException::new);
        candidateModel.setElection(election);
        candidateModel.setParty(party);
        return candidateRepository.save(candidateModel);
    }

    @Override
    public CandidateModel update(Long id, CandidateModel candidateModel) {
        CandidateModel existing = candidateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CandidateModel not found"));
        existing.setName(candidateModel.getName());
//        existing.setParty(candidateModel.getParty());
        return candidateRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {
        candidateRepository.deleteById(id);
    }
}
