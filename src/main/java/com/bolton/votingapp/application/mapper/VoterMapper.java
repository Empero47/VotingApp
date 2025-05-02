package com.bolton.votingapp.application.mapper;

import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.web.dto.VoterRequest;
import com.bolton.votingapp.web.dto.VoterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoterMapper {

    Voter toVoter(VoterRequest request);

    VoterResponse toResponse(Voter voter);
}
