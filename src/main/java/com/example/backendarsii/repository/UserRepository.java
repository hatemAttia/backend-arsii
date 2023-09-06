package com.example.backendarsii.repository;

import com.example.backendarsii.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u from User u where u.role='MEMBER'")
    List<User> findAllMember();
    Optional<User> findByUserName (String userName);
    Optional<User> findByEmail (String email);

}