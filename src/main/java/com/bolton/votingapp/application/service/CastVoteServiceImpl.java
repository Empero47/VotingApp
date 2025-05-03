package com.bolton.votingapp.application.service;


import com.bolton.votingapp.domain.model.Candidate;
import com.bolton.votingapp.domain.model.Vote;
import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.domain.usecase.CastVoteUseCase;
import com.bolton.votingapp.domain.repository.CandidateRepository;
import com.bolton.votingapp.domain.repository.VoteRepository;
import com.bolton.votingapp.domain.repository.VoterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CastVoteServiceImpl implements CastVoteUseCase {
    private final VoterRepository voterRepository;
    private final CandidateRepository candidateRepository;
    private final VoteRepository voteRepository;

//    public CastVoteServiceImpl(VoterRepository voterRepository, CandidateRepository candidateRepository, VoteRepository voteRepo) {
//        this.voterRepository = voterRepository;
//        this.candidateRepository = candidateRepository;
//        this.voteRepo = voteRepo;
//    }

    @Override
    public Vote castVote(Long voterId, Long candidateId) {
        Voter voter = voterRepository.findById(voterId).orElseThrow();
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow();

        if (voter.isHasVoted()) throw new IllegalStateException("Already voted");

        Vote vote = new Vote(null, voter.getId(), candidate.getId());
        voter.setHasVoted(true);
        candidate.setVoteCount(candidate.getVoteCount() + 1);

        voterRepository.save(voter);
        candidateRepository.save(candidate);
        return voteRepository.save(vote);
    }
}
