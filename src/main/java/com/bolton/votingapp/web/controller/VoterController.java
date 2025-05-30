package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.application.service.VoterService;
import com.bolton.votingapp.application.mapper.VoterMapper;
import com.bolton.votingapp.domain.model.VoterModel;
import com.bolton.votingapp.web.dto.VoterRequest;
import com.bolton.votingapp.web.dto.VoterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/voters")
public class VoterController {

    private final VoterService voterService;
    private final VoterMapper voterMapper;


    @PostMapping
    public ResponseEntity<VoterResponse> register(@RequestBody VoterRequest request) {
        if (voterService.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        VoterModel voterModel = voterService.registerVoter(voterMapper.toDomain(request));
        return ResponseEntity.ok(voterMapper.toResponse(voterModel));
    }

    @GetMapping
    public List<VoterResponse> getAllVoters() {
        return voterService.getAllVoters()
                .stream()
                .map(voterMapper::toResponse)
                .collect(Collectors.toList());
    }
}
