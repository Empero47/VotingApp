package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.VoteModel;
import com.bolton.votingapp.infrastructure.persistence.entity.VoteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface VoteMapper {
    VoteEntity toEntity(VoteModel voteModel);
    VoteModel toDomain(VoteEntity entity);
}
