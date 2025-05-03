package com.bolton.votingapp.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    private Long id;
    private Election election;
    private String name;
    private int voteCount;

    public Candidate(Election election, String name) {
        this(null, election, name, 0);
    }

    public void incrementVote() {
        this.voteCount++;
    }
}
