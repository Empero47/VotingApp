package com.bolton.votingapp.web.dto;

import lombok.Data;

@Data
public class CandidateResponse {
    private Long id;
    private String name;
    private String partyTitle;
    private String partyId;
    private String electionTitle;
    private Long electionId;
    private String electionDescription;
}
