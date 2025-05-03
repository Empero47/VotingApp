// application/mapper/ElectionMapper.java
package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.Election;
import com.bolton.votingapp.infrastructure.persistence.entity.ElectionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {CandidateMapper.class},
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ElectionMapper {
    ElectionEntity toEntity(Election domain);

    Election toDomain(ElectionEntity entity);
}
