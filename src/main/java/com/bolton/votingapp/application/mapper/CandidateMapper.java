package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.Candidate;
import com.bolton.votingapp.web.dto.CandidateRequest;
import com.bolton.votingapp.web.dto.CandidateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CandidateMapper {
    Candidate toDomain(CandidateRequest request);
    CandidateResponse toResponse(Candidate domain);
}