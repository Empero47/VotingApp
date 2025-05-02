package com.bolton.votingapp.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Voter {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean hasVoted;
}
