package com.bolton.votingapp.domain.model;

//import com.bolton.votingapp.domain.valueobject.Position;
import lombok.*;

@Getter
@Builder
public class CandidateModel {
    private Long id;
    @Setter
    private ElectionModel election;
    private Long electionId;
    @Setter
    private String name;
    @Setter
    private int voteCount;

//    private Position position;
}
