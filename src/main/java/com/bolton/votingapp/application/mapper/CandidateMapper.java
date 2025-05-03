package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.Candidate;
import com.bolton.votingapp.infrastructure.persistence.entity.CandidateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CandidateMapper {

//    @Mapping(source = "electionId", target = "electionId")
    Candidate toDomain(CandidateEntity entity);

//    @Mapping(source = "electionId", target = "electionId")
    CandidateEntity toEntity(Candidate domain);
}
