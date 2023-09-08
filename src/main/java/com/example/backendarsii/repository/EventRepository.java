package com.example.backendarsii.repository;

import com.example.backendarsii.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
