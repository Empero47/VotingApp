package com.bolton.votingapp.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Election {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Date date;
    private boolean active;

    @OneToMany(mappedBy = "election", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Candidate> candidates;

    // Constructor without candidates for easier creation
    public Election(String name, String description, Date date, boolean active) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.active = active;
        this.candidates = new ArrayList<>();
    }

    // Add candidate to election
    public void addCandidate(Candidate candidate) {
        if (candidates == null) {
            candidates = new ArrayList<>();
        }
        candidates.add(candidate);
        candidate.setElection(this);
    }

    // Remove candidate from election
    public void removeCandidate(Candidate candidate) {
        if (candidates != null) {
            candidates.remove(candidate);
            candidate.setElection(null);
        }
    }
}