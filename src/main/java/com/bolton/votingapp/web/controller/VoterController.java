package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.application.service.VoterService;
import com.bolton.votingapp.application.mapper.VoterMapper;
import com.bolton.votingapp.domain.model.Voter;
import com.bolton.votingapp.web.dto.VoterRequest;
import com.bolton.votingapp.web.dto.VoterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/voters")
public class VoterController {

    private final VoterService voterService;
    private final VoterMapper voterMapper;

    public VoterController(VoterService voterService, VoterMapper voterMapper) {
        this.voterService = voterService;
        this.voterMapper = voterMapper;
    }

    @PostMapping
    public ResponseEntity<VoterResponse> register(@RequestBody VoterRequest request) {
        if (voterService.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        Voter voter = voterService.registerVoter(voterMapper.toDomain(request));
        return ResponseEntity.ok(voterMapper.toResponse(voter));
    }

    @GetMapping
    public List<VoterResponse> getAllVoters() {
        return voterService.getAllVoters()
                .stream()
                .map(voterMapper::toResponse)
                .collect(Collectors.toList());
    }
}
