package com.bolton.votingapp.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoterModel {
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean hasVoted;
}