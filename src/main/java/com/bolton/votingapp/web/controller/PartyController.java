package com.bolton.votingapp.web.controller;

import com.bolton.votingapp.application.mapper.PartyMapper;
import com.bolton.votingapp.application.service.PartyService;
import com.bolton.votingapp.web.dto.PartyRequest;
import com.bolton.votingapp.web.dto.PartyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/parties")
public class PartyController {
    private final PartyService partyService;
    private final PartyMapper partyMapper;

    @PostMapping
    public ResponseEntity<PartyResponse> create(@RequestBody PartyRequest partyRequest) {
        return ResponseEntity.ok(partyMapper.toResponse(partyService.save(partyMapper.toModel(partyRequest))));
    }

    @GetMapping
    public ResponseEntity<PartyResponse> getById(@RequestParam Long id) {
        return partyService.findById(id)
                .map(partyMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }
}
