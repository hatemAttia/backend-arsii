package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventRepository  extends JpaRepository<Event,Long> {

    @Query("SELECT e FROM Event e WHERE e.status = :status")

    List<Event> findByStatus(boolean status);
    Optional<Event> findById(Integer eventId);

    void deleteById(Integer eventId);
}
