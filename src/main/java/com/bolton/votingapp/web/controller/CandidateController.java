package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.application.mapper.CandidateMapper;
import com.bolton.votingapp.application.service.CandidateService;
import com.bolton.votingapp.domain.model.CandidateModel;
import com.bolton.votingapp.web.dto.CandidateRequest;
import com.bolton.votingapp.web.dto.CandidateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    private final CandidateService candidateService;
    private final CandidateMapper candidateMapper;


    // Create a new candidate
    @PostMapping
    public ResponseEntity<CandidateResponse> createCandidate(@RequestBody CandidateRequest candidateRequest) {
        CandidateModel candidateModel = candidateMapper.toModel(candidateRequest);
        CandidateModel createdCandidateModel = candidateService.save(candidateModel);
        return ResponseEntity.ok(candidateMapper.toResponse(createdCandidateModel));
    }

    // Get all candidates by election ID
    @GetMapping
    public ResponseEntity<List<CandidateResponse>> getCandidatesByElection(@RequestParam Long electionId) {
        List<CandidateResponse> candidateResponseList = candidateService.findByElectionId(electionId)
                .stream().map(candidateMapper::toResponse)
                .toList();

        return ResponseEntity.ok(candidateResponseList);
    }

//    // Increment vote count for a candidate
//    @PostMapping("/{candidateId}/vote")
//    public ResponseEntity<CandidateResponse> incrementVote(@PathVariable Long candidateId) {
//        CandidateModel updatedCandidateModel = candidateService.incrementVote(candidateId);
//        return ResponseEntity.ok(new CandidateResponse(updatedCandidateModel));
//    }
//
//    // Remove a candidate
//    @DeleteMapping("/{candidateId}")
//    public ResponseEntity<Void> removeCandidate(@PathVariable Long candidateId) {
//        candidateService.removeCandidate(candidateId);
//        return ResponseEntity.noContent().build();
//    }
}
