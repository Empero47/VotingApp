package com.bolton.votingapp.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
    private Long id;
    private Long voterId;
    private Long candidateId;
}
