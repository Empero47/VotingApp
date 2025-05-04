package com.bolton.votingapp.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class PartyRequest {
    private String title;
    private String description;
}
