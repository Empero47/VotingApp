// domain/model/ElectionModel.java
package com.bolton.votingapp.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectionModel {
    private Long id;
    private String name;
    private String description;
    private Date date;
    private boolean active;
    private List<CandidateModel> candidateModels = new ArrayList<>();
}
