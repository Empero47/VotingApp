package com.bolton.votingapp.infrastructure.persistence.repository;

import com.bolton.votingapp.infrastructure.persistence.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateJpaRepository extends JpaRepository<CandidateEntity, Long> {

    List<CandidateEntity> findByElectionId(Long electionId);
    Optional<CandidateEntity> findByName(String name);
}
