package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.PartyModel;

import java.util.Optional;

public interface PartyService {
    Optional<PartyModel> findById(Long id);
    PartyModel save(PartyModel partyModel);
}
