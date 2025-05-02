package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.domain.model.Vote;
import com.bolton.votingapp.domain.usecase.CastVoteUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
public class VoteController {
    private final CastVoteUseCase castVote;

    public VoteController(CastVoteUseCase castVote) {
        this.castVote = castVote;
    }

    @PostMapping
    public Vote cast(@RequestParam Long voterId, @RequestParam Long candidateId) {
        return castVote.castVote(voterId, candidateId);
    }
}
