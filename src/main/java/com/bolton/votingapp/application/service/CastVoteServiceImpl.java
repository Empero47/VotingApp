package com.bolton.votingapp.application.service;


import com.bolton.votingapp.domain.model.Candidate;
import com.bolton.votingapp.domain.model.Vote;
import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.domain.usecase.CastVoteUseCase;
import com.bolton.votingapp.infrastructure.persistence.entity.*;
import org.springframework.stereotype.Service;

@Service
public class CastVoteServiceImpl implements CastVoteUseCase {
    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepo;
    private final VoteRepository voteRepo;

    public CastVoteServiceImpl(VoterRepository voterRepository, CandidateRepository candidateRepo, VoteRepository voteRepo) {
        this.voterRepository = voterRepository;
        this.candidateRepo = candidateRepo;
        this.voteRepo = voteRepo;
    }

    @Override
    public Vote castVote(Long voterId, Long candidateId) {
        Voter voter = voterRepository.findById(voterId).orElseThrow();
        Candidate candidate = candidateRepo.findById(candidateId).orElseThrow();

        if (voter.isHasVoted()) throw new IllegalStateException("Already voted");

        Vote vote = new Vote(null, voter, candidate);
        voter.setHasVoted(true);
        candidate.setVoteCount(candidate.getVoteCount() + 1);

        voterRepository.save(voter);
        candidateRepo.save(candidate);
        return voteRepo.save(vote);
    }
}
