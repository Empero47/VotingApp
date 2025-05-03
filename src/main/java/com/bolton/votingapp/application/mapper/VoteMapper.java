package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.Vote;
import com.bolton.votingapp.infrastructure.persistence.entity.VoteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface VoteMapper {
    VoteEntity toEntity(Vote vote);
    Vote toDomain(VoteEntity entity);
}
