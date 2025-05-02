package com.bolton.votingapp.infrastructure.persistence.entity;

import com.bolton.votingapp.domain.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataVoterRepository extends JpaRepository<Voter, Long> {
    Optional<Voter> findByEmail(String email);
    boolean existsByEmail(String email);
}
