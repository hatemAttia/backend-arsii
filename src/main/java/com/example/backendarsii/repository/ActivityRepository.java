package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ActivityRepository  extends JpaRepository<Activity, Long> {
    @Query("SELECT a FROM Activity a")
    List<Activity> findAllActivities();

     Optional<Activity> findById(Integer id);
    void deleteById(Integer id);
}
