package com.example.backendarsii.repository;

import com.example.backendarsii.entity.UserCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserCompetenceRepository extends JpaRepository<UserCompetence, Long> {

    List<UserCompetence> findAllByUserId(UUID id);

    List<UserCompetence> findAllByCompetenceId(Long id);

}
