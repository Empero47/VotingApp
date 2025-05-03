package com.bolton.votingapp.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    private Long id;
    private Long electionId;
    private String name;
    private int voteCount;

    public Candidate(Long electionId, String name) {
        this(null, electionId, name, 0);
    }

    public void incrementVote() {
        this.voteCount++;
    }
}
