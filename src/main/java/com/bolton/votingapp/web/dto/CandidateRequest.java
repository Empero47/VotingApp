package com.bolton.votingapp.web.dto;

import lombok.Data;

@Data
public class CandidateRequest {
    private String name;
    private String party;
    private Long electionId;
}