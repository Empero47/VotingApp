package com.bolton.votingapp.domain.model;

import lombok.*;

@Getter
@Builder
public class CandidateModel {
    private Long id;
    @Setter
    private ElectionModel election;
    private Long electionId;
    @Setter
    private PartyModel party;
    @Setter
    private Long partyId;
    @Setter
    private String name;
    @Setter
    private int voteCount;
}
