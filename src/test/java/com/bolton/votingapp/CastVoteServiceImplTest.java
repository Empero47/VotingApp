//package com.bolton.votingapp;
//
//import com.bolton.votingapp.application.service.CastVoteServiceImpl;
//import com.bolton.votingapp.domain.model.CandidateModel;
//import com.bolton.votingapp.domain.model.VoteModel;
//import com.bolton.votingapp.domain.model.VoterModel;
//import com.bolton.votingapp.domain.repository.CandidateRepository;
//import com.bolton.votingapp.domain.repository.VoteRepository;
//import com.bolton.votingapp.domain.repository.VoterRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.hamcrest.Matchers.any;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//class CastVoteServiceImplTest {
//
//    @Mock
//    VoterRepository voterRepo;
//    @Mock
//    CandidateRepository candidateRepo;
//    @Mock
//    VoteRepository voteRepo;
//
//    @InjectMocks
//    CastVoteServiceImpl service;
//
//    @Test
//    void castVote_success() {
//        VoterModel voter = new VoterModel(1L, "John", "a@b.com", "pass", false);
//        CandidateModel candidate = new CandidateModel(2L, "Alice", 0);
//        Mockito.when(voterRepo.findById(1L)).thenReturn(Optional.of(voter));
////        Mockito.when(candidateRepo.findById(2L)).thenReturn(Optional.of(candidate));
////        Mockito.when(voteRepo.save(any(VoteModel.class))).thenAnswer(i -> i.getArgument(0));
//
//        VoteModel vote = service.castVote(1L, 2L);
//
//        assertThat(voter.isHasVoted()).isTrue();
//        assertThat(candidate.getVoteCount()).isEqualTo(1);
//        verify(voterRepo).save(voter);
//        verify(candidateRepo).save(candidate);
//        verify(voteRepo).save(vote);
//    }
//
//    @Test
//    void castVote_alreadyVoted_throws() {
//        VoterModel voter = new VoterModel(1L, "Emmanuel", "a@b.com", "pass", true);
//        Mockito.when(voterRepo.findById(1L)).thenReturn(Optional.of(voter));
//
//        assertThrows(IllegalStateException.class, () ->
//                service.castVote(1L, 2L)
//        );
//    }
//}
