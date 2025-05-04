package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.application.mapper.ElectionMapper;
import com.bolton.votingapp.application.service.ElectionService;
import com.bolton.votingapp.domain.model.ElectionModel;
import com.bolton.votingapp.web.dto.ElectionRequest;
import com.bolton.votingapp.web.dto.ElectionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/elections")
public class ElectionController {
    private final ElectionService electionService;
    private final ElectionMapper electionMapper;


    // Create a new election
    @PostMapping
    public ResponseEntity<ElectionResponse> createElection(@RequestBody ElectionRequest electionRequest) {
        ElectionModel electionModel = electionMapper.toModel(electionRequest);
        ElectionResponse electionResponse = electionMapper.toResponse(electionService.createElection(electionModel));
        return ResponseEntity.ok(electionResponse);
    }

    // Get all elections
    @GetMapping
    public ResponseEntity<List<ElectionResponse>> getAllElections() {
        List<ElectionResponse> electionResponses = electionService.getAllElections()
                .stream().map(electionMapper::toResponse)
                .toList();

        return ResponseEntity.ok(electionResponses);
    }

    // Get election by ID
    @GetMapping("/{electionId}")
    public ResponseEntity<ElectionResponse> getElectionById(@PathVariable Long electionId) {
        ElectionResponse electionResponse = electionMapper.toResponse(electionService.getElectionById(electionId));
        return ResponseEntity.ok(electionResponse);
    }

//    // Update election
//    @PutMapping("/{electionId}")
//    public ResponseEntity<ElectionResponse> updateElection(@PathVariable Long electionId, @RequestBody ElectionRequest electionRequest) {
//        ElectionModel electionModel = new ElectionModel(electionRequest.getTitle(), electionRequest.getDescription(),
//                electionRequest.getStartDate(), electionRequest.isActive());
//        ElectionModel updatedElectionModel = electionService.updateElection(electionId, electionModel);
//        return ResponseEntity.ok(new ElectionResponse(updatedElectionModel));
//    }
//
//    // Delete an election
//    @DeleteMapping("/{electionId}")
//    public ResponseEntity<Void> deleteElection(@PathVariable Long electionId) {
//        electionService.deleteElection(electionId);
//        return ResponseEntity.noContent().build();
//    }
}
