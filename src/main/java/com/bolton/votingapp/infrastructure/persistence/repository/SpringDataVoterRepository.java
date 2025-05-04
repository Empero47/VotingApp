//package com.bolton.votingapp.infrastructure.persistence.repository;
//
//import com.bolton.votingapp.domain.model.VoterModel;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//public interface SpringDataVoterRepository extends JpaRepository<VoterModel, Long> {
//    Optional<VoterModel> findByEmail(String email);
//    boolean existsByEmail(String email);
//}
