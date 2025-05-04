package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.ElectionModel;
import com.bolton.votingapp.infrastructure.persistence.entity.ElectionEntity;
import com.bolton.votingapp.web.dto.ElectionRequest;
import com.bolton.votingapp.web.dto.ElectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = {CandidateMapper.class})
public interface ElectionMapper {
    ElectionModel toModel(ElectionRequest request);
    ElectionModel toModel(ElectionEntity electionEntity);
    ElectionEntity toEntity(ElectionModel electionModel);
    ElectionResponse toResponse(ElectionModel domain);
}