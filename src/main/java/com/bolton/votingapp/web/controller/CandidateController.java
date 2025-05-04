package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.application.service.CandidateService;
import com.bolton.votingapp.domain.model.Candidate;
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


    // Create a new candidate
    @PostMapping
    public ResponseEntity<CandidateResponse> createCandidate(@RequestBody CandidateRequest candidateRequest, @RequestParam Long electionId) {
        Candidate candidate = new Candidate();
        candidate.setName(candidateRequest.getName());
        candidate.setParty(candidateRequest.getParty());
        Candidate createdCandidate = candidateService.createCandidate(candidate, electionId);
        return ResponseEntity.ok(new CandidateResponse(createdCandidate));
    }

    // Get all candidates by election ID
    @GetMapping
    public ResponseEntity<List<CandidateResponse>> getCandidatesByElection(@RequestParam Long electionId) {
        List<Candidate> candidates = candidateService.getCandidatesByElection(electionId);
        List<CandidateResponse> response = candidates.stream()
                .map(CandidateResponse::new)
                .toList();
        return ResponseEntity.ok(response);
    }

    // Increment vote count for a candidate
    @PostMapping("/{candidateId}/vote")
    public ResponseEntity<CandidateResponse> incrementVote(@PathVariable Long candidateId) {
        Candidate updatedCandidate = candidateService.incrementVote(candidateId);
        return ResponseEntity.ok(new CandidateResponse(updatedCandidate));
    }

    // Remove a candidate
    @DeleteMapping("/{candidateId}")
    public ResponseEntity<Void> removeCandidate(@PathVariable Long candidateId) {
        candidateService.removeCandidate(candidateId);
        return ResponseEntity.noContent().build();
    }
}
