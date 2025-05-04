package com.bolton.votingapp.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class PartyModel {
    private Long id;
    private String title;
    private String description;
}
