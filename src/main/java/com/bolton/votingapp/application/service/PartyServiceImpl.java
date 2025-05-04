package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.PartyModel;
import com.bolton.votingapp.domain.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService{

    private final PartyRepository partyRepository;

    @Override
    public Optional<PartyModel> findById(Long id) {
        return partyRepository.getById(id);
    }

    @Override
    public PartyModel save(PartyModel partyModel) {
        return partyRepository.save(partyModel);
    }
}
