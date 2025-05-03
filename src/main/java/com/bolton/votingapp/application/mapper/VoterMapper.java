package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.infrastructure.persistence.entity.VoterEntity;
import com.bolton.votingapp.web.dto.VoterRequest;
import com.bolton.votingapp.web.dto.VoterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface VoterMapper {

    // DTO mappings
    Voter toDomain(VoterRequest request);
    VoterResponse toResponse(Voter voter);

    // Persistence mappings
    VoterEntity toEntity(Voter voter);
    Voter toDomain(VoterEntity entity);
    VoterRequest toRequest(Voter voter);
    List<Voter> toDomainList(List<VoterEntity> entities);

}
