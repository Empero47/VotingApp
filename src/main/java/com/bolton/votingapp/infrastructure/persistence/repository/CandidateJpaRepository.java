package com.bolton.votingapp.infrastructure.persistence.repository;

import com.bolton.votingapp.infrastructure.persistence.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateJpaRepository
        extends JpaRepository<CandidateEntity, Long> {

    List<CandidateEntity> findByElectionId(Long electionId);
}
