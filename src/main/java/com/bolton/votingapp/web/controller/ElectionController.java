package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.application.service.ElectionService;
import com.bolton.votingapp.domain.model.Election;
import com.bolton.votingapp.web.dto.ElectionRequest;
import com.bolton.votingapp.web.dto.ElectionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/elections")
public class ElectionController {
    private final ElectionService electionService;


    // Create a new election
    @PostMapping
    public ResponseEntity<ElectionResponse> createElection(@RequestBody ElectionRequest electionRequest) {
        Election election = new Election(electionRequest.getTitle(), electionRequest.getDescription(),
                electionRequest.getStartDate(), electionRequest.isActive());
        Election createdElection = electionService.createElection(election);
        return ResponseEntity.ok(new ElectionResponse(createdElection));
    }

    // Get all elections
    @GetMapping
    public ResponseEntity<List<ElectionResponse>> getAllElections() {
        List<Election> elections = electionService.getAllElections();
        List<ElectionResponse> response = elections.stream()
                .map(ElectionResponse::new)
                .toList();
        return ResponseEntity.ok(response);
    }

    // Get election by ID
    @GetMapping("/{electionId}")
    public ResponseEntity<ElectionResponse> getElectionById(@PathVariable Long electionId) {
        Election election = electionService.getElectionById(electionId);
        return ResponseEntity.ok(new ElectionResponse(election));
    }

    // Update election
    @PutMapping("/{electionId}")
    public ResponseEntity<ElectionResponse> updateElection(@PathVariable Long electionId, @RequestBody ElectionRequest electionRequest) {
        Election election = new Election(electionRequest.getTitle(), electionRequest.getDescription(),
                electionRequest.getStartDate(), electionRequest.isActive());
        Election updatedElection = electionService.updateElection(electionId, election);
        return ResponseEntity.ok(new ElectionResponse(updatedElection));
    }

    // Delete an election
    @DeleteMapping("/{electionId}")
    public ResponseEntity<Void> deleteElection(@PathVariable Long electionId) {
        electionService.deleteElection(electionId);
        return ResponseEntity.noContent().build();
    }
}
