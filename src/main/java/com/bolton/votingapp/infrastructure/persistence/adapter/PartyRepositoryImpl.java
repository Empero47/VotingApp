package com.bolton.votingapp.infrastructure.persistence.adapter;

import com.bolton.votingapp.application.mapper.PartyMapper;
import com.bolton.votingapp.domain.model.PartyModel;
import com.bolton.votingapp.domain.repository.PartyRepository;
import com.bolton.votingapp.infrastructure.persistence.repository.PartyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class PartyRepositoryImpl implements PartyRepository {

    private final PartyJpaRepository partyJpaRepository;
    private final PartyMapper partyMapper;

    @Override
    public PartyModel save(PartyModel partyModel) {
        return partyMapper.toModel(
                partyJpaRepository.save(partyMapper.toEntity(partyModel))
        );
    }

    @Override
    public Optional<PartyModel> getById(Long partyId) {
        return partyJpaRepository.findById(partyId)
                .map(partyMapper::toModel);
    }
}
