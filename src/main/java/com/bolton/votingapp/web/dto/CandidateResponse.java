package com.bolton.votingapp.web.dto;

import lombok.Data;

@Data
public class CandidateResponse {
    private Long id;
    private String name;
    private String party;
    private Long electionId;
}
