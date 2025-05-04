package com.bolton.votingapp.infrastructure.persistence.repository;

import com.bolton.votingapp.infrastructure.persistence.entity.ElectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionJpaRepository extends JpaRepository <ElectionEntity, Long>{
}
