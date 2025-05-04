package com.bolton.votingapp.domain.model;

import lombok.*;

@Getter
@Builder
public class CandidateModel {
    private Long id;
    private ElectionModel electionModel;
    @Setter
    private String name;
    @Setter
    private int voteCount;
}
