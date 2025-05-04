package com.bolton.votingapp.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    private Long electionId;

    @Column(nullable = false)
    private String name;

    @Column(name = "vote_count", nullable = false)
    private int voteCount;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private ElectionEntity election;
}
