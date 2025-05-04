package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.Election;
import com.bolton.votingapp.web.dto.ElectionRequest;
import com.bolton.votingapp.web.dto.ElectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = {CandidateMapper.class})
public interface ElectionMapper {
    Election toDomain(ElectionRequest request);
    ElectionResponse toResponse(Election domain);
}