package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.domain.model.VoteModel;
import com.bolton.votingapp.domain.usecase.CastVoteUseCase;
import com.bolton.votingapp.web.dto.VoteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/votes")
public class VoteController {
    private final CastVoteUseCase castVote;


    @PostMapping
    public VoteModel cast(@RequestBody VoteRequest request) {
        return castVote.castVote(request.getVoterId(), request.getCandidateId());
    }
}
