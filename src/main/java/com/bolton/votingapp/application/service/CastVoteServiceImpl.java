package com.bolton.votingapp.application.service;


import com.bolton.votingapp.domain.model.CandidateModel;
import com.bolton.votingapp.domain.model.VoteModel;
import com.bolton.votingapp.domain.model.VoterModel;
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
    public VoteModel castVote(Long voterId, Long candidateId) {
        VoterModel voterModel = voterRepository.findById(voterId).orElseThrow();
        CandidateModel candidateModel = candidateRepository.findById(candidateId).orElseThrow();

        if (voterModel.isHasVoted()) throw new IllegalStateException("Already voted");

        VoteModel voteModel = new VoteModel(null, voterModel.getId(), candidateModel.getId());
        voterModel.setHasVoted(true);
        candidateModel.setVoteCount(candidateModel.getVoteCount() + 1);

        voterRepository.save(voterModel);
        candidateRepository.save(candidateModel);
        return voteRepository.save(voteModel);
    }
}
