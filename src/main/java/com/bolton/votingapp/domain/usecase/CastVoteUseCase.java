package com.bolton.votingapp.domain.usecase;

import com.bolton.votingapp.domain.model.Vote;

public interface CastVoteUseCase {
    Vote castVote(Long voterId, Long candidateId);
}
