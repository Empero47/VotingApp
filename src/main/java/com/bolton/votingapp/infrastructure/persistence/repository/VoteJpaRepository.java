package com.bolton.votingapp.infrastructure.persistence.repository;

import com.bolton.votingapp.infrastructure.persistence.entity.VoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteJpaRepository extends JpaRepository<VoteEntity, Long> {
    boolean existsByVoterId(Long voterId);
}
