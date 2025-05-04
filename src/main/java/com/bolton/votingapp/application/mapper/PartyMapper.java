package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.PartyModel;
import com.bolton.votingapp.infrastructure.persistence.entity.PartyEntity;
import com.bolton.votingapp.web.dto.PartyRequest;
import com.bolton.votingapp.web.dto.PartyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PartyMapper {
    PartyModel toModel(PartyRequest request);
    PartyModel toModel(PartyEntity partyEntity);
    PartyEntity toEntity(PartyModel partyModel);

    PartyResponse toResponse(PartyModel partyModel);
}