package com.bolton.votingapp.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class VoterResponse {
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean hasVoted;
}