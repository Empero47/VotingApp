package com.bolton.votingapp.application.service;

import com.bolton.votingapp.domain.model.Vote;
import com.bolton.votingapp.domain.model.Candidate;
import com.bolton.votingapp.domain.repository.VoteRepository;
import com.bolton.votingapp.domain.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingService {

    private final VoteRepository voteRepository;
    private final CandidateRepository candidateRepository;

    public VotingService(VoteRepository voteRepository, CandidateRepository candidateRepository) {
        this.voteRepository = voteRepository;
        this.candidateRepository = candidateRepository;
    }

    // Fetch votes for an election
    public List<Vote> getVotesByElection(Long electionId) {
        return voteRepository.findByElectionId(electionId);
    }

    // Fetch candidates for an election
    public List<Candidate> getCandidatesByElection(Long electionId) {
        return candidateRepository.findByElectionId(electionId);
    }

    // Cast a vote (example service method)
    public void castVote(Vote vote) {
        voteRepository.save(vote);
    }
}
