// domain/model/Election.java
package com.bolton.votingapp.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Election {
    private Long id;
    private String name;
    private String description;
    private Date date;
    private boolean active;
    private List<Candidate> candidates = new ArrayList<>();

    public Election(String name, String description, Date date, boolean active) {
        this(null, name, description, date, active, new ArrayList<>());
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public void removeCandidate(Candidate candidate) {
        candidates.remove(candidate);
    }
}
