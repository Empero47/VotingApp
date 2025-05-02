package com.bolton.votingapp.web.dto;

import lombok.Data;

@Data
public class VoterRequest {
    private String name;
    private String email;
    private String password;
}
