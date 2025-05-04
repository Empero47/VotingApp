package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.CandidateModel;
import com.bolton.votingapp.infrastructure.persistence.entity.CandidateEntity;
import com.bolton.votingapp.web.dto.CandidateRequest;
import com.bolton.votingapp.web.dto.CandidateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CandidateMapper {
    CandidateModel toModel(CandidateRequest request);
    CandidateModel toModel(CandidateEntity candidateEntity);
    CandidateEntity toEntity(CandidateModel candidateModel);
    CandidateResponse toResponse(CandidateModel domain);
}