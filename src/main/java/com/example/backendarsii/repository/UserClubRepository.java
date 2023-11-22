package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Club;
import com.example.backendarsii.entity.User;
import com.example.backendarsii.entity.UserClub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserClubRepository extends JpaRepository<UserClub, Long> {

    List<UserClub> findByUserId(UUID id);

    boolean existsByUserAndClub(User user, Club club);

    List<UserClub> findAllByClubId(Long clubId);

    List<UserClub> findByUser(User user);
}
