package com.example.backendarsii.repository;

import com.example.backendarsii.entity.UserEvent;
import com.example.backendarsii.entity.UserFormation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFormationRepository extends JpaRepository<UserFormation,Long> {
    List<UserFormation> findAllByUserId(Long id);
    List<UserFormation> findAllByFormationId(Long id);

}
