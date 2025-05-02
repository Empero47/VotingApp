package com.bolton.votingapp.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Voter voter;

    @ManyToOne
    private Candidate candidate;
}
