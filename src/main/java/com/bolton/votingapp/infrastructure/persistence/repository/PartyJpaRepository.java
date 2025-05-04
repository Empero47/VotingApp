package com.bolton.votingapp.infrastructure.persistence.repository;

import com.bolton.votingapp.infrastructure.persistence.entity.PartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyJpaRepository extends JpaRepository<PartyEntity, Long> {
}