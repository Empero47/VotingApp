package com.bolton.votingapp.domain.repository;

import com.bolton.votingapp.domain.model.PartyModel;

import java.util.Optional;

public interface PartyRepository {

    PartyModel save(PartyModel partyModel);
    Optional<PartyModel> getById(Long partyId);

}
