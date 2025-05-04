package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.CandidateModel;
import com.bolton.votingapp.infrastructure.persistence.entity.CandidateEntity;
import com.bolton.votingapp.web.dto.CandidateRequest;
import com.bolton.votingapp.web.dto.CandidateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {PartyMapper.class}, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CandidateMapper {
    CandidateModel toModel(CandidateRequest request);
    CandidateModel toModel(CandidateEntity candidateEntity);
    CandidateEntity toEntity(CandidateModel candidateModel);

    @Mapping(source = "election.title", target = "electionTitle")
    @Mapping(source = "election.description", target = "electionDescription")
    @Mapping(source = "election.id", target = "electionId")
    @Mapping(source = "party.id", target = "partyId")
    @Mapping(source = "party.title", target = "partyTitle")
    CandidateResponse toResponse(CandidateModel domain);
}