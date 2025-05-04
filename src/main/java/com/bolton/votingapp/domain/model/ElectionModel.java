// domain/model/ElectionModel.java
package com.bolton.votingapp.domain.model;

import com.bolton.votingapp.domain.valueobject.Position;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectionModel {
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
    private List<CandidateModel> candidateModels = new ArrayList<>();
}
