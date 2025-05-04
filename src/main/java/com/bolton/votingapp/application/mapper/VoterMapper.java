package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.VoterModel;
import com.bolton.votingapp.infrastructure.persistence.entity.VoterEntity;
import com.bolton.votingapp.web.dto.VoterRequest;
import com.bolton.votingapp.web.dto.VoterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface VoterMapper {

    // DTO mappings
    VoterModel toDomain(VoterRequest request);
    VoterResponse toResponse(VoterModel voterModel);

    // Persistence mappings
    VoterEntity toEntity(VoterModel voterModel);
    VoterModel toDomain(VoterEntity entity);
    VoterRequest toRequest(VoterModel voterModel);
    List<VoterModel> toDomainList(List<VoterEntity> entities);

}
