package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.application.service.VoterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voters")
public class VoterController {

    private final VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @PostMapping
    public ResponseEntity<Voter> register(@RequestBody Voter voter) {
        if (voterService.existsByEmail(voter.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(voterService.registerVoter(voter));
    }

    @GetMapping
    public List<Voter> getAllVoters() {
        return voterService.getAllVoters();
    }
}
