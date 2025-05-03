package com.bolton.votingapp.infrastructure.persistence.repository;

import com.bolton.votingapp.infrastructure.persistence.entity.VoterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoterJpaRepository extends JpaRepository<VoterEntity, Long> {
    Optional<VoterEntity> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<VoterEntity> findById(Long id);

}
