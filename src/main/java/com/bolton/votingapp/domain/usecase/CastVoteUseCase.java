package com.bolton.votingapp.domain.usecase;

import com.bolton.votingapp.domain.model.VoteModel;

public interface CastVoteUseCase {
    VoteModel castVote(Long voterId, Long candidateId);
}
